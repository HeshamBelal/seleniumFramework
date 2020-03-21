package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;
public class SearchForProductTest extends TestBase{
    @Test
    public void quickSearchForProductUsingTxtField()
    {
        loginPage=new LoginPage(Driver);
        loginPage.openLoginAndRegistrationPage();
        loginPage.loginAsRegisteredUser("test2@hesham.com","p@ssw0rd");
        myAccountPage= new MyAccountPage(Driver);
        myAccountPage.pressOnSearchTxtField();
        myAccountPage.insertTextToSearchField("faded");
        Driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        myAccountPage.pressOnQuickSearchResults();
        Assert.assertTrue(MyAccountPage.nameOfProductSearchedFromQuickSearch.getText().equalsIgnoreCase("Faded Short Sleeve T-shirts"));
    }
    @Test(dependsOnMethods = {"quickSearchForProductUsingTxtField"})
    public void navigateToMyAccountPageFromProductPage()
    {
        productPage=new ProductPage(Driver);
        productPage.returnToMyAccountPage();
        Driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    }
    @Test(dependsOnMethods = {"navigateToMyAccountPageFromProductPage"})
    public void searchForProductThroughSearchField()
    {
        myAccountPage=new MyAccountPage(Driver);
        myAccountPage.pressOnSearchTxtField();
        myAccountPage.insertTextToSearchField("faded");
        myAccountPage.pressOnSearchButton();
        Assert.assertTrue(ProductPage.productPageResultText.getText().equalsIgnoreCase("1 result has been found."));
    }
}