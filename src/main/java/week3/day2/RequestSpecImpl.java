package week3.day2;

import static io.restassured.RestAssured.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecImpl {
	
	public static void main(String[] args) {
		
		
		RequestSpecification requestSpecification = new RequestSpecBuilder()
		    .setBaseUri("https://dev262949.service-now.com")
		    .setBasePath("/api/now/table")
		    .setAuth(basic("admin", "vW0eDfd+A0V-"))
		    .addHeader("Content-Type", "application/json")
		    .addPathParam("tableName", "incident")
		    .build();
		
		// Plain Old Java Object
		IncidentRequestPayload request_payload = new IncidentRequestPayload();
		
		request_payload.setDescription("APISessionJAN2025");
		request_payload.setShort_description("Adding new record using POST POJO Object");
		
		           given()
		           .spec(requestSpecification)
		           .log().all()
		           .when()  
		           .body(request_payload)
		           .post("/{tableName}")
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(201);

	}

}