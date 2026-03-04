/*package Base;

import Utilities.BrowserFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class BaseTest {
    BrowserFactory browserFactory = new BrowserFactory();
    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String browserChoice = "chrome";

    public WebDriver driver; // initialized per test
    public LoginPage loginPageWithWaits;

    @BeforeMethod
    public void setUp() {
        driver = browserFactory.startBrowser(browserChoice, url);
        LoginPage loginPage = new LoginPage(driver);
    }

}
public boolean isUserLoggedIn() {
    return !driver.findElements(LogoutButton).isEmpty();
}

public void logout() {
    if (isUserLoggedIn()) {
        driver.findElement(LogoutButton).click();
        driver.findElement(By.xpath("/html/body/div/div/nav/div[1]/div[3]/div/div/button[3]/span[2]")).click();
        // Click OK on the confirmation popup
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
*/