package resources;

//Enum class - Enum is a special class in java which has collecton of constants or mehthods
//APIEnumResources is an Enum class used to centralize all API endpoint resource paths in one place.
//It helps avoid hardcoding URLs throughout the framework and improves maintainability, readability, and scalability.
//OOP Concept: Enum demonstrates abstraction by providing a type-safe way to define constants.
//Framework Feature: Centralizes API endpoints for easy management and updates.
public enum APIEnumResources {
	//
	AddPlaceAPI("/maps/api/place/add/json"), // Endpoint for adding a place
	getPlaceAPI("/maps/api/place/get/json"), // Endpoint for getting place details
	deletePlaceAPI("/maps/api/place/delete/json"); // Endpoint for deleting a place
	//resource is a private instance variable used to store the API endpoint path associated with each enum constant.
	private String resource;
	//
	APIEnumResources(String resource)
	{
		this.resource=resource; // Constructor to set the resource path
	}
	//
	public String getResource()
	{
		return resource; // Getter method to retrieve the resource path
	}

}
