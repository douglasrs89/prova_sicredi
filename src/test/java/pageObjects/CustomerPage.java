package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CustomerPage {
    public CustomerPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "switch-version")
    public  WebElement selectVersion;

    @FindBy(how = How.XPATH, using = "//a[text()[contains(.,'Add Customer')]]")
    public WebElement buttonAddCustomer;

    @FindBy(how = How.NAME, using = "customerName")
    public WebElement inputSearchName;

    @FindBy(how = How.XPATH, using = "//tbody//tr[1]//td[3]")
    public WebElement tableFirstRowColumnName;

    @FindBy(how = How.CLASS_NAME, using = "select-all-none")
    public WebElement checkBoxSelectAll;

    @FindBy(how = How.CLASS_NAME, using = "delete-selected-button")
    public WebElement buttonActionDelete;

    @FindBy(how = How.CLASS_NAME, using = "alert-delete-multiple-one")
    public WebElement messagePopupDelete;

    @FindBy(how = How.CLASS_NAME, using = "delete-multiple-confirmation-button")
    public WebElement buttonPopupDelete;

    @FindBy(how = How.XPATH, using = "//span[@data-growl='message']")
    public WebElement alertMessage;


    public boolean SelectVersion(String value, WebDriver webDriver, int maxTime) {
        new WebDriverWait(webDriver, maxTime).until((ExpectedConditions.elementToBeClickable(selectVersion)));

        Select dropDown = new Select(selectVersion);
        dropDown.selectByVisibleText(value);
        WebDriverWait wait = new WebDriverWait(webDriver, maxTime);
        wait.until(ExpectedConditions.elementToBeClickable(buttonAddCustomer));
        return true;
    }

    public boolean ClickAddCustomer(WebDriver webDriver, int maxTime) {
        new WebDriverWait(webDriver, maxTime).until(ExpectedConditions.visibilityOf(buttonAddCustomer));
        new WebDriverWait(webDriver, maxTime).until((ExpectedConditions.elementToBeClickable(buttonAddCustomer)));
        buttonAddCustomer.click();
        return true;
    }

    public void SearchByName(String name, WebDriver webDriver, int maxTime) {
        WebDriverWait wait = new WebDriverWait(webDriver, maxTime);
        inputSearchName.sendKeys(name);
        inputSearchName.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.textToBePresentInElement(tableFirstRowColumnName, name));

    }



}
