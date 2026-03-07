package BasicTests;

import Base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class PurchaseDeviceWithDataProviderTest extends BaseTest {


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
