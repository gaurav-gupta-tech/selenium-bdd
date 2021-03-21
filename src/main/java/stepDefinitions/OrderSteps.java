package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;

public class OrderSteps {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private ShoppingCartPage shoppingCartPage;
    private OrderConfirmationPage orderConfirmationPage;
    private OrderHistoryPage orderHistoryPage;
    String orderNum;

    private WebDriver driver= Hooks.driver;


    public OrderSteps(){
        homePage= new HomePage(driver);
        searchResultsPage= new SearchResultsPage(driver);
        shoppingCartPage= new ShoppingCartPage(driver);
        orderConfirmationPage=new OrderConfirmationPage(driver);
        orderHistoryPage=new OrderHistoryPage(driver);
    }


    @Given("^I am on application homepage$")
    public void iAmApplicationHomepage() {
        Assert.assertEquals("My Store",homePage.getHomePageTitle());
    }

    @When("^I click on SignIn$")
    public void iClickOnSignIn() {
        homePage.setSignIn();
    }


    @When("^I search for \"([^\"]*)\" in search items box$")
    public void iSearchForInSearchItemsBox(String items)  {
        homePage.setSearchItems(items);
    }

    @Then("^I can see \"([^\"]*)\" in search result$")
    public void iCanSeeInSearchResult(String itemName)  {
        if(itemName.equalsIgnoreCase("T-shirts")){
            Assert.assertEquals("T-SHIRTS",searchResultsPage.getResultsLabel().replace("\"", ""));
        }
    }

    @When("^I add item to cart$")
    public void iAddItemToCart() {
        searchResultsPage.selectItem();
        searchResultsPage.setAddToCart();
    }

    @And("^I click on proceed to checkout from cart$")
    public void iClickOnProceedToCheckoutFromCart() {
        shoppingCartPage.setCheckOutFromCart();
    }

    @And("^I click on proceed to checkout from cart summary$")
    public void iClickOnProceedToCheckoutFromCartSummary() {
        shoppingCartPage.setProceedFromCartSummary();
    }

    @And("^I click on proceed to checkout from addresses page$")
    public void iClickOnProceedToCheckoutFromAddressesPage() {
        shoppingCartPage.setProceedFromAddress();
    }

    @And("^I accept terms & conditions from shipping page$")
    public void iAcceptTermsConditionsFromShippingPage() {
        shoppingCartPage.setTermsNCondition();
    }

    @And("^I click on proceed to checkout from shipping page$")
    public void iClickOnProceedToCheckoutFromShippingPage() {
        shoppingCartPage.setProceedFromShipping();
    }

    @And("^I select on Pay by bank wire option from payment page$")
    public void iSelectOnPayByBankWireOptionFromPaymentPage() {
        shoppingCartPage.setPaymentByBankWire();
    }

    @And("^I confirm My order$")
    public void iConfirmMyOrder() {
        shoppingCartPage.setConfirmOrder();
    }

    @Then("^Order should be added$")
    public void orderShouldBeAdded() {
        Assert.assertEquals("Your order on My Store is complete.",orderConfirmationPage.getOrderConfirmLbl());
    }

    @Then("^I can see recent oder is added to order history$")
    public void iCanSeeRecentOderIsAddedToOrderHistory() {
        Assert.assertEquals("ORDER HISTORY",orderHistoryPage.getOrderHistoryLbl());
        Assert.assertTrue(orderHistoryPage.isOrderRefPresent(orderNum));

    }

    @When("^I click on back to orders$")
    public void iClickOnBackToOrders() {
        orderNum=orderConfirmationPage.getOrderRefNumber();
        orderConfirmationPage.setBackToOrders();
    }

    @And("^I click on search button$")
    public void iClickOnSearchButton() {
        homePage.setSearchSubmit();
    }


}
