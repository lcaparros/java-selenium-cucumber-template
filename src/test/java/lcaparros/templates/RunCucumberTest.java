package lcaparros.templates;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber-report/cucumber.json", "html:target/cucumber-report/html"})
public class RunCucumberTest {
}
