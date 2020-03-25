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
    public WebElement signInButton;
    @FindBy(id = "email_create")
    private WebElement emailForNewUserRegistration;
    //Register Button
    @FindBy(id= "SubmitCreate")
    public WebElement createAnAccountButton;
    @FindBy(id="email")
    private WebElement loginEmailAddress;
    @FindBy(id="passwd")
    private WebElement loginPassword;
    @FindBy(id="SubmitLogin")
    private WebElement loginButton;
    @FindBy(linkText = "Forgot your password?")
    private WebElement forgetYourPasswordLink;
    @FindBy(id="email")
    private WebElement recoveryEmailAddressTxtField;
    @FindBy(css="button.btn.btn-default.button.button-medium")
    private WebElement retrievePasswordButton;
    @FindBy(css = "a.account")
    private  WebElement myAccountButton;
    @FindBy(linkText = "Sign out")
    private WebElement signOutButton;
    @FindBy(css = "p.alert.alert-success")
    public WebElement forgotYourPasswordSuccessMessage;
    public void navigateToMyAccount()
    {
        PageBase.clickOnElement(myAccountButton);
    }
    public void registerNewUser(String email)
    {
        PageBase.clickOnElement(signInButton);
        PageBase.sendTxtToElement(emailForNewUserRegistration,email);
        PageBase.clickOnElement(createAnAccountButton);
    }
    public void loginAsRegisteredUser(String email, String password)
    {
        PageBase.clickOnElement(signInButton);
        PageBase.sendTxtToElement(loginEmailAddress, email);
        PageBase.sendTxtToElement(loginPassword, password);
        PageBase.clickOnElement(loginButton);
    }
    public void logout()
    {
        PageBase.clickOnElement(signOutButton);
    }
    public void forgetYourPassword(String email) throws InterruptedException
    {
        PageBase.clickOnElement(signInButton);
        PageBase.clickOnElement(forgetYourPasswordLink);
        Thread.sleep(2000);
        PageBase.sendTxtToElement(recoveryEmailAddressTxtField, email);
        PageBase.clickOnElement(retrievePasswordButton);
    }
}
