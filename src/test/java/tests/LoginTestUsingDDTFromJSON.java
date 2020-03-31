package tests;

import data.JSONDataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistartionPage;

import java.io.IOException;
public class LoginTestUsingDDTFromJSON extends TestBase{
    JSONDataReader jsonDataReader=new JSONDataReader();
    @Test
    public void loginSuite() throws InterruptedException, IOException, ParseException {
        jsonDataReader.getDataFromJSONFile();
        loginPage=new LoginPage(Driver);
        loginPage.registerNewUser(jsonDataReader.email);
        Thread.sleep(3000);
        userRegistrationPage= new UserRegistartionPage(Driver);
        userRegistrationPage.registerNewUser(jsonDataReader.firstName,jsonDataReader.lastName,jsonDataReader.password,jsonDataReader.company,jsonDataReader.city,jsonDataReader.postalCode,jsonDataReader.mobilePhone,jsonDataReader.address,jsonDataReader.addressAlias);
        myAccountPage=new MyAccountPage(Driver);
        Assert.assertTrue(myAccountPage.signOutButton.isDisplayed(),"User Registration is successful");

        myAccountPage=new MyAccountPage(Driver);
        myAccountPage.logoutFromTheWebPAge();
        loginPage=new LoginPage(Driver);
        Assert.assertTrue(loginPage.createAnAccountButton.isDisplayed());

        loginPage=new LoginPage(Driver);
        loginPage.loginAsRegisteredUser(jsonDataReader.email,jsonDataReader.password);
        Assert.assertTrue(myAccountPage.signOutButton.isDisplayed());

        loginPage=new LoginPage(Driver);
        loginPage.logout();
        Assert.assertTrue(loginPage.signInButton.isDisplayed());

        loginPage=new LoginPage(Driver);
        loginPage.forgetYourPassword(jsonDataReader.email);
        Assert.assertTrue(loginPage.forgotYourPasswordSuccessMessage.getText().contains("A confirmation email has been sent to your address"));
    }
}
