package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

 /**
 * Hooks class contains Cucumber hooks for setup/teardown operations.
 * Framework Feature: Cucumber hooks allow executing code before/after scenarios or steps.
 * Used here to ensure a place exists before delete scenario runs.
 * OOP Concept: Dependency injection - Creates StepDefination instance to reuse methods.
 */
public class Hooks {
	
	/**
	 * Before hook that runs before scenarios tagged with @DeletePlace.
	 * Ensures a place is created if none exists, so delete can be tested.
	 * Demonstrates test data setup for dependent scenarios.
	 * @throws IOException if request setup fails
	 */
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		//write a code that will give you place id 
		//execute a code that will give you 
		
		StepDefination m = new StepDefination(); // Creating instance to call methods

		if(StepDefination.place_id==null) // Check if place_id exists from previous runs
		{
		
		m.add_place_payload_with("Ekanth", "french", "Asia"); // Setup payload
		m.user_calls_with_http_request("AddPlaceAPI", "POST"); // Add place
		m.verify_place_id_created_maps_to_using("Ekanth", "getPlaceAPI"); // Verify and set place_id
		}
	}

}
