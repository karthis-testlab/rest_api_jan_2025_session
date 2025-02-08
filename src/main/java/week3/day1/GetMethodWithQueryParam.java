package week3.day1;

import io.restassured.RestAssured;

public class GetMethodWithQueryParam {

	public static void main(String[] args) {
		
		RestAssured.given()
        .baseUri("https://dev262949.service-now.com")
        .basePath("/api/now/table")
        .auth()
        .basic("admin", "vW0eDfd+A0V-")
        .pathParam("tableName", "incident")
        .queryParam("sysparm_limit", "1")
        .queryParam("sysparm_fields", "sys_id,number,description,short_description")
        .log().all()
        .when()
        .get("/{tableName}")
        .then()
        .log().all()
        .assertThat()
        .statusCode(200);
		
	}

}
