package Part1_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class exampleWebsite {
    public static void main(String args[]) {
        System.setProperty("webdriver.chrome.driver", "E:\\chrome\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/");
        try {
            driver.manage().window().maximize();
            WebElement link= driver.findElement(By.linkText("More information..."));
            link.click();
            Thread.sleep(2000);
            WebElement link1=driver.findElement(By.linkText("Domains"));
            link1.click();
            Thread.sleep(2000);
            WebElement link2=driver.findElement(By.linkText("The DNS Root Zone"));
            link2.click();
            Thread.sleep(2000);
            WebElement link3=driver.findElement(By.linkText("Protocols"));
            link3.click();
            Thread.sleep(2000);
            WebElement listItem4 = driver.findElement(By.id("nav_prot_tz"));
            WebElement link4 = listItem4.findElement(By.tagName("a"));
            link4.click();
            Thread.sleep(2000);
            WebElement link5=driver.findElement(By.linkText("Numbers"));
            link5.click();
            Thread.sleep(2000);
            WebElement link6 = driver.findElement(By.xpath("//a[text()='Abuse Issues']"));
            link6.click();
            Thread.sleep(2000);
            WebElement link7=driver.findElement(By.linkText("About"));
            link7.click();
            Thread.sleep(2000);
            WebElement link8=driver.findElement(By.cssSelector("a[href='/performance']"));
            link8.click();
            Thread.sleep(2000);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            driver.quit();
        }
    }
}
