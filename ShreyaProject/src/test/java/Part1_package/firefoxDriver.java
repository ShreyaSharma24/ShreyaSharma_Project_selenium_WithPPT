package Part1_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firefoxDriver {
    public static void main(String args[]) {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
        driver.get("https://google.com/");
        driver.manage().window().maximize();
        System.out.println("Title: " + driver.getTitle());
    }
}
