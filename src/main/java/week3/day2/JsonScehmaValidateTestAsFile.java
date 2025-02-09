package week3.day2;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonScehmaValidateTestAsFile {
	
public static void main(String[] args) {
	
		RestAssured.given()
		           .baseUri("https://dev262949.service-now.com")
		           .basePath("/api/now/table")
		           .auth()
		           .basic("admin", "vW0eDfd+A0V-")
		           .pathParam("tableName", "incident")
		           .pathParam("sysId", "46e18c0fa9fe19810066a0083f76bd56")
		           .log().all()
		           .when()
		           .get("/{tableName}/{sysId}")
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(200)
		           .body(JsonSchemaValidator.matchesJsonSchema(new File("src/main/resources/GetARecordJsonSchema.json")));

	}

}