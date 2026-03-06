package BasicTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PurchaseDevicePage;

public class purchaseDeviceWithDataProviderTest {

    WebDriver driver;
    LoginPage loginPage;
    PurchaseDevicePage purchaseDevicePage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        purchaseDevicePage = new PurchaseDevicePage(driver);
    }

    @Test(dataProvider = "purchaseData")
    public void purchaseDevice(String email, String password, String devType,String devBrand, String devStorage,
                               String devColor, String devQuantity, String address, String shipMethod,
                               String warrantyOption, String discCode) {

    // The implementation of the test will go here, using the provided data to fill out the purchase form and
    // complete the transaction.

        loginPage.login(email, password);

        purchaseDevicePage.fillPurchaseDeviceForm(devType, devBrand, devStorage, devColor, devQuantity,
                address, shipMethod, warrantyOption, discCode);

    }

    @DataProvider(name = "purchaseData")
    public Object[][] getData() {
        return new Object[][]{
                {"lizbee@gmail.com", "@123abcde", "Phone", "Apple", "128GB", "Blue", "2", "123 Test Street",
                        "express", "1yr", "SAVE10"},

        };
    }
}
