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
            public void returnToMyAccountPage()
            {
                PageBase.clickOnElement(myAccountButton);
            }
}
