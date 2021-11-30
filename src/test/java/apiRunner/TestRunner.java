package apiRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/FeatureFile/PetAPI.feature",
        glue = {"classpath:stepDefinitions", "classpath:apiInitiation"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags="@api",
        monochrome = true
)
public class TestRunner {

	
}
