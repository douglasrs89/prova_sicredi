package base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import models.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class BaseUtil {
    public WebDriver webDriver;

    public void WaitVisibilityOfText(String text, WebElement webElement, WebDriver webDriver, int maxTime) {
        WebDriverWait wait = new WebDriverWait(webDriver, maxTime);
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    public Customer GetCustomerFromJson(String jsonFileName) throws IOException {
        String dir = System.getProperty("user.dir");
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = objectMapper.readValue(new File(dir + "/src/test/files/" + jsonFileName), Customer.class);
        return customer;
    }
}