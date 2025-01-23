package admin;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = { "progress", "html:target/cucumber-html-report" },
        features = "src/test/resources",  // Проверявай дали тази директория съществува
        tags = "@regression")

public class RunCukesTestBDD extends AbstractTestNGCucumberTests {
}

