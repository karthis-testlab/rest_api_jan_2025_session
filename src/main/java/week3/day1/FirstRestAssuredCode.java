package week3.day1;

import io.restassured.RestAssured;

public class FirstRestAssuredCode {

	public static void main(String[] args) {
		
		// Pre - Request
		RestAssured.given()
		           .baseUri("https://dev262949.service-now.com")
		           .basePath("/api/now/table")
		           .auth()
		           .basic("admin", "vW0eDfd+A0V-")
		           // Print Request Log in the console
		           .log().all()
		           // HTTP Action
		           .when()
		           .get("/incident")
		           // Assertion
		           .then()
		           // Print Response Log in the console
		           .log().all()
		           .assertThat()
		           .statusCode(200);
		           
		
	}

}