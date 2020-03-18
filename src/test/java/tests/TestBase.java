package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistartionPage;

public class TestBase {
    public WebDriver Driver;
    protected LoginPage loginPage;
    protected UserRegistartionPage userRegistrationPage;
    protected MyAccountPage myAccountPage;

    @BeforeSuite
    public void setUpBrowser()
    {
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
        Driver=new FirefoxDriver();
        Driver.manage().window().maximize();
        Driver.navigate().to("http://automationpractice.com/index.php");
    }
    @AfterSuite
    public void terminateBrowser()
    {
       // Driver.close();
    }
}
