package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @Before
    public void setupBefore(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        produtoPage = new ProdutoPage(driver);
        carrinhoPage = new CarrinhoPage(driver);

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

    @Quando("estiver no carrinho acrescentar e retirar produto\\/quantidade")
    public void estiverNoCarrinhoAcrescentarERetirarProdutoQuantidade() throws InterruptedException {
        carrinhoPage.aumentarQtdItem();
        carrinhoPage.adicionandoSegundoProduto();
        carrinhoPage.fechandoPedidoECriandoConta();
    }

    @E("clicar em finalizar a conta indo para a tela de acesso")
    public void clicarEmFinalizarAContaIndoParaATelaDeAcesso() {
    }

    @E("criar conta usando email")
    public void criarContaUsandoEmail() {
    }

    @E("concluir as etapas de criacao")
    public void concluirAsEtapasDeCriacao() {
    }

    @E("endereco de entrega")
    public void enderecoDeEntrega() {
    }

    @E("dados do cartao")
    public void dadosDoCartao() {
    }

    @Entao("verifica se chegou na etapa final da compra")
    public void verificaSeChegouNaEtapaFinalDaCompra() {

    }

    @After
    public void after () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
