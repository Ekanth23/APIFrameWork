package pojo;

/**
 * Location is a POJO class representing geographical coordinates (latitude and longitude).
 * Used as a component in AddPlace POJO, demonstrating composition in OOP.
 * Encapsulates location data with private fields and public accessors.
 * OOP Concept: Encapsulation - Data hiding with getters/setters.
 * Framework Feature: Simple POJO for nested JSON objects in API payloads.
 */
public class Location {
	
	   private Double lat; // Latitude coordinate
	   private Double lng; // Longitude coordinate
	   public Double getLat() {
		   return lat;
	   }
	   public void setLat(Double lat) {
		   this.lat = lat;
	   }
	   public Double getLng() {
		   return lng;
	   }
	   public void setLng(Double lng) {
		   this.lng = lng;
	   } 
	


		
	


	

}
