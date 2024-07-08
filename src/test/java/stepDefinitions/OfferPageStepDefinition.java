package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

    public String offerPageProductName;
    TestContextSetup testContextSetup;

    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("^User searched for (.+) short name in offers page$")
    public void user_searched_for_short_name_in_offers_page(String shortName) throws InterruptedException {

        switchToOffersPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.offersPage();

        offersPage.searchItem(shortName);

        Thread.sleep(2000);
        offerPageProductName = offersPage.getProductName();
    }

    public void switchToOffersPage() {

        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();

        testContextSetup.genericUtils.switchWindowToChild();
    }

    @Then("Validate product name in offers page matches with landing page")
    public void validate_product_name_in_offers_page() {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }
}