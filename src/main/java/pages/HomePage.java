package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By lnkSignIn = By.cssSelector("a.login");
    private By txtSearch = By.id("search_query_top");
    private By btnSearch = By.name("submit_search");
    private By logout = By.cssSelector("a.logout");


    public void setSignIn() {
        clickOn(lnkSignIn, 10);
    }

    public void setSearchItems(String items) {
        sendKeys(txtSearch, items, 10);
    }


    public void setSearchSubmit() {
        clickOn(btnSearch, 10);
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public boolean isLogOutButtonDisplayed() {
        return driver.findElement(logout).isDisplayed();
    }


}
