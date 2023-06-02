package Response_validation;

import static io.restassured.RestAssured.*;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class file_uplod_download
{
	@Test
	public void m1()
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
	}
}
