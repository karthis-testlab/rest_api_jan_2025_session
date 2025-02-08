package week3.day1;

import static io.restassured.RestAssured.*;

public class UpdateExitingRecordWithRequestBodyAsString {

	public static void main(String[] args) {
		
		String request_payload = """				
				{
                  "short_description": "APISessionJAN2025",
                  "description": "Update Existing record using PUT"
                }				
				""";
		
		given()
		 .baseUri("https://dev262949.service-now.com")
		 .basePath("/api/now/table")
		 .auth()
		 .basic("admin", "vW0eDfd+A0V-")	
		 .header("Content-Type", "application/json")
		 .log().all()
	   .when()
	     .body(request_payload)
	     .put("/{tableName}/{sysID}", "incident", "f8a2ed9283af1610695bc7b6feaad3dc")
	   .then()
	     .log().all()
	     .assertThat()
	     .statusCode(200);

	}

}