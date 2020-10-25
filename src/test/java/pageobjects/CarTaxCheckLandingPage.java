package pageobjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinitions.WebDriverSingleton;

public class CarTaxCheckLandingPage {


    WebDriver driver;

    public CarTaxCheckLandingPage() {
        this.driver = WebDriverSingleton.instantiateWebDriverInstance();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "vrm-input")
    private WebElement vrmInputTextBox;

    @FindBy(xpath = "//button[text()='Free Car Check']")
    private WebElement freeCheck;

//    @FindBy(xpath = "//*[contains(text(),'Registration')]/parent::*/dd")
//    private WebElement registrationNumber;
//
//    @FindBy(xpath = "//*[contains(text(),'Make')]/parent::*/dd")
//    private WebElement make;
//
//    @FindBy(xpath = "//*[contains(text(),'Model')]/parent::*/dd")
//    private WebElement modle;
//
//    @FindBy(xpath = "//*[contains(text(),'Colour')]/parent::*/dd")
//    private WebElement colour;
//
//    @FindBy(xpath = "//*[contains(text(),'Year')]/parent::*/dd")
//    private WebElement year;


    public void enterCarRegistrationNumber(String regNumber) throws InterruptedException {
        vrmInputTextBox.clear();
        vrmInputTextBox.sendKeys(regNumber);
        freeCheck.click();

//        WaitTillElementPresent(make);
//
//
//        System.out.println("printing reg number..."+ make.getText());
    }

    private void WaitTillElementPresent(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void openCarTaxWebSite(){
        driver.navigate().to("https://cartaxcheck.co.uk/");
    }
//    public FullVehicleDetailsPage submit() {
//        freeCheck.click();
//        return new FullVehicleDetailsPage(driver);
//    }
}
