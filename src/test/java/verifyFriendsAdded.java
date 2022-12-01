import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import io.restassured.http.ContentType;


import static io.restassured.RestAssured.given;
public class verifyFriendsAdded {
	
	@SuppressWarnings("unchecked")
	@Test
	public void verifyFriendsAddedSimple_Test() {
		
		JSONObject frndInfo= new JSONObject();
		frndInfo.put("firstname" , "shiva");
		frndInfo.put("lstname" , "mamidi");
		frndInfo.put("id" , 123);
		frndInfo.put("age" , 26);
		
		
		given().contentType(ContentType.JSON).body(frndInfo.toString()).
		when().post("http://localhost:3000/friends").
		then().assertThat().statusCode(201);
	}
	
  
	   
	   
   }
   

