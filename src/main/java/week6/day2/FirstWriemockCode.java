package week6.day2;

import com.github.tomakehurst.wiremock.client.WireMock;

public class FirstWriemockCode {

	public static void main(String[] args) {
		
		WireMock.stubFor(
				   // For Request mocking
				   WireMock.get("/java/v2/welcome")
				           // For Response Mocking 
				           .willReturn(
				        		   WireMock.aResponse()
				        		           .withStatus(200)
				        		           .withStatusMessage("OK")
				        		           .withBody("Welcome to Wiremock Java1.")
				        		           
				        		   )
				);
		
		
		WireMock.stubFor(
				 WireMock.post("/api/now/table/incident")
				         .willReturn(
				        		  WireMock.aResponse()
				        		          .withStatus(201)
				        		          .withBody("""
				        		          		{
				        		          		  "description": "APIRESTJAN2025",
				        		          		  "short_description": "Post Method mock" 
				        		          		}
				        		          		""")
				        		 )
				);
		
	}

}