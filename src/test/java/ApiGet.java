import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.payload;
// there are some packages which are static in nature all those static ones will be imported when we use static Keyword
//(given, when, then is under static)
public class ApiGet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//validate if add place API is working as expected
	
		
		//given - all input details
		//when  - Submit the api---> resource and http method will go under this when method
		//Then  - Validate the Responce
	
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		String responce =given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body(payload.Addplace())
				.when().post("/maps/api/place/add/json")
		      .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		      .header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString(); 
	      System.out.println(responce);
	    
	      JsonPath js = new JsonPath(responce);// for parsing json
          String placeid = js.getString("place_id");
          System.out.println(placeid);
	
          String Newaddress ="70 winter walk, USA";
          //update new address
	//ValidatableResponse getdetails =
			given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	.body("{\r\n"
			+ "  \"place_id\":\"" +placeid+" \",\r\n"
			+ "   \"address\":\""+Newaddress+"\",\r\n"
			+ "   \"key\":\"qaclick123\"\r\n"
			+ "}").
	when().put("/maps/api/place/update/json")
	.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
	
	
	
	//get updated Address
	String getplaceresponce = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
	.when().get("/maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract().response().asString();
	
	
	JsonPath js1 =new JsonPath(getplaceresponce);
	String actualaddress=js1.getString("address");
	System.out.println(getplaceresponce);
	Assert.assertEquals(actualaddress, Newaddress);
	
	
	}
	
	
	

}
