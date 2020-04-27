package tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductPage;
import pages.WishListPage;

public class TestBase2 {
	protected LoginPage loginPage;
	protected MyAccountPage myAccountPage;
	protected WishListPage wishListPage;
	protected ProductPage productPage;
	protected ThreadLocal<RemoteWebDriver> driver= null;
	public String BaseURL= "http://automationpractice.com/index.php";
	@BeforeClass
	@Parameters(value= ("browser"))
	public void setUp(String browser) throws MalformedURLException //Here we can add @optional for the parameters
	{
		driver= new ThreadLocal<>();
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName(browser);
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap)); //set the  browser type
		driver.get().navigate().to(BaseURL); //driver.get() returns the driver
	}
	@AfterClass
	public void removeBrowser()
	{
		driver.get().quit(); //quite the browser
		driver.remove(); // release the session on the node or return it to initial declarataion which is null or empty.
	}
}
