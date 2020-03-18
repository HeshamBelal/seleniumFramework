package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    //Sign in button to navigates to the Login and Registration Page
    @FindBy(linkText = "Sign in")
    WebElement signInButton;
    @FindBy(id = "email_create")
    WebElement emailForNewUserRegistration;
    //Register Button
    @FindBy(id= "SubmitCreate")
    public WebElement createAnAccountButton;
    @FindBy(id="email")
    WebElement loginEmailAddress;
    @FindBy(id="passwd")
    WebElement loginPassword;
    @FindBy(id="SubmitLogin")
    WebElement loginButton;
    @FindBy(linkText = "Forgot your password?")
    WebElement forgetYourPasswordLink;
    @FindBy(id="email")
    WebElement recoveryEmailAddressTxtField;
    @FindBy(css="button.btn.btn-default.button.button-medium")
    WebElement retrievePasswordButton;


    public void openLoginAndRegistrationPAge()
    {
        PageBase.clickOnElement(signInButton);
    }
    public void registerNewUser(String email)
    {
        PageBase.sendTxtToElement(emailForNewUserRegistration,email);
        PageBase.clickOnElement(createAnAccountButton);
    }
    public void loginAsRegisteredUser(String email, String password)
    {
        PageBase.sendTxtToElement(loginEmailAddress, email);
        PageBase.sendTxtToElement(loginPassword, password);
        PageBase.clickOnElement(loginButton);
    }
    public void forgetYourPassword(String email) throws InterruptedException {
        PageBase.clickOnElement(forgetYourPasswordLink);
        Thread.sleep(5000);
        PageBase.sendTxtToElement(recoveryEmailAddressTxtField, email);
        PageBase.clickOnElement(retrievePasswordButton);
    }
}
