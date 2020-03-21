package tests;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.*;

import java.io.File;
import java.io.IOException;

public class TestBase {
    public WebDriver Driver;
    protected LoginPage loginPage;
    protected UserRegistartionPage userRegistrationPage;
    protected MyAccountPage myAccountPage;
    protected ProductPage productPage;
    protected ShoppingCartPage shoppingCartPage;
    @BeforeSuite
    public void setUpBrowser()
    {
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
        Driver=new FirefoxDriver();
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
    @AfterSuite
    public void terminateBrowser()
    {
       // Driver.close();
    }
}
