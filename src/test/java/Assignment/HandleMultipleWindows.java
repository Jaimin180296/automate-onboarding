package Assignment;

import Executor.DesktopExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;

public class HandleMultipleWindows extends DesktopExecutor {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        driver = driver();
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void destroy() {
        driver.get("http://www.naukri.com/");

// It will return the parent window name as a String
        String parent = driver.getWindowHandle();

        Set<String> s = driver.getWindowHandles();

// Now iterate using Iterator
        Iterator<String> I1 = s.iterator();

        while (I1.hasNext()) {

            String child_window = I1.next();


            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);

                System.out.println(driver.switchTo().window(child_window).getTitle());

                driver.close();
            }
        }
    }
}


