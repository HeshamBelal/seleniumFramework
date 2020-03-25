package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class ProductPage extends PageBase{
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(partialLinkText = "Hesham")
    private WebElement myAccountButton;
    @FindBy(css = "span.heading-counter")
    public static WebElement productPageResultText;
    @FindBy(css = "button.exclusive")
    private WebElement addToCartButton;
    @FindBy(id= "wishlist_button")
    private WebElement addToWishListButton;
    @FindBy(tagName = "h1")
    public static WebElement nameOfProduct;
    @FindBy(tagName = "h2")
    public WebElement productAdditionToCartSuccessTextMessage;
    @FindBy(id="layer_cart_product_price")
    public WebElement totalPrice;
    @FindBy(linkText = "Proceed to checkout")
    private WebElement proceedToCheckoutButton;
    @FindBy(css = "span.continue.btn.btn-default.button.exclusive-medium")
    private WebElement continueShoppingButton;
    @FindBy(css = "a.fancybox-item.fancybox-close")
    private WebElement closeAddedToWishListMessae;
    public void navigateToMyAccountPage()
    {
        PageBase.clickOnElement(myAccountButton);
    }
    public void addProductToCart()
    {
        PageBase.clickOnElement(addToCartButton);
    }
    public void continueShopping()
    {
        PageBase.clickOnElement(continueShoppingButton);
    }
    public void addProductToWishList() throws InterruptedException {
        PageBase.clickOnElement(addToWishListButton);
        Thread.sleep(2000);
        PageBase.clickOnElement(closeAddedToWishListMessae);
    }
    public void proceedToCheckout() throws InterruptedException {
        Thread.sleep(2000);
        PageBase.clickOnElement(proceedToCheckoutButton);
    }
}
