package Response_validation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly;

import static io.restassured.RestAssured.*;

public class Parsing_json_responseData
{
	@Test
	public void testjsonresponse()
	{
		Response res = given().contentType(ContentType.JSON)
				.when().get("https://reqres.in/api/users");
		res.then().assertThat().and().statusCode(200);

		res.then().headers("Content-Type","application/json; charset=utf-8").and().log().all();
		String conn = res.header("Connection");
		System.out.println(conn);
		String head = res.getHeader("Content-Encoding");
	String value = res.jsonPath().getString("data[0].last_name");
	System.out.println(value);
	
	
	
	Assert.assertEquals(head, "gzip");
	Assert.assertEquals(value, "Bluth");
	
		 
	}
}
