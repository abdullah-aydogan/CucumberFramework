package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {

        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenKart landing page")
    public void user_is_on_green_kart_landing_page() {
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
    }

    @When("^User searched with short name (.+) and extracted actual name of product$")
    public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {

        landingPage.searchItem(shortName);

        Thread.sleep(2000);
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
    }

    @When("Added {string} items of the selected product to cart")
    public void added_items_product(String quantity) {

        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
    }
}