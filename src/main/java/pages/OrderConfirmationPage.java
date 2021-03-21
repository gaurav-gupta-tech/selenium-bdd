package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationPage extends BasePage {
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    private By lblOrderConfirmation = By.cssSelector("p.cheque-indent>strong");
    private By lnkBackToOrders = By.cssSelector("a[title='Back to orders']");
    private By lblRefNumber = By.xpath("//div[@class='box']");
    public static String orderNum;


    public String getOrderConfirmLbl() {
        return driver.findElement(lblOrderConfirmation).getText();
    }

    public void setBackToOrders() {
        clickOn(lnkBackToOrders, 10);
    }

    public String getOrderRefNumber() {
        String text = driver.findElement(lblRefNumber).getText();
        String[] temp1 = text.split("order reference");
        String[] temp2 = temp1[1].split("in");
        return temp2[0].trim();
    }

}
