package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Utils class provides utility methods for API testing framework.
 * Demonstrates OOP concept of encapsulation by grouping related utility functions.
 * Uses static members for shared resources like request specification to avoid recreation.
 * Integrates with Rest Assured for request building and JSON parsing.
 * Reads configuration from properties file for better maintainability.
 */
public class Utils {
	
	// Static variable for request specification to ensure singleton pattern
	// Encapsulation: Private static field
	public static RequestSpecification req;
	
	/**
	 * Builds and returns a RequestSpecification with common settings.
	 * Implements lazy initialization to create spec only once.
	 * Adds logging filters to capture requests/responses in a file.
	 * Reads base URI from global properties, promoting configuration management.
	 * @return RequestSpecification configured for API calls
	 * @throws IOException if properties file cannot be read
	 */
	public RequestSpecification requestSpecification() throws IOException
	{
		if(req==null) // Lazy initialization: Create only if not exists
		{
		//FileOutputStream => because we are writing 
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder()
				.setBaseUri(getGlobalValue("baseUrl")) // Reading from properties for flexibility
				.addQueryParam("key", "qaclick123") // Common query param
				.addFilter(RequestLoggingFilter.logRequestTo(log)) // Logging request to file
				.addFilter(ResponseLoggingFilter.logResponseTo(log)) // Logging response to file
				.setContentType(ContentType.JSON) // Setting content type
				.build();
		return req;
	}
		return req; // Return existing instance
	}
	
	/**
	 * Retrieves value from global.properties file based on key.
	 * Demonstrates separation of concerns: Configuration externalized.
	 * @param key Property key
	 * @return Property value
	 * @throws IOException if file not found or read error
	 */
	public static String getGlobalValue(String key) throws IOException
	{
		
		Properties prop= new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\acer\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	
	}
	
	/**
	 * Extracts value from JSON response using JsonPath.
	 * Provides abstraction over Rest Assured's JsonPath for easier usage.
	 * @param response Rest Assured Response object
	 * @param key JSON key to extract
	 * @return String value of the key
	 */
	public String getJsonPath(Response response,String key)
	{
		
		String resp = response.asString(); // Convert response to string
		JsonPath jp = new JsonPath(resp); // Create JsonPath object
		return jp.get(key).toString(); // Extract and return value
	}

}
