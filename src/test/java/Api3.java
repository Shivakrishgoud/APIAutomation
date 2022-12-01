import static io.restassured.RestAssured.given;

import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
//import io.restassured.path.json.JsonPath;

public class Api3 {
	
	 @Test
	   public void postRequest() {
		  int age = 26;
		   String ages = given().contentType(ContentType.JSON).body(" \"id\": 21").
			when().delete("http://localhost:3000/friends").
			then().assertThat().statusCode(200).extract().response().asString(); 
		  
		 JsonPath js1 =new JsonPath(ages);
			int actualages=js1.getInt("age");
			System.out.println(actualages);
			Assert.assertEquals(actualages, age);
		   

}
}
