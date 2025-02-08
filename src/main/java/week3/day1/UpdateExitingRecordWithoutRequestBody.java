package week3.day1;

import static io.restassured.RestAssured.*;

public class UpdateExitingRecordWithoutRequestBody {

	public static void main(String[] args) {
		
		given()
		 .baseUri("https://dev262949.service-now.com")
		 .basePath("/api/now/table")
		 .auth()
		 .basic("admin", "vW0eDfd+A0V-")	
		 .header("Content-Type", "application/json")
		 .log().all()
	   .when()
	     .put("/{tableName}/{sysID}", "incident", "f8a2ed9283af1610695bc7b6feaad3dc")
	   .then()
	     .log().all()
	     .assertThat()
	     .statusCode(200);

	}

}