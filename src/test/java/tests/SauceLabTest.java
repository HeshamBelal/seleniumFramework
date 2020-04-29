package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabTest {
    public static final String USERNAME = "HeshamBelal";
    public static final String ACCESS_KEY = "577e5178-bd47-467b-b8bb-02b16746ca25";
    public static final String SURL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "latest");
        caps.setBrowserName("firefox");
        //Your issues is with this line. Just run URL string where You previously have setup everything before
        WebDriver driver = new RemoteWebDriver(new URL(SURL), caps);
        driver.get("https://saucelabs.com/test/guinea-pig");
        System.out.println("title of page is: " + driver.getTitle());
        driver.quit();
    }
}
