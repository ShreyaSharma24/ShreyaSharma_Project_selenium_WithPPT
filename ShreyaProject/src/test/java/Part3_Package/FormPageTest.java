package Part3_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FormPageTest {
    private WebDriver driver;
    private FormPage formPage;

        @Test
        public void testing()
        {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        FormPage formPage = new FormPage(driver);
        formPage.fillFirstName("Shreya");
        formPage.fillLastName("Sharma");
        formPage.fillEmail("shreya24@gmail.com");
        formPage.selectGender();
        formPage.fillMobileNumber("1234567890");
        formPage.selectDateOfBirth();
        try {
            formPage.fillSubjects("Physics", "English");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        formPage.selectHobbies();
        formPage.uploadImage("D:\\images_for _my _proj\\andaman.jpg");
        formPage.fillCurrentAddress("110, Jalandhar");
        formPage.selectState("Haryana");
        formPage.selectCity("Panipat");
        formPage.submitForm();

    }
}