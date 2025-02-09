package week3.day2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestDataDrivenByTestNG {
	
	@DataProvider
	public String[][] testData() {
		return new String[][] {
			{"APISessionJAN2025 - 1", "Adding new record using POST POJO Object - 1"},
			{"APISessionJAN2025 - 2", "Adding new record using POST POJO Object - 2"},
			{"APISessionJAN2025 - 3", "Adding new record using POST POJO Object - 3"}
		};
	}
	
	@Test(dataProvider = "testData")
	public void userShouldAbleToCreateMultipleRecord(String arg1, String arg2) {
		
		IncidentRequestPayload request_payload = new IncidentRequestPayload();
		
		request_payload.setDescription(arg1);
		request_payload.setShort_description(arg2);
		
		RestAssured.given()
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