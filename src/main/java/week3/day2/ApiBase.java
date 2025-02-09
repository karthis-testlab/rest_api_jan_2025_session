package week3.day2;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ApiBase {
	
	RequestSpecification requestSpecification;
	IncidentRequestPayload request_payload;
	String sysId; 
	
	// Arrange
	@BeforeMethod
	public void setUp() {
		requestSpecification = new RequestSpecBuilder()
		        .setBaseUri("https://dev262949.service-now.com")
	            .setBasePath("/api/now/table")
	            .setAuth(basic("admin", "vW0eDfd+A0V-"))
	            .addHeader("Content-Type", "application/json")
	            .addPathParam("tableName", "incident")
	            .build();		
	}

}