import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
  
public class APIAutomationWithRqstspecBuider {
	
	
	private static RequestSpecification requestSpec;
	  private static ResponseSpecification responceSpec;
	  
	  @BeforeClass
	  
	  public static void createWithRqstspecBuider(){
		  
		requestSpec = new RequestSpecBuilder().
				setBaseUri("https://restful-booker.herokuapp.com").
				setContentType(ContentType.JSON).
				build();
		responceSpec = new ResponseSpecBuilder().
				expectStatusCode(200).
				expectContentType(ContentType.JSON).
				build();
		  
		  
	  }
	@Test
	public void verifySuccessforZip() {
		//RestAssured.baseURI= "https://restful-booker.herokuapp.com";
		 given().log().all().
		    spec(requestSpec).
		 when().get("booking").
		  
		 then().spec(responceSpec).
		      assertThat().log().all().extract().response().asString();

	
	
	
	}

	
}
