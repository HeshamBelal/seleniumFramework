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
      @FindBy(tagName = "h2")
      public WebElement productAdditionToCartSuccessTextMessage;
      @FindBy(id="layer_cart_product_price")
      public WebElement totalPrice;
    @FindBy(linkText = "Proceed to checkout")
    private WebElement proceedToCheckoutButton;
      public void returnToMyAccountPage()
    {
        PageBase.clickOnElement(myAccountButton);
    }
    public void addProductToCart()
    {
        PageBase.clickOnElement(addToCartButton);
    }
    public void addProductToWishList()
    {
        PageBase.clickOnElement(addToWishListButton);
    }
    public void proceedToCheckout()
    {
        PageBase.clickOnElement(proceedToCheckoutButton);
    }
}
