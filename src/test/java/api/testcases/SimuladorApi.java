package api.testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SimuladorApi extends ApiBase {

	@DataProvider(name = "dadosmeses")
	public String[][] mesesTestData() {
	    return new String[][] {
	            {"0", "112"},
	            {"1", "124"},
	            {"2", "136"},
	            {"3", "148"}
	    };
	}
	
	@DataProvider(name = "dadosvalor")
	public String[][] valorTestData() {
	    return new String[][] {
	            {"0", "2.802"},
	            {"1", "3.174"},
	            {"2", "3.564"},
	            {"3", "3.971"}
	    };
	}

	
	@Test(priority = 1, description="Verificação de status do serviço")
	public void test01() {
		 given()
	        .spec (rspec)
	        .when ()
	        .get ("")
	        .then ()
	        .contentType (ContentType.JSON)
	        .statusCode (200);
	}
	
	@Test(priority = 2, description="Verificação do ID get", dependsOnMethods={"test01"})
	public void test02() {

		 given()
	        .spec (rspec)
	        .when ()
	        .get ("")
	        .then()
	        .assertThat()
	        .body("id",equalTo(new Integer("1")));
	}
	
	@Test(priority = 3, description="Verificação dos meses", dependsOnMethods={"test01"}, dataProvider = "dadosmeses")
	public void test03(String index, String valor) {
		final Response resp =
		 given()
	        .spec (rspec)
	        .when ()
	        .get ("")
	        .then()
	        .extract().response();
		
		final String meses = resp.jsonPath().get("meses[" + index + "]");
		Assert.assertTrue((meses).contains(valor));
	}
	
	
	@Test(priority = 4, description="Verificação dos valores", dependsOnMethods={"test01"}, dataProvider = "dadosvalor")
	public void test04(String index, String valor) {
		final Response resp =
		 given()
	        .spec (rspec)
	        .when ()
	        .get ("")
	        .then()
	        .extract().response();
		
		final String meses = resp.jsonPath().get("valor[" + index + "]");
		Assert.assertTrue((meses).contains(valor));
 
	}

}