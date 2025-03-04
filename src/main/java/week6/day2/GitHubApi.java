package week6.day2;

import org.json.JSONObject;

import io.restassured.RestAssured;

public class GitHubApi {
	
	static String queryValue = """
			query {
  viewer {
    login
    name
    repositories {
      totalCount
      totalDiskUsage
    }
    followers {
      totalCount
    }
  }
}
			""";

	public static void main(String[] args) {
		
		RestAssured.given()
		           .baseUri("https://api.github.com")
		           .basePath("/graphql")
		           .header("Authorization", "Bearer ")
		           .log().all()
		           .when()
		           .body(queryToJsonString(queryValue))
		           .post()
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(200);

	}
	
	public static String queryToJsonString(String query) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("query", queryValue);
		return jsonObject.toString();
	}

}
