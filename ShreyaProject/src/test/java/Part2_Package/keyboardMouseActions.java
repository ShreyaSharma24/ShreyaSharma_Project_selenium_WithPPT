package Part2_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class keyboardMouseActions {

    public static void main(String args[]) {
        System.out.println("Test");
        System.setProperty("webdriver.chrome.driver","E:\\chrome\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");

            // Create an Actions object
            Actions actions = new Actions(driver);

//        MOUSE CLICK EVENT
            WebElement searchButton=driver.findElement(By.className("Gdd5U"));
            actions.click(searchButton).perform();
            Thread.sleep(2000);

//        MOUSE DRAG AND DROP EVENT
            // Locate the elements for drag and drop
            WebElement googleLogo = driver.findElement(By.className("lnXdpd"));
            Thread.sleep(2000);
            WebElement imageDropArea = driver.findElement(By.className("gIYJUc"));

            // Perform the drag-and-drop action
            actions.dragAndDrop(googleLogo, imageDropArea).perform();
            Thread.sleep(5000);
            driver.navigate().back();
            Thread.sleep(2000);
            WebElement searchBox=driver.findElement(By.name("q"));
            Thread.sleep(1000);
            searchBox.sendKeys("About India");
            Thread.sleep(2000);

//        KEYBOARD ACTION (KEY DOWN)
            actions.sendKeys(Keys.DOWN).perform();//move to first suggestion
            Thread.sleep(1000);
            actions.sendKeys(Keys.DOWN).perform();//move to second suggestion
            Thread.sleep(1000);
            actions.sendKeys(Keys.DOWN).perform();//move to third suggestion
            Thread.sleep(1000);

//        KEYBOARD ACTION (ENTER KEY)
            actions.sendKeys(Keys.ENTER).perform();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            driver.quit();
        }

    }
}
