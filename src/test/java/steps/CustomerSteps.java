package steps;

import base.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import models.Customer;
import org.junit.Assert;
import pageObjects.CustomerAddPage;
import pageObjects.CustomerPage;

import java.io.IOException;

public class CustomerSteps extends BaseUtil {
    private BaseUtil baseUtil;
    private CustomerPage customerPage;
    private CustomerAddPage customerAddPage;

    public CustomerSteps(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
        customerPage = new CustomerPage(baseUtil.webDriver);
        customerAddPage = new CustomerAddPage(baseUtil.webDriver);
    }

    @Given("User navigate to the grocery page")
    public void userNavigateToTheGroceryPage() {
        baseUtil.webDriver.navigate().to("https://www.grocerycrud.com/demo/bootstrap_theme");
    }

    @And("Select the ([^\"]*) version")
    public void selectBootstrapVersion(String version) {
        customerPage.SelectVersion(version, this.baseUtil.webDriver, 5);
    }

    @When("I click on Add Customer button")
    public void iClickOnAddCustomerButton() {
        customerPage.ClickAddCustomer(this.baseUtil.webDriver, 5);
    }

    @And("I click on Save button")
    public void iClickOnSaveButton() throws InterruptedException {
        customerAddPage.buttonSave.click();
    }

    @Then("I should see the success message ([^\"]*)")
    public void iShouldSeeTheSuccessMessage(String message) {
        baseUtil.WaitVisibilityOfText(message, customerAddPage.messageSuccess, this.baseUtil.webDriver, 5);
        Assert.assertEquals(message, customerAddPage.messageSuccess.getText());
    }

    @And("I click on the link Go back to list")
    public void iClickOnTheLinkBackToList() {
        String message = "Your data has been successfully stored into the database. Edit Customer or Go back to list";
        baseUtil.WaitVisibilityOfText(message, customerAddPage.messageSuccess, this.baseUtil.webDriver, 5);
        customerAddPage.linkGoBackToList.click();
    }

    @And("I enter ([^\"]*) on Search Name")
    public void iEnterOnSearchName(String name) throws InterruptedException {
        customerPage.SearchByName(name, this.baseUtil.webDriver, 5);
    }

    @And("I click on the checkbox to select all")
    public void iClickOnTheCheckboxToSelectAll() throws InterruptedException {
        customerPage.checkBoxSelectAll.click();
    }

    @And("I click on Action button Delete")
    public void iClickOnActionButtonDelete() throws InterruptedException {
        customerPage.buttonActionDelete.click();
    }

    @Then("I should see the confirm message ([^\"]*)")
    public void iShouldSeeTheConfirmMessage(String message) throws InterruptedException {
        baseUtil.WaitVisibilityOfText(message, customerPage.messagePopupDelete, this.baseUtil.webDriver, 5);
        Assert.assertEquals(message, customerPage.messagePopupDelete.getText());
    }

    @And("I click on Delete button of popup")
    public void iClickOnDeleteButtonOfPopup() throws InterruptedException {
        customerPage.buttonPopupDelete.click();
    }

    @And("I should see the success alert message ([^\"]*)")
    public void iShouldSeeTheSuccessAlertMessage(String message) {
        baseUtil.WaitVisibilityOfText(message, customerPage.alertMessage, this.baseUtil.webDriver, 5);
        Assert.assertEquals(message, customerPage.alertMessage.getText());
    }

    @And("I fill the fields with the customer data")
    public void iFillTheFieldsWithTheCustomerData() throws IOException {
        Customer customer = baseUtil.GetCustomerFromJson("customer.json");
        customerAddPage.AddNewCustomerFromJson(customer);
    }

}
