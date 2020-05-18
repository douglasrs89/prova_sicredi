package steps;

import base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hook extends BaseUtil {

    public  BaseUtil baseUtil;

    public Hook(BaseUtil baseUtil){
        this.baseUtil = baseUtil;
    }

    @Before
    public void InitializeTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/webDriver/chromedriver");
        System.setProperty("webdriver.chrome.silentOutput", "true");

        baseUtil.webDriver = new ChromeDriver();
        baseUtil.webDriver.manage().window().maximize();
        baseUtil.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void TearDownTest(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) baseUtil.webDriver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

        baseUtil.webDriver.quit();
    }

}
