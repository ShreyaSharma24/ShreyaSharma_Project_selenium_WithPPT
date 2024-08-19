package Part1_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chromeDriver {
    public static void main(String args[]) {
        System.setProperty("webdriver.chrome.driver","E:\\chrome\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        System.out.println("Title: " + driver.getTitle());
    }
}