package pages;

import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class CadastroPage {
    WebDriver driver;
    Map<String, String> dadosVariaveis = new HashMap<>(); //Criação do Map para abrigar o Json
    Gson gson = new Gson(); //Biblioteca do goole para fazer manipulção do Json
    Reader reader;
    String boxNome = "//*[@id=\"ap_customer_name\"]";
    String boxEmail = "//*[@id=\"ap_email\"]";
    String boxSenha = "//*[@id=\"ap_password\"]";
    String boxConfirmacaoSenha = "//*[@id=\"ap_password_check\"]";
    String botaoConfirmar = "//*[@id=\"continue\"]";

    public CadastroPage (WebDriver driverVindoDoTeste) {this.driver = driverVindoDoTeste;}

    public void main(String[] args) throws FileNotFoundException, InterruptedException {
        inserindoInformacoesCadastro();
    }

    public void inserindoInformacoesCadastro() throws FileNotFoundException, InterruptedException {
        reader = new FileReader("C:\\Users\\Fernanda\\Desktop\\PROJETO\\projeto_conclusao_1\\projeto_conclusao_1\\src\\test\\resources\\dadosVariaveis.json");
        dadosVariaveis = gson.fromJson(reader, Map.class);
        driver.findElement(By.xpath(boxNome)).sendKeys(dadosVariaveis.get("nomeCompleto"));
        driver.findElement(By.xpath(boxEmail)).sendKeys(dadosVariaveis.get("email"));
        driver.findElement(By.xpath(boxSenha)).sendKeys(dadosVariaveis.get("senha"));
        driver.findElement(By.xpath(boxConfirmacaoSenha)).sendKeys(dadosVariaveis.get("confirmacaoSenha"));
        Thread.sleep(5000);
        driver.findElement(By.xpath(botaoConfirmar)).click();
    }
}
