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
}
