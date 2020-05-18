package pageObjects;

import models.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerAddPage {
    public CustomerAddPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.ID, using = "field-customerName")
    public WebElement inputName;

    @FindBy(how = How.ID, using = "field-contactLastName")
    public WebElement inputLastName;

    @FindBy(how = How.ID, using = "field-contactFirstName")
    public WebElement inputContactFirstName;

    @FindBy(how = How.ID, using = "field-phone")
    public WebElement inputPhone;

    @FindBy(how = How.ID, using = "field-addressLine1")
    public WebElement inputAddressLine1;

    @FindBy(how = How.ID, using = "field-addressLine2")
    public WebElement inputAddressLine2;

    @FindBy(how = How.ID, using = "field-city")
    public WebElement inputCity;

    @FindBy(how = How.ID, using = "field-state")
    public WebElement inputState;

    @FindBy(how = How.ID, using = "field-postalCode")
    public WebElement inputPostalCode;

    @FindBy(how = How.ID, using = "field-country")
    public WebElement inputCountry;

    @FindBy(how = How.ID, using = "field_salesRepEmployeeNumber_chosen")
    public WebElement chosenFromEmployeer;

    @FindBy(how = How.ID, using = "field-salesRepEmployeeNumber")
    public WebElement selectFromEmployeer;

    @FindBy(how = How.ID, using = "field-creditLimit")
    public WebElement inputCreditLimit;

    @FindBy(how = How.ID, using = "form-button-save")
    public WebElement buttonSave;

    @FindBy(how = How.ID, using = "report-success")
    public WebElement messageSuccess;

    @FindBy(how = How.XPATH, using = "//a[text()[contains(., 'Go back to list')]]")
    public WebElement linkGoBackToList;

    public void SelectFromEmployeer(String value) {
        chosenFromEmployeer.click();
        Select dropDown = new Select(selectFromEmployeer);
        dropDown.selectByVisibleText(value);
    }

    public void AddNewCustomerFromJson(Customer customer) {
        inputName.sendKeys(customer.getName());
        inputLastName.sendKeys(customer.getLastName());
        inputContactFirstName.sendKeys(customer.getContactFirstName());
        inputPhone.sendKeys(customer.getPhone());
        inputAddressLine1.sendKeys(customer.getAddressLine1());
        inputAddressLine2.sendKeys(customer.getAddressLine2());
        inputCity.sendKeys(customer.getCity());
        inputState.sendKeys(customer.getState());
        inputPostalCode.sendKeys(customer.getPostalCode());
        inputCountry.sendKeys(customer.getCountry());
        SelectFromEmployeer(customer.getFromEmployer());
        inputCreditLimit.sendKeys(customer.getCreditLimit());
    }

}
