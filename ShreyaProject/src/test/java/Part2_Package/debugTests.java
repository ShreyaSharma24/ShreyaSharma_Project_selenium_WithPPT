package Part2_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class debugTests {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Setting up WebDriver system property
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.34.0-win64\\geckodriver.exe");

        try {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://www.selenium.dev/");
        } catch (Exception ex) {
            ex.printStackTrace();
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @Test
    public void test_one() {
        WebElement link1 = driver.findElement(By.linkText("Downloads"));
        link1.click();
    }
    @Test
    public void test_two()
    {
        WebElement link1 = driver.findElement(By.linkText("Documentation"));
        link1.click();
    }
    @Test
    public void test_three() {
        WebElement link = driver.findElement(By.linkText("Register now!"));
        link.click();
    }
}
