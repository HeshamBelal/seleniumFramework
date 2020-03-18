package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistartionPage;

public class LoginTest extends TestBase{

    @Test
    public void registerNewUser() throws InterruptedException {
        loginPage=new LoginPage(Driver);
        loginPage.openLoginAndRegistrationPAge();
        loginPage.registerNewUser("test@hesham.com");
        Thread.sleep(3000);
        userRegistrationPage= new UserRegistartionPage(Driver);
        userRegistrationPage.registerNewUser("Hesham","Belal","p@ssw0rd","Mobi","Cali","90002","18332061405","12 hgo st.","home");
        myAccountPage=new MyAccountPage(Driver);
        Assert.assertTrue(myAccountPage.signOutButton.isDisplayed(),"User Registration is successful");
    }
    @Test(priority = 1)
    public void registeredUserCanLogOut()
    {
        myAccountPage.logoutFromTheWebPAge();
        loginPage=new LoginPage(Driver);
        Assert.assertTrue(loginPage.createAnAccountButton.isDisplayed());
    }
    @Test(priority = 2)
    public void registeredUserCanLogIn()
    {
        loginPage.loginAsRegisteredUser("test@hesham.com","p@ssw0rd");
        Assert.assertTrue(myAccountPage.signOutButton.isDisplayed());
    }
}
