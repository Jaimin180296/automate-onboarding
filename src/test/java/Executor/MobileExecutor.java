package Executor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileExecutor {
    public WebDriver driver;
    public WebDriverWait wait;
    public final String AUTOMATE_USERNAME = "jaiminmehta3";
    public final String AUTOMATE_ACCESS_KEY = "f2q1FMatZb3X88b19jQ6";
    public final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";



        public WebDriver driver() throws MalformedURLException {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os_version", "10.0");
            caps.setCapability("device", "Vivo Y50");
            caps.setCapability("real_mobile", "true");
            caps.setCapability("browserstack.local", "false");
            driver = new RemoteWebDriver(new URL(URL), caps);
            SessionId session = ((RemoteWebDriver) driver).getSessionId();
            System.out.println("Session id: " + session.toString());
            return driver;
        }

        @AfterTest
        public void destroy() {
            driver.quit();
        }

    }







