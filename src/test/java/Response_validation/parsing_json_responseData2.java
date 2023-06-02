package Response_validation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class parsing_json_responseData2 
{
	@Test
	public void validate()
	{
		Response res = given().contentType(ContentType.JSON)
				.when().get("https://reqres.in/api/users");
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		int scode = res.getStatusCode();
		Assert.assertEquals(scode, "200");
		Assert.assertEquals(res.jsonPath().get("data[5].email").toString(),"charles.morris@reqres.in");

	}
}
