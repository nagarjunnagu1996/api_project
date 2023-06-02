package Response_validation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class validate_body 
{
	@Test
	public void validate()
	{
		Response body = given().contentType(ContentType.JSON).when().get("https://reqres.in/api/users");
		Assert.assertEquals(body.jsonPath().get("data[0].email"),"george.bluth@reqres.in");
	}
}
