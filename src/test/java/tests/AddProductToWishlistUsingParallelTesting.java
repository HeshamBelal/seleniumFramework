package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductPage;
import pages.WishListPage;
public class AddProductToWishlistUsingParallelTesting extends TestBase2{
    @Test
    public void userCanCreateNewWishList()
    {
        loginPage=new LoginPage(driver.get());
        myAccountPage=new MyAccountPage(driver.get());
        productPage=new ProductPage(driver.get());
        wishListPage=new WishListPage(driver.get());
        loginPage.loginAsRegisteredUser("test2@hesham.com","p@ssw0rd");
        myAccountPage.navigateToMyWishListButton();
        wishListPage=new WishListPage(driver.get());
        wishListPage.saveWishList("Mai WishList");
        Assert.assertTrue(wishListPage.checkForWishList("Mai WishList"));
    }
    @Test(dependsOnMethods = {"userCanCreateNewWishList"})
    public void userCanAddProductToWishList() throws InterruptedException {
        wishListPage=new WishListPage(driver.get());
        myAccountPage=new MyAccountPage(driver.get());
        productPage=new ProductPage(driver.get());
        wishListPage.navigateToMyAccountPage();
        myAccountPage.selectProductUsingAutoSuggest();
        Assert.assertTrue(ProductPage.nameOfProduct.getText().equalsIgnoreCase("Faded Short Sleeve T-shirts"));
        productPage.addProductToWishList();
        Thread.sleep(2000);
        productPage.navigateToMyAccountPage();
        //Assert.assertTrue(myAccountPage.myAccountHeader.getText().equalsIgnoreCase("My account"));
        myAccountPage.navigateToMyWishListButton();
        Assert.assertTrue(wishListPage.checkQuantityInMyWishListTable());
    }
    @Test(dependsOnMethods = {"userCanAddProductToWishList"})
    public void userCanDeleteProductFromWishList() {
        wishListPage=new WishListPage(driver.get());
        wishListPage.deleteWishList();
        //Thread.sleep(2000);
        driver.get().navigate().refresh();
        Assert.assertFalse(wishListPage.checkForWishList("Mai WishList"));
    }
}
