package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.junit.runner.Request;
import org.testng.Assert;

import apiInitiation.APIPageObject;
import apiUtilities.JSONUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class PetAPIStepDefinition {

	public static Response response;
	public static Request request;
	
	public static String endPoint;
	
	String petID = "10422125";
	String petname = "TestNewDog";
	String status = "sold";
	
	@Given("I have a Endpoint to add new pet to store")
	 public void endpointToAddNewPet() {
		endPoint = "/pet";
		APIPageObject.setBaseURL();	 
	}
	
	@When("I hit the endpoint using Post Method to add new pet")
	public void addNewPetusingPost() {
		APIPageObject.setRestRequestforJson("application/json","{\"id\":"+petID+",\"category\":{\"id\":104213,\"name\":\"Dogs\"},\"name\":\"TestDog\",\"photoUrls\":[\"sample\"],\"tags\":[{\"id\":104213,\"name\":\"Animal\"}],\"status\":\"available\"}");
		response = APIPageObject.apiMethods("Post", endPoint);
		 System.out.println("Json is: "+response.asString());
	}
	
	@Then("I Validate the success response code {int}")
	public void validateSuccessResponse(int statusCode) {
		 Assert.assertEquals(response.statusCode(), statusCode);
	}
	
	@And("I verify the pet is available by using Get Method by PETID")
	public void verifyPetAvailability() {
		endPoint = "/pet/"+petID;
		response = APIPageObject.apiMethods("Get", endPoint);
		Map<String, String> jsonResponse = JSONUtils.jsonReader(response.asString());
		Assert.assertEquals(jsonResponse.get("id"), Integer.parseInt(petID));
		Assert.assertEquals(jsonResponse.get("name"), "TestDog");
	}
	
	@Given("I have a Endpoint to update the pet details")
	 public void endpointToUpdatePetDetails() {
		endPoint = "/pet";
		APIPageObject.setBaseURL();	 
	}
	
	@When("I hit the endpoint using PUT Method to update the pet details")
	public void updatePetDetails() {
		APIPageObject.setRestRequestforJson("application/json","{\"id\":"+petID+",\"category\":{\"id\":104213,\"name\":\"Dogs\"},\"name\":\""+petname+"\",\"photoUrls\":[\"sample\"],\"tags\":[{\"id\":104213,\"name\":\"Animal\"}],\"status\":\"available\"}");
		response = APIPageObject.apiMethods("Put", endPoint);
		 System.out.println("Status is: "+response.getStatusLine());
	}
	
	@And("I verify the updated pet details by using Get Method by PETID")
	public void verifyUpdatedPetDetailsareReflected() {
		endPoint = "/pet/"+petID;
		response = APIPageObject.apiMethods("Get", endPoint);
		Map<String, String> jsonResponse = JSONUtils.jsonReader(response.asString());
		Assert.assertEquals(jsonResponse.get("id"), Integer.parseInt(petID));
		Assert.assertEquals(jsonResponse.get("name"), petname);
	}
	
	@Given("I have a Endpoint to delete the pet details")
	 public void endpointToDeletePetDetails() {
		endPoint = "/pet/"+petID;
		APIPageObject.setBaseURL();	 
	}
	
	@When("I hit the endpoint using Delete Method to delete the pet details")
	public void deletePetDetails() {
		response = APIPageObject.apiMethods("Delete", endPoint);
		 System.out.println("Status is: "+response.getStatusLine());
	}
	
	@And("I verify the pet details are deleted {int}")
	public void verifyPetDetailsgotDeleted(int statusCode) {
		endPoint = "/pet/"+petID;
		response = APIPageObject.apiMethods("Get", endPoint);
		Assert.assertEquals(response.statusCode(), statusCode);
	}
	
	@Given("I have a Endpoint to get the Pet details")
	 public void endpointToGetPetDeatils() {
		endPoint = "/pet/02587892";
		APIPageObject.setBaseURL();	 
	}
	
	@When("I hit the endpoint using Get Method to get pet details")
	public void getPetDetails() {
		response = APIPageObject.apiMethods("Get", endPoint);
		 System.out.println("Json is: "+response.asString());
	}
	
	@Then("I recieve pet not found message with response code {int}")
	public void verifyPetNotFoundMsg(int statusCode) {
		 Assert.assertEquals(response.statusCode(), statusCode);
//		 Map<String, String> jsonResponse = JSONUtils.jsonReader(response.asString());
			Assert.assertEquals(response.asString(), "Pet not found");
	}
}
