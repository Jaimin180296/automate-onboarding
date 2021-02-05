package Assignment;

import Executor.DesktopExecutor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class PerformScriptExecutor extends DesktopExecutor {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup(WebDriver webDriver) throws MalformedURLException {
        driver = driver();
        wait = new WebDriverWait(driver, 30);


    }

    @Test
    public void test() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Launching the Site.
        driver.get("http://demo.guru99.com/V4/");

        //Maximize window
        driver.manage().window().maximize();

        //Set the Script Timeout to 20 seconds
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

        //Declare and set the start time
        long start_time = System.currentTimeMillis();

        //Call executeAsyncScript() method to wait for 5 seconds
        js.executeScript("window.scrollBy(0,1000)");


        //Get the difference (currentTime - startTime)  of times.
        System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));


    }
}
