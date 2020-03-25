package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductPage;
import pages.ShoppingCartPage;
public class AddProductToCartAndEditQuantityAndEmptyTheShoppingCart extends TestBase{
    @Test
    public void userCanAddProductToCart() throws InterruptedException {
        loginPage=new LoginPage(Driver);
        myAccountPage=new MyAccountPage(Driver);
        productPage=new ProductPage(Driver);
        shoppingCartPage=new ShoppingCartPage(Driver);
        loginPage.loginAsRegisteredUser("test2@hesham.com","p@ssw0rd");
        Assert.assertTrue(myAccountPage.signOutButton.isDisplayed());
        myAccountPage.selectProductUsingAutoSuggest();
        productPage.addProductToCart();
        Thread.sleep(2000);
        Assert.assertTrue(productPage.productAdditionToCartSuccessTextMessage.getText().contains("Product successfully added to your shopping cart"));
        Assert.assertTrue(productPage.totalPrice.getText().equals("$16.51"));
        productPage.proceedToCheckout();
        Thread.sleep(2000);
        Assert.assertTrue(shoppingCartPage.totalPrice.getText().equals("$18.51"));
    }
    @Test(dependsOnMethods = {"userCanAddProductToCart"})
    public void userCanUpdateProductQuantity() throws InterruptedException {
        shoppingCartPage=new ShoppingCartPage(Driver);
        shoppingCartPage.incrementProductQuantityInShoppingCart();
        Thread.sleep(2000);
        Assert.assertTrue(shoppingCartPage.totalPrice.getText().equals("$35.02"));
    }
    @Test(dependsOnMethods = {"userCanUpdateProductQuantity"})
    public void userCanEmptyTheCart() throws InterruptedException {
        shoppingCartPage=new ShoppingCartPage(Driver);
        shoppingCartPage.deleteProductFromCart();
        Thread.sleep(2000);
        Assert.assertTrue(shoppingCartPage.shoppingCartEmptyMessage.getText().equalsIgnoreCase("Your shopping cart is empty."));
    }
}
