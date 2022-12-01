import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class APIAutomationTtraining {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI= "https://restful-booker.herokuapp.com";
		String getbookingid = given().log().all()
				.when().get("booking").then().assertThat().log().all().statusCode(200).extract().response().asString();
				
				
				JsonPath js1 =new JsonPath(getbookingid);
				String bookingids=js1.getString("bookingid");
				System.out.println(getbookingid);
				System.out.println(bookingids);

	}
	
}
