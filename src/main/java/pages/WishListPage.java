package pages;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class WishListPage extends PageBase {
    public WishListPage(WebDriver driver) {
        super(driver);
    }
    //@FindBy(css = "table.table.table-bordered")
    //private WebElement myWishListTable;
    //@FindBy(tagName = "tr")
    //List<WebElement> wishListRows;
    //@FindBy(tagName = "td")
    //List<WebElement> wishListColumns;
    @FindBy(linkText = "My account")
    private  WebElement myAccountButton;
    @FindBy(css = "td.bold.align_center")
    private WebElement wishListQuantity;
    public String wishlistQuanityValue;
    @FindBy(id = "name")
    private WebElement nameWishListTxtField;
    @FindBy(linkText = "Mai WishList")
    private WebElement myWishlistName;
    @FindBy(id="submitWishlist")
    private WebElement saveWishListButton;
    @FindBy(css = "i.icon-remove")
    public WebElement deleteWishListButton;
    public void navigateToMyAccountPage()
    {
        PageBase.clickOnElement(myAccountButton);
    }
    public boolean checkForWishList(String name)//if there is exception then this means the WishList has been deleted successfully.
    {
        try{
            if (myWishlistName.getText().equalsIgnoreCase(name))
            {
                return true;
            }
        }
        catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public void deleteWishList()
    {
        PageBase.clickOnElement(deleteWishListButton);
        PageBase.acceptAlertBox(drvier);
        // drvier.switchTo().defaultContent();
    }
    public void saveWishList(String name)
    {
        PageBase.clickOnElement(nameWishListTxtField);
        PageBase.sendTxtToElement(nameWishListTxtField,name);
        PageBase.clickOnElement(saveWishListButton);
    }
    public boolean checkQuantityInMyWishListTable()
    {
        return wishListQuantity.getText().contains("1");
    }
}
