package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    private static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeys(By locator, String value, int timeOutInSecs) {

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecs);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(value);

    }

    public void clickOn(By locator, int timeOutInSecs) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecs);
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator));
        element.click();

    }

}
