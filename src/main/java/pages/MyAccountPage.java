package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
