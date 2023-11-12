package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "StepDefinitions",
        tags = "@SauceTestCase",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
               "json:target/cucumber-reports/CucumberTestReport.json",
                //"html:target/cucumber-pretty",
                //"json:target/cucumber-json/cucumber.json",
                "timeline:target/test-output-thread/"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("================ BEFORE SUITE ================");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("================ AFTER SUITE ================");
    }
}
