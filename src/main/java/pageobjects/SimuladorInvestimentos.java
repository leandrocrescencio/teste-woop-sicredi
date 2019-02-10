package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WebUtils;

public class SimuladorInvestimentos {

	private WebDriver driver;

	public SimuladorInvestimentos(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPerfil() {
		return WebUtils.elementWait(driver, By.name("perfil"));
	}

	public WebElement getValorAplicar() {
		return WebUtils.elementWait(driver, By.name("valorAplicar"));
	}

	public void setValorAplicado(String valor) {
		WebElement valorAplicado = this.getValorAplicar();
		valorAplicado.clear();
		valorAplicado.sendKeys(valor);
	}

	public WebElement getValorInvestir() {
		return WebUtils.elementWait(driver, By.name("valorInvestir"));
	}

	public void setValorInvestido(String valor) {
		WebElement valorInvestido = this.getValorInvestir();
		valorInvestido.clear();
		valorInvestido.sendKeys(valor);
	}

	public WebElement getTempo() {
		return WebUtils.elementWait(driver, By.name("tempo"));
	}

	public void setTempo(String valor) {
		WebElement tempo = this.getTempo();
		tempo.clear();
		tempo.sendKeys(valor);
	}

	public WebElement getPeriodo() {
		return WebUtils.elementWait(driver, By.xpath("//div[@class=\"blocoFormulario blocoMeses blocoSelect\"]"));
	}
	
	public WebElement getMeses() {
		return WebUtils.clickWait(driver, By.xpath("//a[contains(text(), \"Meses\")]"));
	}

	public WebElement getAnos() {
		return WebUtils.clickWait(driver, By.xpath("//a[contains(text(), \"Anos\")]"));
	}

	public WebElement getSimularButton() {
		return WebUtils.clickWait(driver, By.xpath("//button[@class=\"btn btnAmarelo btnSimular\"]"));
	}

	public WebElement getClean() {
		return WebUtils.clickWait(driver, By.xpath("//span[contains(text(), \"Limpar formulário\")]"));
	}
	
	public WebElement getRefazerButton() {
		return WebUtils.clickWait(driver, By.xpath("//a[@class=\"btn btnAmarelo btnRefazer\"]"));
	}

	/****** ERRORS ******/

	public WebElement getValorAplicarError() {
		return WebUtils.elementWait(driver, By.id("valorAplicar-error"));
	}

	public WebElement getValorInvestirError() {
		return WebUtils.elementWait(driver, By.id("valorInvestir-error"));
	}

	public WebElement getTempoError() {
		return WebUtils.elementWait(driver, By.id("tempo-error"));

	}

}
