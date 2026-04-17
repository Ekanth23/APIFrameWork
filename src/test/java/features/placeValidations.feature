Feature: Validating Place API's

Scenario:Verify if place is succesfully added using AddplaceAPI		

Given Add place Payload 
When user calls "AddPlaceAPI" with post http request 
Then the API call got success with status code 200 
And "status" in response body is "OK" 
And "scope" in response body is "APP" 

	