package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private By btnProceedChkout = By.cssSelector("a[title='Proceed to checkout']");
    private By btnSummaryPro = By.cssSelector("p.cart_navigation>a[title='Proceed to checkout']");
    private By btnAddressPro = By.cssSelector("button[name=processAddress]");
    private By btnShippingPro = By.cssSelector("button[name=processCarrier]");
    private By chkTermsNCond = By.id("cgv");
    private By lnkPaymentByWire = By.cssSelector("a[title='Pay by bank wire']");
    private By btnConfirmOrder = By.xpath("//span[text()='I confirm my order']/parent::button");

    public void setCheckOutFromCart() {
        clickOn(btnProceedChkout, 10);
    }

    public void setProceedFromCartSummary() {
        clickOn(btnSummaryPro, 10);
    }

    public void setProceedFromAddress() {
        clickOn(btnAddressPro, 10);
    }

    public void setProceedFromShipping() {
        clickOn(btnShippingPro, 10);
    }

    public void setTermsNCondition() {
        driver.findElement(chkTermsNCond).click();
    }

    public void setPaymentByBankWire() {
        clickOn(lnkPaymentByWire, 10);
    }

    public void setConfirmOrder() {
        clickOn(btnConfirmOrder, 10);
    }

}
