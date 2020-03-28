package stepDefinitions;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;

public class StepDefinition extends Base {
    public LandingPage landingPage;
    public LoginPage loginPage;
    //public PortalHomepage portalHomepage;

    @Given("Initialize the browser with chrome")
    public void initialize_the_browser_with_chrome() throws IOException {
        driver = initializeDriver();

    }

    @Given("Navigate to the {string} website")
    public void navigate_to_the_website(String string) {
        driver.get(string);
    }

    @And("Validate title and navigation bar")
    public void validateTitleAndNavigationBar() {
        landingPage = new LandingPage(driver);
        Assert.assertEquals(landingPage.getTitle().getText(), "FEATURED COURSES");
        Assert.assertTrue(landingPage.getNavigationBar().isDisplayed());
    }

    @Given("Click on Login link in the homepage to land on sign in page")
    public void click_on_Login_link_in_the_homepage_to_land_on_sign_in_page() {

        if (landingPage.getPopUpSize() > 0) {

            landingPage.getPopUp().click();
        }
        landingPage.getLogin().click();
    }

    @When("User enters {string} and {string} and logs in")
    public void userEntersAndAndLogsIn(String arg0, String arg1) {
        loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys(arg0);
        loginPage.getPassword().sendKeys(arg1);
        loginPage.getLogin().click();
    }

    /*@Then("Verify that user is successfully logged in")
    public void verify_that_user_is_successfully_logged_in() {
        portalHomepage = new PortalHomepage(driver);
        Assert.assertTrue(portalHomepage.getSearchBox().isDisplayed());
    }*/

    @Then("Close browsers")
    public void closeBrowsers() {
        driver.quit();
    }


}
