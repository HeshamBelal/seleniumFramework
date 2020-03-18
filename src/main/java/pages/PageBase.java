package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    protected WebDriver drvier;
    public PageBase(WebDriver driver)
    {
        this.drvier= driver;
        PageFactory.initElements(drvier, this);
    }

    public static void clickOnElement(WebElement element)
    {
        element.click();
    }
    public static void sendTxtToElement(WebElement element, String text)
    {
        element.sendKeys(text);
    }
    public static void scrollDownToBottom(WebDriver driver)
    {

    }
}
