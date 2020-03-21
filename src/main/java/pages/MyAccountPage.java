package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Sign out")
    public WebElement signOutButton;
    @FindBy(id= "search_query_top")
    private WebElement searchTxtField;
    @FindBy(css = "div.ac_results")
    private WebElement quickSearchTxtFieldResult;
    @FindBy(tagName = "h1")
    public static WebElement nameOfProductSearchedFromQuickSearch;
    @FindBy(css = "button.btn.btn-default.button-search")
    private WebElement searchButton;
    @FindBy(css = "a.sf-with-ul")
    public WebElement WomenSection;
    @FindBy(linkText = "Dresses")
    public WebElement dressesSection;
    @FindBy(linkText = "T-shirts")
    private WebElement tShirts;
    @FindBy(linkText = "Summer Dresses")
    private WebElement summerDresses;
    Actions action;
    public void hooverOnWomenSection(WebDriver driver1) throws InterruptedException {
        action=new Actions(driver1);
        action.moveToElement(WomenSection)
                .build()
                .perform();
        Thread.sleep(2000);
        action.moveToElement(tShirts).click(tShirts).build().perform();
    }
    public void selectSummerDressesFromDressesSection(WebDriver driver)
    {
        action= new Actions(driver);
        action.moveToElement(summerDresses).click().build().perform();
    }
    public void hooverOnDressesSection(WebDriver driver)
    {
        action=new Actions(driver);
        action.moveToElement(dressesSection);
    }
    public void pressOnSearchTxtField()
    {
        PageBase.clickOnElement(searchTxtField);
    }
    public void insertTextToSearchField(String text)
    {
        PageBase.sendTxtToElement(searchTxtField, text);
    }
    public void pressOnQuickSearchResults()
    {
        PageBase.clickOnElement(quickSearchTxtFieldResult);
    }
    public void pressOnSearchButton()
    {
        PageBase.clickOnElement(searchButton);
    }
    public void logoutFromTheWebPAge()
    {
        PageBase.clickOnElement(signOutButton);
    }
}
