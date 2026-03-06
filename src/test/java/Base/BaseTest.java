package Base;

import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.PurchaseDevicePage;

public class BaseTest {

    BrowserFactory browserFactory = new BrowserFactory();
    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String browserChoice = "chrome";

    public WebDriver driver; // initialized per test
    public LoginPage loginPage;
    public PurchaseDevicePage purchaseDevicePage;

    @BeforeMethod
    public void setUp() {
        driver = browserFactory.startBrowser(browserChoice, url);
        loginPage  = new LoginPage(driver);
        purchaseDevicePage = new PurchaseDevicePage(driver);
    }

    @AfterMethod
    public void tearDown() {

    }


}
