import io.restassured.parsing.Parser;
import pojo.ampleData;
import static io.restassured.RestAssured.;
import io.restassured.RestAssured;

public class Getfriends {
	public static void main(String[] args) {
		//expect().defaultParser(Parser.JSON).
		//RestAssured.baseURI= "http://localhost:3000";
		ampleData ge = given().expect().defaultParser(Parser.JSON)
				.when().get("http://localhost:3000/friends").as(ampleData.class)
				
		System.out.println(ge.getProfile());
		
	}
}
