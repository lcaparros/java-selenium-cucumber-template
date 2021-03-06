package lcaparros.templates.glue;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    private static final String sleniumGridUrl = "http://[::1]:4444";
    private static boolean dunit = false;

    private WebDriver driver;

    @Before(order=1)
    public void beforeAll() {
        if(!dunit) {
            Runtime.getRuntime().addShutdownHook(new Thread(this::afterAll));
            dunit = true;
        }
    }

    private void afterAll() {}

    @When("^(.*) webpage is opened$")
    public void url_is_opened(String url) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--remote-debugging-port=9222");
        try {
            driver = new RemoteWebDriver(new URL(sleniumGridUrl), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get(url);
    }
    @Then("^(.*) is header link$")
    public void headerlink_is(String headerLink) {
        assertEquals("Header link verification", headerLink, driver.findElement(By.className("headerLink")).getAttribute("href"));
    }
}
