package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

/**
 * TestDataBuild class is responsible for building test data payloads.
 * Demonstrates OOP concept of composition by using POJO objects (AddPlace, Location).
 * Encapsulates data creation logic, making it reusable and maintainable.
 * Separates test data creation from test logic for better organization.
 */
public class TestDataBuild {
	
	/**
	 * Builds AddPlace payload POJO with provided parameters and default values.
	 * Uses composition: Creates Location object and assigns to AddPlace.
	 * Sets default values for fields not parameterized.
	 * @param name Place name
	 * @param language Language
	 * @param address Address
	 * @return AddPlace POJO instance
	 */
	public AddPlace addPlacePayLoad(String name, String language, String address)
	{
		AddPlace p = new AddPlace(); // Composition: Using POJO for data structure
		p.setAccuracy(50); // Default accuracy
		p.setAddress(address); // Parameterized address
		p.setLanguage(language); // Parameterized language
		p.setName(name); // Parameterized name
		p.setPhone_number("(+91) 983 893 3937"); // Default phone
		p.setWebsite("https://rahulshettyacademy.com"); // Default website

		List<String> myList=new ArrayList<String>(); // Creating list for types
		myList.add("shoe park"); // Default type 1
		myList.add("shop"); // Default type 2
		p.setTypes(myList); // Setting types list

		Location loc = new Location(); // Composition: Creating Location POJO
		loc.setLat(-38.383494); // Default latitude
		loc.setLng(33.427362); // Default longitude
		p.setLocation(loc); // Assigning location to AddPlace

		return p; // Returning fully built POJO
	}
	
	/**
	 * Builds delete place payload as JSON string.
	 * Simple string concatenation for JSON payload.
	 * @param placeid Place ID to delete
	 * @return JSON string for delete request
	 */
	public String deletePlacePayload(String placeid)
	{
		
		
		return "{\r\n    \"place_id\":\""+placeid+"\"\r\n}"; // Building JSON string with place_id
	}

}
