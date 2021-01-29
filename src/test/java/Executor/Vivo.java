package Executor;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Vivo extends MobileExecutor{
    WebDriver driver;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver=driver();


    }

    @Test(invocationCount = 10)
    public void destroy(){
        driver.get("https://www.google.com/");
    }
}
