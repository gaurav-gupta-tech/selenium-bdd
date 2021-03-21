package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    private By btnAddToCart = By.cssSelector("p#add_to_cart>button");
    private By lblResults = By.cssSelector("h1.product-listing>span.lighter");
    private By lnkItem = By.cssSelector("a.product_img_link");


    public String getResultsLabel() {
        return driver.findElement(lblResults).getText();
    }

    public void setAddToCart() {
        driver.findElements(btnAddToCart).get(0).click();
    }


    public void selectItem() {
        clickOn(lnkItem, 10);
    }
}
