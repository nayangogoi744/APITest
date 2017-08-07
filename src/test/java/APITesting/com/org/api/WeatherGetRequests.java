package APITesting.com.org.api;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class WeatherGetRequests {

	//Simple GET Request for getting weather data by city name

	//Status code : 200
	//Provided correct api key
	//@Test
	public void Test_01(){

		Response response = when()
				.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=96d81587a03fe2bea41b41b1b5129f09");
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);



	}

	//Status code : 401
	//Provided wrong api key
	//@Test
	public void Test_02(){

		Response response = when()
				.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=96d81587a03fe2bea41b41b1b5129f0");
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 401);



	}

	//How to use parameters with rest assured
	//@Test
	public void Test_03(){

		Response response = given()
				.param("q","London").
				param("appid", "96d81587a03fe2bea41b41b1b5129f09").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		if(response.getStatusCode()==200){
			System.out.println("API is working fine");
		}
		else{
			System.out.println("API is not working fine");
		}


	}



	//Assert our testcase in Rest Assured api

	//How to use parameters with rest assured
	//@Test
	public void Test_04(){

		given().
		param("q","London").
		param("appid", "96d81587a03fe2bea41b41b1b5129f09").
		when().
		get("http://api.openweathermap.org/data/2.5/weather").
		then().
		assertThat().statusCode(200);



	}


	//@Test
	public void Test_05(){

		Response res =  given().
				param("q","London").
				param("appid", "96d81587a03fe2bea41b41b1b5129f09").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		System.out.println(res.asString());



	}

	//@Test
	public void Test_06(){

		Response res =  given().
				param("id","2172797").
				param("appid","96d81587a03fe2bea41b41b1b5129f09").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		assertEquals(res.getStatusCode(), 200);
		System.out.println(res.asString());



	}

	//@Test
	public void Test_07(){

		Response res =  given().
				param("zip","785621,in").
				param("appid","96d81587a03fe2bea41b41b1b5129f09").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		assertEquals(res.getStatusCode(), 200);
		System.out.println(res.asString());



	}

	//@Test
	public void Test_08(){

		String report =  given().
				param("zip","785621,in").
				param("appid","96d81587a03fe2bea41b41b1b5129f09").
				when().
				get("http://api.openweathermap.org/data/2.5/weather").
				then().
				contentType(ContentType.JSON).
				extract().
				path("weather[0].description"); //JSON path


		System.out.println("Weather report:"+report);



	}
	
	
	@Test
	public void Test_09(){

		Response res =  given().
				param("zip","785621,in").
				param("appid","96d81587a03fe2bea41b41b1b5129f09").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		
		String report = res.
				then().
				contentType(ContentType.JSON).
				extract().
				path("weather[0].description"); //JSON path

		String reportexpect = "moderate rain";			//we are giving same value here to assert	
		if(report.equalsIgnoreCase(reportexpect)){
			System.out.println("Pass");
		}
		else{
			System.out.println("Failed");
		}
		System.out.println("Weather report:"+report);



	}






















}
