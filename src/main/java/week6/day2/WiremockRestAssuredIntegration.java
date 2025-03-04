package week6.day2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;

public class WiremockRestAssuredIntegration {
	
	WireMockServer server = new WireMockServer();
	
	@BeforeClass
	public void startWiremockServer() {
		server.start();
	}
	
	@BeforeMethod
	public void createStub() {
		server.stubFor(
				  WireMock.get("/api/v1/code")
				          .willReturn(
				        		   WireMock.aResponse()
				        		           .withStatus(200)
				        		           .withHeader("Content-Type", "application/json")
				        		           .withBody("{\"status\": \"Up and Run\"}")
				        		  )
				);
	}
	
	@Test
	public void testCode() {
		RestAssured.given()
		           .baseUri("http://localhost:8080")
		           .log().all()
		           .when()
		           .get("/api/v1/code")
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(200);
	}
	
	@AfterClass
	public void stopServer() {
		server.stop();
	}

}