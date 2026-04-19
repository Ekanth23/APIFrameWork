package resources;

//Enum class - Enum is a special class in java which has collecton of constants or mehthods 
public enum APIEnumResources {
	
	AddPlaceAPI("/maps/api/place/add/json"), 
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource; 
	
	APIEnumResources(String resource)
	{
		this.resource=resource; 
	}
	
	public String getResource()
	{
		return resource;
	}

}
