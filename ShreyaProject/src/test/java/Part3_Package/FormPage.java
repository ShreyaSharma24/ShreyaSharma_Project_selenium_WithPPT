package Part3_Package;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class FormPage {
    private WebDriver driver;
    @FindBy(id="firstName")
    WebElement firstname;
    @FindBy(id = "lastName")
    WebElement lastname;
    @FindBy(id = "userEmail")
    WebElement email;
    @FindBy(css = "label[for='gender-radio-2']")
    WebElement genderRadio;
    @FindBy(id = "userNumber")
    WebElement mobile;
    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;
    @FindBy(css = ".react-datepicker__year-select")
    WebElement yearSelect;
    @FindBy(css = ".react-datepicker__month-select")
    WebElement monthSelect;
    @FindBy(xpath = "//div[contains(@class, 'react-datepicker__day--016') and not(contains(@class, 'react-datepicker__day--outside-month'))]")
    WebElement daySelect;
    @FindBy(css = ".subjects-auto-complete__input input")
    WebElement subjectInput;
    @FindBy(css = "label[for='hobbies-checkbox-1']")
    WebElement hobbiesCheckbox;
    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;
    @FindBy(id = "currentAddress")
    WebElement currentAddress;
    @FindBy(id = "react-select-3-input")
    WebElement stateInput;
    @FindBy(css = "div[id^='react-select-3-option-2']")
    WebElement stateSuggestion;
    @FindBy(id = "react-select-4-input")
    WebElement cityInput;
    @FindBy(css = "div[id^='react-select-4-option-1']")
    WebElement citySuggestion;
    @FindBy(id = "submit")
    WebElement submitButton;
    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize WebElements
    }
    public void fillFirstName(String firstName) {
        firstname.sendKeys(firstName);
    }
    public void fillLastName(String lastName) {
        lastname.sendKeys(lastName);
    }
    public void fillEmail(String userEmail) {
        email.sendKeys(userEmail);
    }
    public void selectGender() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderRadio);
        genderRadio.click();
    }
    public void fillMobileNumber(String phoneNumber) {
        mobile.sendKeys(phoneNumber);
    }
    public void selectDateOfBirth() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dateOfBirthInput);
        dateOfBirthInput.click();
        yearSelect.click();
        WebElement selectYear = driver.findElement(By.cssSelector(".react-datepicker__year-select option[value='2002']"));
        selectYear.click();
        monthSelect.click();
        WebElement selectMonth = driver.findElement(By.cssSelector(".react-datepicker__month-select option[value='0']")); // January
        selectMonth.click();
        daySelect.click();
    }
    public void fillSubjects(String subject1, String subject2) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subjectInput);
        subjectInput.sendKeys(subject1);
        Thread.sleep(1000); // wait for the auto-complete dropdown
        subjectInput.sendKeys(Keys.TAB); // to select the first suggested option
        subjectInput.sendKeys(subject2);
        Thread.sleep(1000);
        subjectInput.sendKeys(Keys.TAB); // to select the second suggested option
    }
    public void selectHobbies() {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hobbiesCheckbox);
        hobbiesCheckbox.click();

        }
    public void uploadImage(String imagePath) {
        uploadPicture.sendKeys(imagePath);
    }
    public void fillCurrentAddress(String address) {
        currentAddress.sendKeys(address);
    }
    public void selectState(String state) {
        stateInput.sendKeys(state);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(stateSuggestion));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", stateSuggestion);
    }
    public void selectCity(String city) {
        cityInput.sendKeys(city);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(citySuggestion));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", citySuggestion);
    }
    public void submitForm() {
        submitButton.sendKeys(Keys.ENTER);
    }
}