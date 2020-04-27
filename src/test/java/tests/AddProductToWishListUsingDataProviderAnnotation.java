package tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductPage;
import pages.WishListPage;
public class AddProductToWishListUsingDataProviderAnnotation extends TestBase{
	@DataProvider(name="testData")
	public Object[][] userTestData()
	{
		return new Object[][] {
			{"test2@hesham.com","p@ssw0rd","Mai WishList"}
			,{"test3@hesham.com","p@ssw0rd","Mai WishList"},
			{"test10@hesham.com","p@ssw0rd","Mai WishList"}
		};
	}
	@Test(priority=0, dataProvider = "testData")
	public void userCanCreateNewWishList(String email, String password, String wishlistName) throws InterruptedException
	{
		loginPage=new LoginPage(Driver);
		myAccountPage=new MyAccountPage(Driver);
		productPage=new ProductPage(Driver);
		wishListPage=new WishListPage(Driver);
		loginPage.loginAsRegisteredUser(email,password);
		myAccountPage.navigateToMyWishListButton();
		wishListPage=new WishListPage(Driver);
		wishListPage.saveWishList(wishlistName);
		Assert.assertTrue(wishListPage.checkForWishList(wishlistName));

		wishListPage=new WishListPage(Driver);
		myAccountPage=new MyAccountPage(Driver);
		productPage=new ProductPage(Driver);
		wishListPage.navigateToMyAccountPage();
		myAccountPage.selectProductUsingAutoSuggest();
		Assert.assertTrue(ProductPage.nameOfProduct.getText().equalsIgnoreCase("Faded Short Sleeve T-shirts"));
		productPage.addProductToWishList();
		Thread.sleep(2000);
		productPage.navigateToMyAccountPage();
		//Assert.assertTrue(myAccountPage.myAccountHeader.getText().equalsIgnoreCase("My account"));
		myAccountPage.navigateToMyWishListButton();
		Assert.assertTrue(wishListPage.checkQuantityInMyWishListTable());

		wishListPage=new WishListPage(Driver);
		wishListPage.deleteWishList();
		//Thread.sleep(2000);
		Driver.navigate().refresh();
		Assert.assertFalse(wishListPage.checkForWishList("Mai WishList"));
		Thread.sleep(2000);
	}
}
