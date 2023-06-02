package Response_validation;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class data_hiding 
{
	@Test(priority=1)
	public void validate1()
	{
		ArrayList<String> arlis=new ArrayList<String>();
		arlis.add("Vary");
		arlis.add("Server");
		arlis.add("Transfer-Encoding");
	
		Response res = given().contentType(ContentType.JSON).config(RestAssured.config.
				logConfig(io.restassured.config.LogConfig.logConfig().blacklistHeader("Vary","Age","Cache-Control")))
		.when().get("https://reqres.in/api/");
		res.then().log().headers();
		System.out.println(res.getStatusCode());
	}
}
