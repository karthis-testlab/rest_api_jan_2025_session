package week5.day2;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateBugIssueInJira {
	
	static String payload = """
					{
			             "fields": {
			               "project": {
			           "id": "10005"
			       },
			       "issuetype": {
			           "id": "10023"
			       },
			       "summary": "Test Bug Story 230220250736"
			   }
			}

					""";

	public static void main(String[] args) {
		RestAssured.given()
		           .baseUri("https://karthikeselene.atlassian.net")
		           .basePath("/rest/api/3")
		           .auth()
		           .preemptive()
		           .basic("karthike.selene@gmail.com", "")
		           .contentType(ContentType.JSON)
		           .accept(ContentType.JSON)
		           .log().all()
		           .when()
		           .body(payload)
		           .post("/issue")
		           .then()
		           .log().all()
		           .assertThat()		           
		           .statusCode(201)
		           .statusLine(Matchers.containsString("Created"));
		           
	}

}