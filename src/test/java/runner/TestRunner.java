package runner;


import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import util.ReadProperties;

import java.io.File;

@RunWith(Cucumber.class)
    @CucumberOptions(
            features="src/test/java/features",
            glue={"stepDefinitions"},
            plugin = {"pretty" ,"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
            monochrome = true
        )

    public class TestRunner {
        @AfterClass
        public static void writeExtentReport() {
            Reporter.loadXMLConfig(new File(ReadProperties.getReportConfigPath()));
        }
    }
