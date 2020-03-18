package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserRegistartionPage extends PageBase {
    public UserRegistartionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_gender1")
    WebElement mrTitle;
    @FindBy(id = "customer_firstname")
    WebElement userFirstNameTxtField;
    @FindBy(id = "customer_lastname")
    WebElement userLastNameTxtField;
    @FindBy(id = "passwd")
    WebElement userPasswordTxtField;
    @FindBy(id = "days")
    WebElement days;
    @FindBy(id = "months")
    WebElement months;
    @FindBy(id = "years")
    WebElement years;
    Select chooseDay;
    Select chooseMonth;
    Select chooseYear;
    /*
    @FindBy(id = "firstname")
     WebElement firstnameTxtField;
     @FindBy(id = "lastname")
     WebElement lastnameTxtField;
     */
    @FindBy(id = "company")
    WebElement companyTxtField;
    @FindBy(id = "address1")
    WebElement addressTxtField;
    @FindBy(id = "city")
    WebElement cityTxtField;
    @FindBy(id = "id_state")
    WebElement stateDropDownElement;
    Select stateDropDownList;
    @FindBy(id = "postcode")
    WebElement postalCode;
    @FindBy(id = "id_country")
    WebElement countryDropDownElement;
    Select countryDropDownList;
    @FindBy(id = "phone_mobile")
    WebElement mobileTxtField;
    @FindBy(id = "alias")
    WebElement addressDescription;
    @FindBy(id = "submitAccount")
    WebElement registerButton;
    public void registerNewUser(String firstname, String lastname, String password, String company, String city, String postalcode, String mobilePhone,String address, String addressAlias)
    {
        PageBase.sendTxtToElement(userFirstNameTxtField, firstname);
      //  PageBase.sendTxtToElement(firstnameTxtField, firstname);
      //  PageBase.sendTxtToElement(lastnameTxtField, lastname);
        PageBase.sendTxtToElement(userLastNameTxtField, lastname);
        PageBase.sendTxtToElement(userPasswordTxtField, password);
        chooseDay=new Select(days);
        chooseDay.selectByValue("2");
        chooseMonth=new Select(months);
        chooseMonth.selectByValue("1");
        chooseYear= new Select(years);
        chooseYear.selectByValue("1990");
        PageBase.sendTxtToElement(companyTxtField,company);
        PageBase.sendTxtToElement(addressTxtField, address);
        PageBase.sendTxtToElement(cityTxtField, city);
        stateDropDownList=new Select(stateDropDownElement);
        stateDropDownList.selectByValue("5");
        PageBase.sendTxtToElement(postalCode, postalcode);
        countryDropDownList=new Select(countryDropDownElement);
        countryDropDownList.selectByValue("21");
        PageBase.sendTxtToElement(mobileTxtField, mobilePhone);
        PageBase.sendTxtToElement(addressDescription, addressAlias );
        PageBase.clickOnElement(registerButton);
    }
}