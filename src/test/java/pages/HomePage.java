package pages;


import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;


public class HomePage {
    WebDriver driver;
    String barraPesquisa = "//input[@id='twotabsearchtextbox']";
    String pesquisar = "//input[@id='nav-search-submit-button']";
    String primeiroProduto = "//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/span[1]/a[1]/div[1]/img[1]";
    Map<String, String> dadosVariaveis = new HashMap<>(); //Criação do Map para abrigar o Json
    Gson gson = new Gson(); //Biblioteca do goole para fazer manipulção do Json
    Reader reader;


    public HomePage (WebDriver driverVindoDoTeste) {this.driver = driverVindoDoTeste;}

    public void main(String[] args) throws InterruptedException, FileNotFoundException {
        clicarEPesquisarProduto();

    }

    public void clicarEPesquisarProduto() throws InterruptedException, FileNotFoundException {
        reader = new FileReader("C:\\Users\\Fernanda\\Desktop\\PROJETO\\projeto_conclusao_1\\projeto_conclusao_1\\src\\test\\resources\\dadosVariaveis.json");
        dadosVariaveis = gson.fromJson(reader, Map.class);
        driver.findElement(By.xpath(barraPesquisa)).sendKeys(dadosVariaveis.get("produto"));
        Thread.sleep(5000);
        driver.findElement(By.xpath(pesquisar)).click();
    }

    public void selecionarPrimeiroProduto() throws InterruptedException {
        Thread.sleep(8000);
        driver.findElement(By.xpath(primeiroProduto)).click();
    }

}
