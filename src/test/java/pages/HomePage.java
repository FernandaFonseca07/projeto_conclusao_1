package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    String barraPesquisa = "//input[@id='twotabsearchtextbox']";
    String pesquisar = "//input[@id='nav-search-submit-button']";
    String produto = "iphone 15 pro max";

    public HomePage (WebDriver driverVindoDoTeste) {this.driver = driverVindoDoTeste;}

    public void clicarEPesquisarProduto(){
        driver.findElement(By.xpath(barraPesquisa)).sendKeys(produto);
        driver.findElement(By.xpath(pesquisar)).click();
    }

}
