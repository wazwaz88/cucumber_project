package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class BaseSteps {

    WebDriver driver;

    @Before
    public void setup(){
        driver = Driver.getDriver();
    }

    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) {
        driver.get(url);
    }


}
