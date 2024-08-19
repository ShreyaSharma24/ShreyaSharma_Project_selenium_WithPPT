package Part1_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class xpathCssSelector {
    public static void main(String args[]) {
        System.out.print("Test");
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/automation-practice-form");
            WebElement name = driver.findElement(By.xpath("//*[@id='firstName']"));
            name.sendKeys("Shreya");
            WebElement lastname=driver.findElement(By.xpath("//*[@id='lastName']"));
            lastname.sendKeys("sharma");
            WebElement email = driver.findElement(By.cssSelector("#userEmail"));
            email.sendKeys("shreya24@gmail.com");
        } catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }
    }
}
