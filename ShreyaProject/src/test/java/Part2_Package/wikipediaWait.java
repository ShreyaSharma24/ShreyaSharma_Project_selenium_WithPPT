
package Part2_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class wikipediaWait {

    public static void main(String args[]) {
        System.out.println("Test");
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        try {
            // Implicit Wait: Set globally for all elements
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.manage().window().maximize();
            driver.get("https://www.wikipedia.org/");

            // Extract and interact with links
            List<WebElement> listOfLanguages = driver.findElements(By.cssSelector(".central-featured-lang a"));
            int size = listOfLanguages.size();
            System.out.println("Number of language links: " + size);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            for (int i = 0; i < size; i++) {
                try {
                    WebElement link = listOfLanguages.get(i);
                    String href = link.getAttribute("href");
                    if (!href.isEmpty()) {
                        System.out.println("Link of language is: " + href);

                        // Explicit Wait: Wait until the element is clickable before interacting
                        wait.until(ExpectedConditions.elementToBeClickable(link));
                        link.click();

                        // Optional wait for the page to load or interact with elements on the new page
                        Thread.sleep(3000);

                        // Navigate back to the main page and refresh the list of languages
                        driver.navigate().back();

                        // Re-fetch the list of languages after navigation
                        listOfLanguages = driver.findElements(By.cssSelector(".central-featured-lang a"));
                    }
                } catch (Exception e) {
                    System.out.println("Some error occurred: " + e.getMessage());
                }
            }

            // Select a language using dropdown and search for a topic
            WebElement languageSearch = driver.findElement(By.id("searchLanguage"));
            Select selectLanguage = new Select(languageSearch);
            selectLanguage.selectByVisibleText("English");

            WebElement searchInput = driver.findElement(By.id("searchInput"));
            if (searchInput != null) {
                searchInput.sendKeys("About India");
                searchInput.sendKeys(Keys.RETURN);
                Thread.sleep(5000);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            driver.quit();
        }
    }
}

