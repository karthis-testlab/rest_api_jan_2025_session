package week3.day2;

import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ServiceNowE2ETest2 extends ApiBase{	
	
	@Test(priority = 1)
	public void create_a_new_record() {
		request_payload = new IncidentRequestPayload();
		
		request_payload.setDescription("APISessionJAN2025");
		request_payload.setShort_description("Adding new record using POST POJO Object");
		//Action
		sysId = given()
        .spec(requestSpecification)
        .log().all()
        .when()  
        .body(request_payload)
        .post("/{tableName}")
        .then()
        .log().all()
        //Assert
        .assertThat()
        .statusCode(201)
        .statusLine(Matchers.containsString("Created"))
        .contentType(ContentType.JSON)
        .extract()
        .jsonPath()
        .getString("result.sys_id");
	}
	
	@Test(priority = 2)
	public void get_a_record() {
		given()
		.spec(requestSpecification)
        .log().all()
        .when()
        .get("/{tableName}/"+sysId)
        .then()
        .log().all()
        .assertThat()
        .statusCode(200)
        .statusLine(Matchers.containsString("OK"))
        .contentType(ContentType.JSON)
        .body("result.sys_id", Matchers.equalTo(sysId));
	}
	
	@Test(priority = 3)
	public void update_a_record() {
        request_payload = new IncidentRequestPayload();
		
		request_payload.setDescription("APISessionJAN2025 - PUT");
		request_payload.setShort_description("Adding new record using POST POJO Object - PUT");
		given()
		.spec(requestSpecification)
        .log().all()
        .when()
        .body(request_payload)
        .put("/{tableName}/"+sysId)
        .then()
        .log().all()
        .assertThat()
        .statusCode(200)
        .statusLine(Matchers.containsString("OK"))
        .contentType(ContentType.JSON)
        .body("result.sys_id", Matchers.equalTo(sysId))
        .body("result.description", Matchers.equalTo("APISessionJAN2025 - PUT"))
        .body("result.short_description", Matchers.equalTo("Adding new record using POST POJO Object - PUT"));
	}
	
	@Test(priority = 4)
	public void delete_a_record() {
		given()
		.spec(requestSpecification)
        .log().all()
        .when()
        .delete("/{tableName}/"+sysId)
        .then()
        .log().all()
        .assertThat()
        .statusCode(204)
        .statusLine(Matchers.containsString("No Content"));
	}
	
	@Test(priority = 5)
	public void is_record_deleted_successfully() {
		given()
		.spec(requestSpecification)
        .log().all()
        .when()
        .get("/{tableName}/"+sysId)
        .then()
        .log().all()
        .assertThat()
        .statusCode(404)
        .statusLine(Matchers.containsString("Not Found"))
        .contentType(ContentType.JSON);
	}


}