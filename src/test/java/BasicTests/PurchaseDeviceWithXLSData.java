package BasicTests;

import Base.BaseTest;
import Utilities.ReadDeviceDataFile;
import org.testng.annotations.Test;

public class PurchaseDeviceWithXLSData extends BaseTest {

        @Test(dataProviderClass = ReadDeviceDataFile.class, dataProvider = "purchaseData")
        public void purchaseDevice(String email, String password, String devType,String devBrand, String devStorage,
                                   String devColor, String devQuantity, String address, String shipMethod,
                                   String warrantyOption, String discCode) {

            // The implementation of the test will go here, using the provided data to fill out the purchase form and
            // complete the transaction.

            loginPage.login(email, password);
            purchaseDevicePage.fillPurchaseDeviceForm(devType, devBrand, devStorage, devColor, devQuantity,
                    address, shipMethod, warrantyOption, discCode);

        }

          }
