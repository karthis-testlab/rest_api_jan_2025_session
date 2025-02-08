package week3.day1;

import static io.restassured.RestAssured.*;

public class CreateARecordWithRequestBodyAsString {

	public static void main(String[] args) {
		
		String request_payload = """				
				{
                  "short_description": "APISessionJAN2025",
                  "description": "Adding new record using POST"
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
	     .post("/{tableName}", "incident")
	   .then()
	     .log().all()
	     .assertThat()
	     .statusCode(201);

	}

}