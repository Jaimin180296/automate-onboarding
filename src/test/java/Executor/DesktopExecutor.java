package Executor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class DesktopExecutor {
    public WebDriver driver;
    public WebDriverWait wait;
    public final String AUTOMATE_USERNAME = "jaiminmehta3";
    public final String AUTOMATE_ACCESS_KEY = "f2q1FMatZb3X88b19jQ6";
    public final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";



    public WebDriver driver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("build", "Automate-onboarding ");
        caps.setCapability("browserstack.selenium_version", "3.14.0");
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
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

