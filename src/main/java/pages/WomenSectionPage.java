package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class WomenSectionPage extends PageBase {
    public WomenSectionPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "TOPS")
    private WebElement topsSubcategory;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/div[2]/ul/li[2]/h5/a")
    private WebElement dressesSubcategory;
    public void selectTopsSubcategory()
    {
        PageBase.clickOnElement(topsSubcategory);
    }
    public void selectDressesSubcategory()
    {
        PageBase.clickOnElement(dressesSubcategory);
    }
}
