package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdutoPage {
    WebDriver driver;
    String adicionarCarinho = "//input[@id='add-to-cart-button']";
    String recusaSeguro = "//*[@id=\"attachSiNoCoverage\"]/span/input";
    String irParaCarinho = "//*[@id=\"sw-gtc\"]/span/a";

    public ProdutoPage (WebDriver driverVindoDoTeste) {this.driver = driverVindoDoTeste;}

    public void adicionandoNoCarrinho() throws InterruptedException {
        driver.findElement(By.xpath(adicionarCarinho)).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(recusaSeguro)).click();
    }

    public void indoParaCarrinho () throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath(irParaCarinho)).click();
    }
}
