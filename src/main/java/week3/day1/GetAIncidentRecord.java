package week3.day1;

import io.restassured.RestAssured;

public class GetAIncidentRecord {
	
public static void main(String[] args) {
		
		RestAssured.given()
		           .baseUri("https://dev262949.service-now.com")
		           .basePath("/api/now/table")
		           .auth()
		           .basic("admin", "vW0eDfd+A0V-")
		           .pathParam("tableName", "incident")
		           .pathParam("sysId", "ff71172683ac9610695bc7b6feaad318")
		           .log().all()
		           .when()
		           .get("/{tableName}/{sysId}")
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(200);

	}

}