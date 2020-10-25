package stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.CarTaxCheckLandingPage;
import pageobjects.FullVehicleDetailsPage;

public class TestStepDefinitions {

    CarTaxCheckLandingPage carTaxCheckLandingPage = new CarTaxCheckLandingPage();
    FullVehicleDetailsPage fullVehicleDetailsPage = new FullVehicleDetailsPage();


    static WebDriver driver;
    List<String> inputVehicleRegNumbers;
    Map<String, CsvReading> listOfOuptVehicleDetails;

    @Given("^I have list of Car Registration Numbers in the \"([^\"]*)\"$")
    public void vehicleDetailsAreThereInThe(String filePath) throws Throwable {
        String fileContent = TestUtils.readInputFileAsString(filePath);
        inputVehicleRegNumbers = TestUtils.getDataOnRegx(fileContent);
    }

    @When("^I have expected car details are there in the \"([^\"]*)\"$")
    public void vehicleDetailsAreVerifiedOnTheCartaxCheckWebsite(String outputFile) throws Throwable {
        listOfOuptVehicleDetails = TestUtils.getOutPutDataFromCSV(outputFile);


    }

    @Then("^Actual vehicle details are verified with expected details$")
    public void vehicleDetailsShouldMatchTheDetailsInThe() throws Throwable {
        getActualVechicleDataAndAssertWithOutputData(listOfOuptVehicleDetails);
    }

    @Then("^I check car details in the cartax check website$")
    public void navigateCarCheckSite() {
        driver = WebDriverSingleton.instantiateWebDriverInstance();
        carTaxCheckLandingPage.openCarTaxWebSite();
    }


    // Read Vehicle Details From the OutPut File and Assert with displayed full car details page
    private void getActualVechicleDataAndAssertWithOutputData(Map<String, CsvReading> map) throws Exception {

        for (String regNumbFromInputText : inputVehicleRegNumbers) {

            CsvReading csvData = map.get(regNumbFromInputText);
            if (csvData == null) {
                System.out.println("No vehicle output data found for Vehicle Reg :  " + regNumbFromInputText);
            } else {
                carTaxCheckLandingPage.enterCarRegistrationNumber(regNumbFromInputText);


                // Reading Vehicle details from OutPut Text

                String carRegNumbFromOutputText = csvData.getREGISTRATION();
                String carMake = csvData.getMAKE();
                String carModel = csvData.getMODEL();
                String carColor = csvData.getCOLOR();
                String carRegistrationYear = csvData.getYEAR();


                String retrievedRegistrationNumberFromFullVehicleDetailsPage = fullVehicleDetailsPage.getVehicleRegistrationNumber();
                String retrieveMakeFromFullVehicleDetailsPage = fullVehicleDetailsPage.getCarMake();
                String retrieveModelFromFullVehicleDetailsPage = fullVehicleDetailsPage.getVehicleModel();
                String rertrieveColourFromFullVehicleDetailsPage = fullVehicleDetailsPage.getVehicleColour();
                String retrieveYearFromFullVehicleDetailsPage = fullVehicleDetailsPage.getVehicleYear();

                // Assert Registration Number in the full Vehicle Details Page
                Assert.assertEquals("Registration Number Verification", carRegNumbFromOutputText, retrievedRegistrationNumberFromFullVehicleDetailsPage);

                // Assert Car Make Value in the full Vehicle Details Page
                Assert.assertEquals("Make Verification", carMake, retrieveMakeFromFullVehicleDetailsPage);

                // Assert Car Model Value in the full Vehicle Details Page
                Assert.assertEquals("Model Verification", carModel, retrieveModelFromFullVehicleDetailsPage);

                // Assert Car Color Value in the full Vehicle Details Page
                Assert.assertEquals("Colour Verification", carColor, rertrieveColourFromFullVehicleDetailsPage);

                // Assert Car Year Value in the full Vehicle Details Page
                Assert.assertEquals("Year Verification", carRegistrationYear, retrieveYearFromFullVehicleDetailsPage);
            }
            if (regNumbFromInputText != null) carTaxCheckLandingPage.openCarTaxWebSite();
        }
    }


    @After
    public void afterScenario(Scenario scenario) {
        driver.quit();
    }

}
