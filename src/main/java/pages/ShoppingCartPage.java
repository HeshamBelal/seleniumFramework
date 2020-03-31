package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="i.icon-trash")
    private WebElement DeleteProductFromCart;
    @FindBy(css = "span.ajax_cart_no_product")
    public WebElement shoppingCartEmptyIcon;
    @FindBy(css = "a.account")
    private WebElement myAccountButton;
    @FindBy(css="i.icon-home")
    private WebElement homePageButton;
    @FindBy(id="total_price")
    public WebElement totalPrice;
    @FindBy(css = "i.icon-plus")
    private WebElement incrementQuantityButton;
    @FindBy(css="p.alert.alert-warning")
    public WebElement shoppingCartEmptyMessage;
    @FindBy(linkText = "Proceed to checkout")
    private WebElement proceedToCheckoutButton;
    @FindBy(css = "button.button.btn.btn-default.button-medium")
    private WebElement proceedToCheckoutButton2;
    @FindBy(css = "button.button.btn.btn-default.button-medium")
    private WebElement proceedToCheckoutButton3;
    @FindBy(id="cgv")
    private WebElement agreeToTermsOfServiceCheckBox;
    @FindBy(css = "a.bankwire")
    private WebElement payByBankWireButton;
    @FindBy(css="button.button.btn.btn-default.button-medium")
    private WebElement iConfirmMyOrderButton;
    @FindBy(css = "p.cheque-indent")
    public WebElement cartPurchaseCompleteMessage;
    public void incrementProductQuantityInShoppingCart()
    {
        PageBase.clickOnElement(incrementQuantityButton);
    }
    public void deleteProductFromCart()
    {
        PageBase.clickOnElement(DeleteProductFromCart);
    }
    public void navigateToMyAccountPage()
    {
        PageBase.clickOnElement(myAccountButton);
    }
    public void navigateToHomePage()
    {
        PageBase.clickOnElement(homePageButton);
    }
    public void proceedToCheckOut() throws InterruptedException {
        PageBase.clickOnElement(proceedToCheckoutButton);
        PageBase.clickOnElement(proceedToCheckoutButton2);
        PageBase.clickOnElement(agreeToTermsOfServiceCheckBox);
        PageBase.clickOnElement(proceedToCheckoutButton3);
        PageBase.clickOnElement(payByBankWireButton);
        PageBase.clickOnElement(iConfirmMyOrderButton);
    }
}
