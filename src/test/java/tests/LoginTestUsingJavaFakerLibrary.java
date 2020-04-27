package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistartionPage;
public class LoginTestUsingJavaFakerLibrary extends TestBase{
    @Test
    public void registerNewUser() throws InterruptedException {
        loginPage=new LoginPage(Driver);
        loginPage.registerNewUser("test9@hesham.com");
        Thread.sleep(3000);
        userRegistrationPage= new UserRegistartionPage(Driver);
        userRegistrationPage.registerNewUser("Hesham","Belal","p@ssw0rd","Mobi","Cali","90002","18332061405","12 hgo st.","home");
        myAccountPage=new MyAccountPage(Driver);
        Assert.assertTrue(myAccountPage.signOutButton.isDisplayed(),"User Registration is successful");
    }
    @Test(dependsOnMethods = {"registerNewUser"})
    public void registeredUserCanLogOut()
    {
        myAccountPage=new MyAccountPage(Driver);
        myAccountPage.logoutFromTheWebPAge();
        loginPage=new LoginPage(Driver);
        Assert.assertTrue(loginPage.createAnAccountButton.isDisplayed());
    }
    @Test(dependsOnMethods = {"registeredUserCanLogOut"})
    public void registeredUserCanLogIn()
    {
        loginPage=new LoginPage(Driver);
        loginPage.loginAsRegisteredUser("test9@hesham.com","p@ssw0rd");
        Assert.assertTrue(myAccountPage.signOutButton.isDisplayed());
    }
    @Test(dependsOnMethods = {"registeredUserCanLogIn"})
    public void userCanLogOut()
    {
        loginPage=new LoginPage(Driver);
        loginPage.logout();
        Assert.assertTrue(loginPage.signInButton.isDisplayed());
    }
    @Test(dependsOnMethods = {"userCanLogOut"})
    public void userCanRecoverHisPassword() throws InterruptedException {
        loginPage=new LoginPage(Driver);
        loginPage.forgetYourPassword("test9@hesham.com");
        Assert.assertTrue(loginPage.forgotYourPasswordSuccessMessage.getText().contains("A confirmation email has been sent to your address"));
    }
}