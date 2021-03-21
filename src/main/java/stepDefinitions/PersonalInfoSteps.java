package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.PersonalInfoPage;

import java.nio.charset.Charset;
import java.util.Random;

public class PersonalInfoSteps {

    private WebDriver driver= Hooks.driver;
    String generatedString="";

    PersonalInfoPage personalInfoPage;

    public PersonalInfoSteps(){
        personalInfoPage=new PersonalInfoPage(driver);
    }

    @When("^I click My personal info under my account$")
    public void iClickMyPersonalInfoUnderMyAccount() {
        personalInfoPage.setMyPersonalInfo();
    }


    @Then("^I can see Personal Information page$")
    public void iCanSeePersonalInformationPage() {
        Assert.assertEquals("YOUR PERSONAL INFORMATION",personalInfoPage.getMyPersonalInfoLbl());
    }

    @And("^I update first name from personal info page$")
    public void iUpdateFirstNameFromPersonalInfoPage() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

         generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        personalInfoPage.setFirstName(generatedString);
    }


    @And("^I click on Save button$")
    public void iClickOnSaveButton() {
        personalInfoPage.submitSaveBtn();
    }

    @Then("^I can see first name is updated$")
    public void iCanSeeFirstNameIsUpdated() {
        Assert.assertEquals("Your personal information has been successfully updated.",
                personalInfoPage.getSuccessLabel().trim());
        personalInfoPage.setMyPersonalInfo();
        Assert.assertEquals(generatedString.toString().trim(),personalInfoPage.getFirstName().trim().toLowerCase());
    }

    @And("^I enter current password as \"([^\"]*)\"$")
    public void iEnterCurrentPasswordAs(String passwd)  {
        personalInfoPage.setCurrentPasswd(passwd);
    }
}
