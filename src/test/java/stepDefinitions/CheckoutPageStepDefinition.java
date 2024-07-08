package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {

    TestContextSetup testContextSetup;
    public CheckoutPage checkoutPage;

    public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {

        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("Verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_enter_promo() {

        Assert.assertTrue(checkoutPage.verifyPromoBtn());
        Assert.assertTrue(checkoutPage.verifyPlaceOrder());
    }

    @Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout(String name) {

        checkoutPage.checkoutItems();

    }
}