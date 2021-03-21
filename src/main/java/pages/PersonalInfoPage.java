package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalInfoPage extends BasePage{
    public PersonalInfoPage(WebDriver driver) {
        super(driver);
    }

    private By lnkMyPersonalInfo= By.cssSelector("a[title='Manage my personal information']");
    private By lblMyPersonalInfo=By.cssSelector("h1.page-subheading");
    private By txtFirstName=By.id("firstname");
    private By btnSave=By.name("submitIdentity");
    private By txtOldPassword=By.id("old_passwd");
    private By lblSuccess=By.cssSelector("p.alert.alert-success");


    public void setMyPersonalInfo(){
        clickOn(lnkMyPersonalInfo,20);
    }

    public String getMyPersonalInfoLbl(){
        return driver.findElement(lblMyPersonalInfo).getText();
    }

    public void setFirstName(String firstName){
        sendKeys(txtFirstName,firstName,10);
    }

    public void setCurrentPasswd(String passwd){
        sendKeys(txtOldPassword,passwd,10);
    }

    public String getFirstName(){
        return driver.findElement(txtFirstName).getAttribute("value");
    }

    public void submitSaveBtn(){
        clickOn(btnSave,20);
    }

    public String getSuccessLabel(){
        return driver.findElement(lblSuccess).getText();
    }


}
