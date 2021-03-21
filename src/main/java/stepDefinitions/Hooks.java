package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ReadProperties;


import java.io.File;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void openBrowser() throws Exception {
        File file=new File(".//resources/driver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(ReadProperties.getURL());
    }

    @After
    public void embedScreenshot(Scenario scenario) {

        if(scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
        driver.quit();
    }


}
