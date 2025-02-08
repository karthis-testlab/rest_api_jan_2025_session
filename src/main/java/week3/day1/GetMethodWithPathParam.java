package week3.day1;

import io.restassured.RestAssured;

public class GetMethodWithPathParam {

	public static void main(String[] args) {
		
		RestAssured.given()
		           .baseUri("https://dev262949.service-now.com")
		           .basePath("/api/now/table")
		           .auth()
		           .basic("admin", "vW0eDfd+A0V-")
		           .pathParam("tableName", "incident")
		           .log().all()
		           .when()
		           .get("/{tableName}")
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(200);

	}

}