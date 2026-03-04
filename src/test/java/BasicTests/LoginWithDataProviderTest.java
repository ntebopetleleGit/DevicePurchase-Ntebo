package BasicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;


@Test(dataProvider = "loginData")

public class LoginWithDataProviderTest {
    WebDriver driver;
    WebDriverWait wait;

    By loginBtnNav = By.xpath("//div[@id='app-root']/nav/div/div[3]/button/span[2]");
    By usereMail = By.id("login-email");
    By userPassword = By.id("login-password");
    By loginBtn = By.id("login-submit");
   // By pageTitle = By.xpath("//h2[contains(text(), 'Welcome back')]");

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
    }

    public void login(String email, String password) {
        driver = new FirefoxDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/#overview");
        driver.manage().window().maximize();
        driver.findElement(loginBtnNav).click();
        driver.findElement(usereMail).sendKeys(email);
        driver.findElement(userPassword).sendKeys(password);
        driver.findElement(loginBtn).click();
        WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait1.until(driver -> driver.getCurrentUrl().equals("https://ndosisimplifiedautomation.vercel.app/#dashboard"));

        String expectedUrl = "https://ndosisimplifiedautomation.vercel.app/#dashboard";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
        System.out.println("Logged in successfully --> The URL matches the expected URL - " + actualUrl);
    }

        @DataProvider(name = "loginData")
        public Object[][] getData() {
            return new Object[][]{
                    {"lizbee@gmail.com", "@123abcde"},


            };
        }
}