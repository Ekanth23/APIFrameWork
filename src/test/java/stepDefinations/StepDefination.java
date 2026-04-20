package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.swing.text.Utilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIEnumResources;
import resources.TestDataBuild;
import resources.Utils;

/**
 * StepDefination class implements the step definitions for Cucumber BDD scenarios.
 * It extends the Utils class to inherit utility methods, demonstrating the OOP concept of inheritance.
 * This class handles API testing using Rest Assured library, showcasing encapsulation of test logic.
 * The framework uses Cucumber for behavior-driven development, allowing non-technical stakeholders to understand test cases.
 * Rest Assured is used for API automation, providing fluent API for HTTP requests and responses.
 */
public class StepDefination extends Utils {
	
	// Instance variables for request/response specifications and data builder
	// Encapsulation: Private fields to hold state within the class
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_id; // Static variable to share place_id across scenarios

	/**
	 * Cucumber @Given step: Prepares the payload for adding a place.
	 * Uses TestDataBuild to create POJO payload, demonstrating composition (OOP concept).
	 * @param name Place name
	 * @param language Language
	 * @param address Address
	 * @throws IOException
	 */
	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		
		res = given()
				.spec(requestSpecification()) // Inherited method from Utils, inheritance in action
				.body(data.addPlacePayLoad(name, language, address)); // Composition: Using TestDataBuild object

	}

	/**
	 * Cucumber @When step: Makes HTTP request to the specified API resource.
	 * Uses enum for resource paths, promoting maintainability (OOP: Enum usage).
	 * Sets up response specification for validation.
	 * @param resource API resource from enum
	 * @param method HTTP method (POST/GET)
	 */
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		
		// Using enum to get resource path, avoids hardcoding and improves readability
		APIEnumResources enumResourceAPI = APIEnumResources.valueOf(resource);
		System.out.println(enumResourceAPI.getResource());
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		resspec = new ResponseSpecBuilder()
		.expectStatusCode(200)
		.expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		
		response = res.when().post(enumResourceAPI.getResource());
		
		else if(method.equalsIgnoreCase("GET"))
			response = res.when().get(enumResourceAPI.getResource());

	}

	/**
	 * Cucumber @Then step: Validates the HTTP status code.
	 * Uses JUnit assertion for verification.
	 * @param int1 Expected status code
	 */
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		
		assertEquals(response.getStatusCode(), 200);
		
	}

	/**
	 * Cucumber @Then step: Validates a key-value pair in the JSON response body.
	 * Uses inherited getJsonPath method from Utils for JSON parsing.
	 * @param expectedkey JSON key
	 * @param expectedvalue Expected value
	 */
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String expectedkey, String expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions

	    assertEquals(getJsonPath(response, expectedkey), expectedvalue); // Inheritance: Using method from Utils
	}
	
	/**
	 * Cucumber @Then step: Verifies that the created place_id maps to the expected name.
	 * Demonstrates API chaining: POST to create, GET to verify.
	 * Uses static variable for data sharing across steps.
	 * @param expectedName Expected place name
	 * @param resource API resource for GET
	 * @throws IOException
	 */
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
		
		
		place_id = getJsonPath(response, "place_id"); // Extract place_id from response

		System.out.println("place_id: "+place_id);
		
		res = given()
				.spec(requestSpecification()) // Reusing request spec
				.queryParam("place_id", place_id); // Adding query param for GET request

		user_calls_with_http_request(resource, "GET"); // Calling another step method, demonstrating modularity
		String actualName = getJsonPath(response, "name");
		assertEquals(actualName, expectedName); // Assertion for verification

	}
	
	/**
	 * Cucumber @Given step: Prepares payload for deleting a place.
	 * Uses the stored place_id from previous scenarios.
	 * @throws IOException
	 */
	@Given("Deleteplace Payload")
	public void deleteplace_payload() throws IOException {
		
		res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id)); // Using TestDataBuild for payload

		}
	
}