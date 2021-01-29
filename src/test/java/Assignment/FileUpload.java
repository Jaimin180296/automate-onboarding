package Assignment;

import Executor.DesktopExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class FileUpload extends DesktopExecutor {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public  void setup() throws MalformedURLException {
        driver=driver();

    }

    @Test
    public void test(){
        String baseUrl = "http://demo.guru99.com/test/upload/";


        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("sample.pdf");

        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();
    }

}
