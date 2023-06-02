package Response_validation;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

import org.testng.annotations.Test;

import com.github.dockerjava.api.model.LogConfig;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import junit.framework.Assert;

public class validate_json_bodyData
{
	@Test(priority=2)
	public void validate()
	{
		Response res = given().contentType(ContentType.JSON)
				.when().get("https://reqres.in/api/users");
		List<String> names = res.jsonPath().get("data.first_name");
		for (String string : names)
		{
			if(string.equals("Janet"))
			{
				System.out.println("the name is available");
			}
		}

	}
	@Test(priority=1)
	public void validate1()
	{
		ArrayList<String> arlis=new ArrayList<String>();
		arlis.add("Vary");
		arlis.add("Server");
		 given().contentType(ContentType.JSON).config(RestAssured.config.logConfig(io.restassured.config.LogConfig.logConfig().blacklistHeaders(arlis)))
				 .when().get("https://reqres.in/api/users").then().log().headers();
//		List<Integer> names = res.jsonPath().get("data.id");
//		for (Integer string : names)
//		{
//			if(string.equals("2"))
//			{
//				System.out.println("the id is available");
//			}
//		}

	}
}
