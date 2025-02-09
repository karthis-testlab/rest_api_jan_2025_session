package week3.day2;

import static io.restassured.RestAssured.*;

public class CreateARecordWithRequestBodyAsPojoObject {

	public static void main(String[] args) {
				
		// Plain Old Java Object
		IncidentRequestPayload request_payload = new IncidentRequestPayload();
		
		request_payload.setDescription("APISessionJAN2025");
		request_payload.setShort_description("Adding new record using POST POJO Object");
		
		           given()
		           .baseUri("https://dev262949.service-now.com")
		           .basePath("/api/now/table")
		           .auth()
		           .basic("admin", "vW0eDfd+A0V-")	
		           .header("Content-Type", "application/json")
		           .log().all()
		           .when()  
		           .body(request_payload)
		           .post("/incident")
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(201);

	}

}
