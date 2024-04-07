package utilities;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;

    @Before
    public static void globalSetup(){
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }
    @After
    public static void globalTeardown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
