package Assignment;

import Executor.DesktopExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class Herokuapp extends DesktopExecutor {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        driver = driver();
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void Test() {
        driver.get("https://the-internet.herokuapp.com/login");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']"))).sendKeys("tomsmith");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).sendKeys("SuperSecretPassword!");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
        System.out.println(driver.getTitle());
    }

}
