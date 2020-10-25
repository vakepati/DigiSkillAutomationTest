package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinitions.WebDriverSingleton;

public class FullVehicleDetailsPage {
    WebDriver driver;

    @FindBy(xpath = "//*[contains(text(),'Registration')]/parent::*/dd")
    private WebElement registrationNumber;

    @FindBy(xpath = "//*[contains(text(),'Make')]/parent::*/dd")
    private WebElement make;

    @FindBy(xpath = "//*[contains(text(),'Model')]/parent::*/dd")
    private WebElement modle;

    @FindBy(xpath = "//*[contains(text(),'Colour')]/parent::*/dd")
    private WebElement colour;

    @FindBy(xpath = "//*[contains(text(),'Year')]/parent::*/dd")
    private WebElement year;

    public FullVehicleDetailsPage() {
        this.driver = WebDriverSingleton.instantiateWebDriverInstance();
        PageFactory.initElements(driver, this);
    }

    public String getVehicleRegistrationNumber() {
        WaitTillElementPresent(registrationNumber);
        return registrationNumber.getText();
    }

    public String getVehicleModel() {
        WaitTillElementPresent(modle);
        return modle.getText();
    }

    public String getVehicleColour() {
        WaitTillElementPresent(colour);
        return colour.getText();
    }

    public String getVehicleYear() {
        WaitTillElementPresent(year);
        return year.getText();
    }

    public String getCarMake() {
        WaitTillElementPresent(make);
        return make.getText();
    }

    private void WaitTillElementPresent(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }


}
