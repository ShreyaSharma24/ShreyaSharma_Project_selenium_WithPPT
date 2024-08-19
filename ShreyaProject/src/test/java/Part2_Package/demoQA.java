package Part2_Package;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class demoQA {

    public static void main(String args[])
    {
        System.out.print("Test");
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
        try{
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/automation-practice-form");
//            FIRSTNAME
            WebElement firstname=driver.findElement(By.id("firstName"));
            firstname.sendKeys("Shreya");
//            LASTNAME
            WebElement lastname=driver.findElement(By.id("lastName"));
            lastname.sendKeys(("Sharma"));
//            EMAIL
            WebElement email=driver.findElement(By.id("userEmail"));
            email.sendKeys("shreya24@gmail.com");
//            GENDER
            WebElement radio= driver.findElement(By.cssSelector("label[for='gender-radio-2']"));
//            PHONENUMBER
            WebElement mobile=driver.findElement(By.id("userNumber"));
            mobile.sendKeys("1234567890");
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radio);
            radio.click();

            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//             DATE OF BIRTH SELECTION
            WebElement date = driver.findElement(By.id("dateOfBirthInput"));
            date.click();

//             YEAR SELECTION
            WebElement year = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".react-datepicker__year-select")));
            year.click();
            WebElement selectYear = driver.findElement(By.cssSelector(".react-datepicker__year-select option[value='2002']"));
            selectYear.click();

//           MONTH SELECTION
            WebElement month = driver.findElement(By.cssSelector(".react-datepicker__month-select"));
            month.click();
            WebElement selectMonth = driver.findElement(By.cssSelector(".react-datepicker__month-select option[value='0']")); // November is 10th month (0-based index)
            selectMonth.click();

//             DAY SELECTION
            WebElement day = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'react-datepicker__day--016') and not(contains(@class, 'react-datepicker__day--outside-month'))]")));
            day.click();

//            SUBJECT
            WebElement subjectInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".subjects-auto-complete__input input")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subjectInput);
            subjectInput.sendKeys("Physics");
            Thread.sleep(1000); // wait for the auto-complete dropdown
            subjectInput.sendKeys(Keys.TAB); // to select the first suggested option
            subjectInput.sendKeys("English");
            Thread.sleep(1000);
            subjectInput.sendKeys(Keys.TAB); // to select the second suggested option

//           HOBBIES
            WebElement hobbies = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hobbies);
            hobbies.click();
            Thread.sleep(1000);

//            IMAGE
            WebElement pic=driver.findElement(By.id("uploadPicture"));
            pic.sendKeys("D:\\images_for _my _proj\\andaman.jpg");

//           CURRENT ADDRESS
            WebElement add=driver.findElement(By.id("currentAddress"));
            add.sendKeys("110,jalandhar ");

//            STATE
            WebElement state = driver.findElement((By.id("react-select-3-input")));
            state.sendKeys("Haryana");
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMillis(1000));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id^='react-select-3-option-2']")));
            WebElement suggestions1 = driver.findElement(By.cssSelector("div[id='react-select-3-option-2']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", suggestions1);

//            CITY SELECTION
            WebElement city = driver.findElement((By.id("react-select-4-input")));
            city.sendKeys("Panipat");
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMillis(1000));
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id^='react-select-4-option-1']")));
            WebElement suggestions2 = driver.findElement(By.cssSelector("div[id='react-select-4-option-1']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", suggestions2);

//            SUBMIT
            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.sendKeys(Keys.ENTER);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            driver.quit();
        }
    }
}
