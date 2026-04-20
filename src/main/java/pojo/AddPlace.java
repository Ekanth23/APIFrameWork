package pojo;

import java.util.List;

/**
 * AddPlace is a POJO (Plain Old Java Object) class used to represent the request payload for the Add Place API.
 * It is primarily used for serialization, where Java objects are converted into JSON before sending the API request using Rest Assured.
 * The class contains private member variables that correspond to the fields in the JSON payload, along with public getter and setter methods for each variable.
 * OOP Concepts:
 * - Encapsulation: Private fields with public getters/setters to control access.
 * - Composition: Contains a Location object as a field, demonstrating has-a relationship.
 * Framework Feature: POJOs enable easy mapping between Java objects and JSON for API payloads.
 */
public class AddPlace {
	// Private fields for encapsulation
	private  Location location; // Composition: Has-a Location
	private  int accuracy;
	private  String name;
	private  String phone_number;
	private  String address;
	private  List<String> types; // List for multiple types
	private  String website;
	private  String language;
	
	// Getter and setter methods for each field
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	




}
