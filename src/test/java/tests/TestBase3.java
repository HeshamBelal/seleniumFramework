package tests;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductPage;
import pages.WishListPage;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase3 {
    protected LoginPage loginPage;
    protected MyAccountPage myAccountPage;
    protected WishListPage wishListPage;
    protected ProductPage productPage;
    protected ThreadLocal<RemoteWebDriver> driver;
    public static String BaseURL= "http://automationpractice.com/index.php";
    //String Username= LoadProperties.SauceLabData.getProperty("SauceLab");
    //String Password= LoadProperties.SauceLabData.getProperty("SauceLab");
    //String AccessKey= LoadProperties.SauceLabData.getProperty("SauceLab");
    //String SauceLabURL= "https://"+Username+":"+AccessKey+"@ondemand.eu-central-1.saucelabs.com:443/wd/hub";      //LoadProperties.SauceLabData.getProperty("SauceLab");
    public static String SauceLabURL= "https://HeshamBelal:577e5178-bd47-467b-b8bb-02b16746ca25@ondemand.eu-central-1.saucelabs.com:443/wd/hub";//LoadProperties.SauceLabData.getProperty("SauceLab");
    @BeforeClass
    @Parameters(value= ("browser"))
    public void setUp(@Optional("firefox")String browser) throws MalformedURLException //Here we can add @optional for the parameters
    {
        System.out.println(SauceLabURL);
        driver= new ThreadLocal<>();
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setBrowserName(browser);
        driver.set(new RemoteWebDriver(new URL(SauceLabURL), cap)); //set the  browser type
        driver.get().navigate().to(BaseURL); //driver.get() returns the driver
    }
    @AfterClass
    public void removeBrowser()
    {
        driver.get().quit(); //quite the browser
        driver.remove(); // release the session on the node or return it to initial declarataion which is null or empty.
    }
}