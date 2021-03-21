package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By txtEmailAddress = By.id("email");
    private By txtPasswd = By.id("passwd");
    private By btnSignIn = By.id("SubmitLogin");

    public void setEmailAddress(String emailAddress) {
        sendKeys(txtEmailAddress, emailAddress, 10);
    }

    public void setPasswd(String passwd) {
        sendKeys(txtPasswd, passwd, 10);
    }


    public void setSignIn() {
        clickOn(btnSignIn, 10);
    }
}
