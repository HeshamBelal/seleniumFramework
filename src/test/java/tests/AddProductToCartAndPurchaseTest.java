package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductPage;
import pages.ShoppingCartPage;

import java.util.concurrent.TimeUnit;
public class AddProductToCartAndPurchaseTest extends TestBase{
    @Test
    public void addProductToCart() throws InterruptedException {
        loginPage=new LoginPage(Driver);
        loginPage.openLoginAndRegistrationPage();
        loginPage.loginAsRegisteredUser("test2@hesham.com","p@ssw0rd");
        myAccountPage=new MyAccountPage(Driver);
        myAccountPage.pressOnSearchButton();
        myAccountPage.insertTextToSearchField("faded");
        Driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        myAccountPage.pressOnQuickSearchResults();
        productPage=new ProductPage(Driver);
        productPage.addProductToCart();
        Thread.sleep(3000);
        Assert.assertTrue(productPage.productAdditionToCartSuccessTextMessage.getText().contains("Product successfully added to your shopping cart"));
        Assert.assertTrue(productPage.totalPrice.getText().equals("$16.51"));
    }
    @Test(dependsOnMethods = {"addProductToCart"})
    public void emptyTheCart() throws InterruptedException {
        productPage.proceedToCheckout();
        shoppingCartPage=new ShoppingCartPage(Driver);
        shoppingCartPage.deleteProductFromCart();
        shoppingCartPage.navigateToMyAccountPage();
        // Thread.sleep(3000);
    }
}
