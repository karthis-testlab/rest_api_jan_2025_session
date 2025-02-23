package week5.day2;

import java.io.File;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AttachFileInJiraTicket {
	
	public static void main(String[] args) {
		RestAssured.given()
        .baseUri("https://karthikeselene.atlassian.net")
        .basePath("/rest/api/3")
        .auth()
        .preemptive()
        .basic("karthike.selene@gmail.com", "")
        .header("X-Atlassian-Token", "no-check")
        .contentType(ContentType.MULTIPART)
        .accept(ContentType.JSON)
        .log().all()
        .when()
        .multiPart(new File("./images/Screenshot 2025-02-23 072906.png"))
        .post("/issue/10106/attachments")
        .then()
        .log().all()
        .assertThat()		           
        .statusCode(200)
        .statusLine(Matchers.containsString("OK"));
	}

}