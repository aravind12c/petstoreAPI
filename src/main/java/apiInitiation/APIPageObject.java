package apiInitiation;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

import apiUtilities.PropertyUtils;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIPageObject {

	public static final String BASE_URL = PropertyUtils.configProperty("BaseURL");
	public static Response response;
	public static RequestSpecification request;
	
	public static void setBaseURL() {
		RestAssured.baseURI = BASE_URL;
		 
	}
	
	public static void setRestRequestforJson(String contentType, String jsonObject) {
		request = RestAssured.given()
				.header("Content-Type", contentType)
				.body(jsonObject);
		
	}
	
	public static Response apiMethods(String method, String endpoint) {
		
		if(method.equalsIgnoreCase("Get")) {
			response = request.get(endpoint);
		} else if(method.equalsIgnoreCase("Post")) {
			response = request.post(endpoint);
		} else if(method.equalsIgnoreCase("Put")) {
			response = request.put(endpoint);
		} else if(method.equalsIgnoreCase("Delete")) {
			response = request.delete(endpoint);
		}
		
		return response;
		
	}
}
