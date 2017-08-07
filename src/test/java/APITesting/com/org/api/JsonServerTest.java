package APITesting.com.org.api;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class JsonServerTest {

	// See project https://github.com/typicode/json-server
	//GET request
	
	//@Test
	public void Test_01(){
		Response res = given().
		when().
		get("http://localhost:3000/posts");
		System.out.println("Response is"+res.asString());
	}
	
	//@Test
	public void Test_02(){
		Response res = given().
		body("   {\"id\":\"2\","
				+ "\"title\":\"nayan\","
				+ "\"author\":\"gogoi\" }  ").
		when().
		contentType(ContentType.JSON).
		post("http://localhost:3000/posts");
		
		System.out.println("Response is:"+res.asString());
		
	}
	
	@Test
		public void Test_03(){
		
		PostRequestJava pr = new PostRequestJava();
		pr.setId("3");
		pr.setTitle("Niva");
		pr.setAuthor("Kalita");
		
			Response res = given().
			when().
			contentType(ContentType.JSON).
			body(pr).
			post("http://localhost:3000/posts");
			
			System.out.println("Response is:"+res.asString());
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

	