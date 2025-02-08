package week3.day1;

import static io.restassured.RestAssured.*;

public class CreateARecordWithoutRequestBody {

	public static void main(String[] args) {
		
		given()
		 .baseUri("https://dev262949.service-now.com")
		 .basePath("/api/now/table")
		 .auth()
		 .basic("admin", "vW0eDfd+A0V-")	
		 .header("Content-Type", "application/json")
		 .log().all()
	   .when()
	     .post("/{tableName}", "incident")
	   .then()
	     .log().all()
	     .assertThat()
	     .statusCode(201);

	}

}