Feature: Pet Store API Testing
Description: To give a POC on the API Testing for assesment.

@api @tc01 @create_pet
Scenario: As a user, I want to add new Pet to the Store using API
	Given I have a Endpoint to add new pet to store
	When I hit the endpoint using Post Method to add new pet
	Then I Validate the success response code 200
	And I verify the pet is available by using Get Method by PETID
	
@api @negative @tc02
Scenario: As a user, I receive error message if I try to get the PetID with incorrect details
	Given I have a Endpoint to get the Pet details
	When I hit the endpoint using Get Method to get pet details
	Then I recieve pet not found message with response code 404

@api @tc03 @update_pet
Scenario: As a user, I want to update the existing pet details
	Given I have a Endpoint to update the pet details
	When I hit the endpoint using PUT Method to update the pet details
	Then I Validate the success response code 200
	And I verify the updated pet details by using Get Method by PETID
	
@api @tc04 @delete_pet
Scenario: As a user, I want to delete the existing pet
	Given I have a Endpoint to delete the pet details
	When I hit the endpoint using Delete Method to delete the pet details
	Then I Validate the success response code 200
	