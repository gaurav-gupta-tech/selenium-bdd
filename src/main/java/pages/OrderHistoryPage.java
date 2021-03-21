package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderHistoryPage extends BasePage{
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }


    private By LblOrderHistory=By.cssSelector("div#center_column>h1");
    public String getOrderHistoryLbl(){
       return driver.findElement(LblOrderHistory).getText();
    }

    public boolean isOrderRefPresent(String orderNum){
        return driver.findElement(By.xpath("//a[contains(text(),"+orderNum+")]" )).isDisplayed();

    }

}
