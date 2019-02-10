package ui.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commom.BaseTest;

public class FlowInvestimentos extends BaseTest {

	@DataProvider(name = "fluxofeliz")
	public String[][] valorTestData() {
	    return new String[][] {
	            {"20,00", "25,00"},
	            {"25,00", "45,00"},
	            {"55,00", "65,00"},
	            {"25,00", "25,00"}
	    };
	}
	
	
	@Test(priority = 1, description="Fluxo de Simulação de Investimentos- Happy Flow", dataProvider = "fluxofeliz")
	public void fluxoInvestimento(String aplicar, String investir) {
	
		Assert.assertTrue(page.getValorAplicar().isDisplayed());
		Assert.assertTrue(page.getValorInvestir().isDisplayed());
		Assert.assertTrue(page.getTempo().isDisplayed());
		action.click(page.getValorAplicar()).build().perform();
		page.setValorAplicado(aplicar); 
		action.click(page.getValorInvestir()).build().perform();
		page.setValorInvestido(investir);
		action.click(page.getTempo()).build().perform();
		page.setTempo("5");
		
		action.click(page.getPeriodo()).build().perform(); 
		action.click(page.getAnos()).build().perform(); 
		action.click(page.getSimularButton()).build().perform(); 
		
		Assert.assertTrue(page.getRefazerButton().isDisplayed());
		
		action.click(page.getRefazerButton()).build().perform(); 
			
	}
	
	
	@Test(priority = 2, description="Fluxo de Simulação de Investimentos - Mensagens de alerta")
	public void fluxoInvestimentoMsgsErros() {
	
		Assert.assertTrue(page.getValorAplicar().isDisplayed());
		Assert.assertTrue(page.getValorInvestir().isDisplayed());
		Assert.assertTrue(page.getTempo().isDisplayed());
		action.moveToElement(page.getValorAplicar()).build().perform();
		page.setValorAplicado("15,00"); 
		
		action.click(page.getValorInvestir()).build().perform();

		action.click(page.getValorAplicar()).build().perform();
		page.setValorAplicado("35,00"); 
			
		action.click(page.getValorInvestir()).build().perform();
		page.setValorInvestido("85,00");
		action.click(page.getTempo()).build().perform();
		page.setTempo("2");
		
		action.click(page.getPeriodo()).build().perform(); 
		action.click(page.getMeses()).build().perform(); 
		action.click(page.getSimularButton()).build().perform(); 
		
			
	}
	
	
}