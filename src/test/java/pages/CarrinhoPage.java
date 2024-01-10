package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoPage {
    WebDriver driver;
    String botaoQtd = "//*[@id=\"a-autoid-0-announce\"]/span[1]";
    String botaoQtdProduto3 = "//*[@id=\"a-popover-1\"]/div/div/ul/li[4]";
    String adicionarSegundoProduto = "//*[@id=\"a-autoid-3\"]/span/input";
    String irParaCarrinho = "//*[@id=\"sw-gtc\"]/span/a";
    String excluirItemCarrinho = "//body/div[@id='a-page']/div[1]/div[3]/div[5]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/span[2]/span[1]/input[1]";
    String fecharPedido = "//*[@id=\"sc-buy-box-ptc-button\"]/span/input";
    String criarConta = "//a[@id='createAccountSubmit']";

    public CarrinhoPage (WebDriver driverVindoDoTeste) {this.driver = driverVindoDoTeste;}

    public void aumentarQtdItem () throws InterruptedException {
        driver.findElement(By.xpath(botaoQtd)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(botaoQtdProduto3)).click();
        Thread.sleep(3000);
    }

    public void adicionandoSegundoProduto () throws InterruptedException {
        driver.findElement(By.xpath(adicionarSegundoProduto)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(irParaCarrinho)).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(excluirItemCarrinho)).click();
    }

    public void fechandoPedidoECriandoConta() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath(fecharPedido)).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(criarConta)).click();
    }

}
