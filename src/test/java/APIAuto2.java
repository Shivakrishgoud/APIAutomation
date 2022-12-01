import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class APIAuto2 {

	
		
	@Test(dataProvider ="InputData")
	public void getRequest(String post)
	
	{
		RestAssured.baseURI= "http://localhost:3000";
		 String getbookingid = given().log().all()
				.when().get(post).then().assertThat().log().all().statusCode(200).extract().response().asString();
	
	System.out.println(getbookingid);
	
	}
     
    @DataProvider(name="InputData")
    public Object[][] getData()
    {
    	//array=collection of elements
    	//multidimensional Arrays= collection of arrays
    	return new Object[][] { {"posts/1"},{"posts/2"},{"posts/3"},{"posts/4"},{"comments/1"},{"comments/2"},{"comments/3"},{"comments/3"}};
    	
    	
    }

}


