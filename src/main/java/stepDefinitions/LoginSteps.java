package stepDefinitions;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;



public class LoginSteps {

    private WebDriver driver= Hooks.driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private WebDriverWait wait;

    public LoginSteps(){
        loginPage=new LoginPage(driver);
        homePage= new HomePage(driver);
    }



    @And("^I enter email address as \"([^\"]*)\"$")
    public void iEnterEmailAddressAs(String email)  {
        loginPage.setEmailAddress(email);
    }

    @And("^I enter Password as \"([^\"]*)\"$")
    public void iEnterPasswordAs(String passwd)  {
        loginPage.setPasswd(passwd);
    }

    @And("^I click on SignIn Button$")
    public void iClickOnSignInButton() {
        loginPage.setSignIn();
    }

    @Then("^I successfully logged in to application$")
    public void iSuccessfullyLoggedInToApplication() {
        Assert.assertTrue(homePage.isLogOutButtonDisplayed());
    }

    @Given("^I have logged in with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iHaveLoggedInWithAnd(String email, String passwd)  {
        homePage.setSignIn();
        loginPage.setEmailAddress(email);
        loginPage.setPasswd(passwd);
        loginPage.setSignIn();
    }
}
