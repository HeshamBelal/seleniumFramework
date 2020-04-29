package tests;

//import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import java.io.File;
import java.io.IOException;


public class TestBase { //extends AbstractTestNGCucumberTests
    public WebDriver Driver;
    protected LoginPage loginPage;
    protected UserRegistartionPage userRegistrationPage;
    protected MyAccountPage myAccountPage;
    protected ProductPage productPage;
    protected ShoppingCartPage shoppingCartPage;
    protected WomenSectionPage womenSectionPage;
    protected DressesSectionPage dressesSectionPage;
    protected WishListPage wishListPage;
    protected Alert alert;
    @BeforeClass
    @Parameters({"browser"})
    public void setUpBrowser(@Optional("fire")String browserName)
    {
        if (browserName.equalsIgnoreCase("fire"))
        {
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
            Driver=new FirefoxDriver();
        }
        else
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
            Driver=new ChromeDriver();
        }
        Driver.manage().window().maximize();
        Driver.navigate().to("http://automationpractice.com/index.php");
    }
    @AfterMethod
    public void takeScreenShotIfFailure(ITestResult iTestResult) throws IOException {
        if(iTestResult.getStatus()==ITestResult.FAILURE)
        {
            File screenShotFile=((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenShotFile, new File(System.getProperty("user.dir")+"\\Screenshots\\"+iTestResult.getName()+".png"));
        }
    }
    @AfterClass
    public void terminateBrowser()
    {
        Driver.quit();
    }
}
