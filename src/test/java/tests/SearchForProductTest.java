package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;
public class SearchForProductTest extends TestBase{
    @Test
    public void quickSearchForProductUsingAutoSuggest() throws InterruptedException {
        loginPage=new LoginPage(Driver);
        myAccountPage= new MyAccountPage(Driver);
        productPage=new ProductPage(Driver);
        loginPage.loginAsRegisteredUser("test2@hesham.com","p@ssw0rd");
        myAccountPage.selectProductUsingAutoSuggest();
        Assert.assertTrue(ProductPage.nameOfProduct.getText().equalsIgnoreCase("Faded Short Sleeve T-shirts"));
    }
    @Test(dependsOnMethods = {"quickSearchForProductUsingAutoSuggest"})
    public void navigateToMyAccountPageFromProductPage()
    {
        productPage=new ProductPage(Driver);
        productPage.navigateToMyAccountPage();
        Driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        Assert.assertTrue(myAccountPage.myAccountHeader.getText().equalsIgnoreCase("My account"));
    }
    @Test(dependsOnMethods = {"navigateToMyAccountPageFromProductPage"})
    public void searchForProductThroughSearchField()
    {
        myAccountPage=new MyAccountPage(Driver);
        myAccountPage.selectSecondProduct();
        Assert.assertTrue(ProductPage.productPageResultText.getText().equalsIgnoreCase("1 result has been found."));
    }
}