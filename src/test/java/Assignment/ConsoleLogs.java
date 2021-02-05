package Assignment;

import Executor.DesktopExecutor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ConsoleLogs  extends DesktopExecutor {
    WebDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        driver=driver();

    }

    @Test
    public void setup1(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("http://demo.guru99.com/V4/");

        //Maximize window
        driver.manage().window().maximize();

        //Set the Script Timeout to 20 seconds
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

        //Declare and set the start time
        long start_time = System.currentTimeMillis();

        //Call executeAsyncScript() method to wait for 5 seconds
        js.executeScript("window.scrollBy(0,1000)");
        ((JavascriptExecutor) driver).executeScript("console.log('Jaimin');");
        ((JavascriptExecutor) driver).executeScript("console.warn('Browserstack');");

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            //do something useful with the data
        }






        //Get the difference (currentTime - startTime)  of times.
        System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));

    }
}
