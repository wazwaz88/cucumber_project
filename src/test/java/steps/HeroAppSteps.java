package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.HeroAppPage;
import utilities.ActionsUtil;
import utilities.AlertHandler;
import utilities.Driver;
import utilities.Waiter;

import javax.swing.*;

public class HeroAppSteps {

    WebDriver driver;
    HeroAppPage heroAppPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        heroAppPage = new HeroAppPage();
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String linkText) {
        Waiter.pause(3);
        heroAppPage.clickOnCategoryLink(linkText);
        Waiter.pause(2);
    }

    @Then("user should see {string} heading")
    public void userShouldSeeHeading(String headingText) {
        switch (headingText){
            case "Context Menu":
                Assert.assertTrue(heroAppPage.contextMenuHeading3.isDisplayed());
                Assert.assertEquals(headingText, heroAppPage.contextMenuHeading3.getText());
                break;
            case "Add/Remove Elements":
                Assert.assertTrue(heroAppPage.addRemoveHeading3.isDisplayed());
                Assert.assertEquals(headingText, heroAppPage.addRemoveHeading3.getText());
                break;
            default:
                throw new NotFoundException("The heading text is not defined properly in the feature file!!!");
        }
    }

    @And("user should see {string} button")
    public void userShouldSeeButton(String buttonText) {
        switch (buttonText) {
            case "Add Element":
                Assert.assertTrue(heroAppPage.addElementButton.isDisplayed());
                Assert.assertTrue(heroAppPage.addElementButton.isEnabled());
                Assert.assertEquals(buttonText, heroAppPage.addElementButton.getText());
                break;
            case "Delete":
                Assert.assertTrue(heroAppPage.deleteElementButton.isDisplayed());
                Assert.assertTrue(heroAppPage.deleteElementButton.isEnabled());
                Assert.assertEquals(buttonText, heroAppPage.deleteElementButton.getText());
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file!!!");
        }
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String buttonText) {
        switch (buttonText){
            case "Add Element":
                heroAppPage.addElementButton.click();
                Waiter.pause(2);
                break;
            case "Delete":
                heroAppPage.deleteElementButton.click();
                Waiter.pause(2);
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file!!!");
        }
    }

    @Then("user should not see {string} button")
    public void userShouldNotSeeButton(String buttonText) {
        switch (buttonText) {
            case "Delete":
                try {
                    Assert.assertFalse(heroAppPage.deleteElementButton.isDisplayed());
                } catch (NoSuchElementException e) {
                    //e.printStackTrace();
                    Assert.assertTrue(true);
                }
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file!!!");
        }
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String text) {

        switch (text){
            case "Context menu items are custom additions that appear in the right-click menu.":
                Assert.assertTrue(heroAppPage.paragraph1.isDisplayed());
                Assert.assertEquals(text, heroAppPage.paragraph1.getText());
                break;
            case "Right-click in the box below to see one called 'the-internet'. When you click it, it will trigger a JavaScript alert.":
                Assert.assertTrue(heroAppPage.paragraph2.isDisplayed());
                Assert.assertEquals(text, heroAppPage.paragraph2.getText());
                break;
            default:
                throw new NotFoundException("The paragraph text is not defined properly in the feature file!!!");
        }

    }

    @And("user should see a rectangle box to right click")
    public void userShouldSeeARectangleBoxToRightClick() {
        Assert.assertTrue(heroAppPage.rectangleBox.isDisplayed());
    }

    @When("user right clicks on rectangle box")
    public void userRightClicksOnRectangleBox() {
        //
        ActionsUtil.rightClick(heroAppPage.rectangleBox);
    }

    @Then("user should see a popup displaying message {string}")
    public void userShouldSeeAPopupDisplayingMessage(String alertText) {
        Assert.assertEquals(alertText, AlertHandler.getAlertText(driver));
        AlertHandler.dismissAlert(driver);
    }


}
