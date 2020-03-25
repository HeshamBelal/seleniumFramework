package pages;

import org.openqa.selenium.JavascriptExecutor;
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
    public static void scrollDownToWebElement(WebDriver driver1,WebElement Element)
    {
        JavascriptExecutor js=(JavascriptExecutor) driver1;
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }
    public static void clickOnElement(WebElement element)
    {
        element.click();
    }
    public static void sendTxtToElement(WebElement element, String text)
    {
        element.sendKeys(text);
    }
    public static void acceptAlertBox(WebDriver driver1)
    {
        driver1.switchTo().alert().accept();
    }
    public static void scrollDownToBottom(WebDriver driver)
    {

    }
}
