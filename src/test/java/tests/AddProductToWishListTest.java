package tests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;

public class AddProductToWishListTest extends TestBase{
    @Test
    public void addProductToWishList() throws InterruptedException {
        loginPage=new LoginPage(Driver);
        loginPage.openLoginAndRegistrationPage();
        loginPage.loginAsRegisteredUser("test2@hesham.com","p@ssw0rd");
        myAccountPage=new MyAccountPage(Driver);
        myAccountPage.hooverOnWomenSection(Driver);
    }
}
