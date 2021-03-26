package StepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinition"},
monochrome = true,
//plugin={"pretty","html:target/HtmlReports/Html.report"}
//plugin={"pretty","json:target/JSONReports/report.json"}
plugin={"pretty","junit:target/JUnitReports/report.xml"}

//tags="@Smoketest"

)
public class TestRunner {

}
