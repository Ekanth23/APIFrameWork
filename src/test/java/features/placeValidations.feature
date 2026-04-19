Feature: Validating Place API's
@AddPlace
Scenario Outline: Verify if place is succesfully added using AddplaceAPI		

Given Add place Payload with "<name>" "<language>" "<address>" 
When user calls "AddPlaceAPI" with "post" http request 
Then the API call got success with status code 200 
And "status" in response body is "OK" 
And "scope" in response body is "APP" 
And verify place_id created maps to "<name>" using "getPlaceAPI"

Examples:
	|name 		|language 	| address 				|
	|aahouse 	|English 	| World cross center 	|
#	|BBhouse 	|Spanish 	| Sea cross center 		|
@DeletePlace	
Scenario: verify if Delete place functionality is working
Given Deleteplace Payload
When user calls "deletePlaceAPI" with "post" http request 
Then the API call got success with status code 200 
And "status" in response body is "OK" 

	