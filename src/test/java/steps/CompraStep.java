package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CadastroPage;
import pages.CarrinhoPage;
import pages.HomePage;
import pages.ProdutoPage;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class CompraStep {
    WebDriver driver;
    HomePage homePage;
    ProdutoPage produtoPage;
    CarrinhoPage carrinhoPage;
    CadastroPage cadastroPage;
    String mensagemTela = "Já existe uma conta com esse e-mail";

    @Before
    public void setupBefore(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        produtoPage = new ProdutoPage(driver);
        carrinhoPage = new CarrinhoPage(driver);
        cadastroPage = new CadastroPage(driver);
    }

    @Dado("que esteja na pagina inicial {string}")
    public void queEstejaNaPaginaInicial(String url) {
        driver.get(url);
    }

    @E("clicar em pesquisa para pegar produto")
    public void clicarEmPesquisaParaPegarProduto() throws InterruptedException, FileNotFoundException {
        homePage.clicarEPesquisarProduto();
        homePage.selecionarPrimeiroProduto();
    }

    @E("adicionar ele ao carrinho")
    public void adicionarEleAoCarrinho() throws InterruptedException {
        produtoPage.adicionandoNoCarrinho();
        produtoPage.indoParaCarrinho();
    }

    @Quando("estiver no carrinho acrescentar e retirar produto\\/quantidade e fechar carrinho")
    public void estiverNoCarrinhoAcrescentarERetirarProdutoQuantidade() throws InterruptedException {
        carrinhoPage.aumentarQtdItem();
        carrinhoPage.adicionandoSegundoProduto();
        carrinhoPage.fechandoPedidoECriandoConta();
    }

    @E("criar conta")
    public void clicarEmFinalizarAContaIndoParaATelaDeAcesso() throws FileNotFoundException, InterruptedException {
        cadastroPage.inserindoInformacoesCadastro();
    }


    @Entao("verifica se chegou na etapa final da compra")
    public void verificaSeChegouNaEtapaFinalDaCompra() {
        Assert.assertTrue(driver.getPageSource().contains(mensagemTela));
    }

    @After
    public void after () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
