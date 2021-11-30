package apiInitiation;

import apiUtilities.PropertyUtils;
import io.cucumber.java.Before;
import io.restassured.response.Response;



public class APIFactories {
	
	private static final String USERNAME = PropertyUtils.configProperty("Username");
	private static final String PASSWORD = PropertyUtils.configProperty("Password");
	private static Response response;
	 
	@Before
	public void authorization() {
		System.out.println("**************Started Test************");
		APIPageObject.setBaseURL();
		APIPageObject.setRestRequestforJson("application/json","{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}");		
		response = APIPageObject.apiMethods("Post", "/oauth/authorize");
			}
	

}
