package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;
    //LoginPage loginPage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

   /* @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        //loginPage = new LoginPage(driver);
    }*/

    By loginBtnNav = By.xpath("//div[@id='app-root']/nav/div/div[3]/button/span[2]");
    By userEmail = By.id("login-email");
    By userPassword = By.id("login-password");
    By loginBtn = By.id("login-submit");


    public void login(String email, String password) {


        driver.findElement(loginBtnNav).click();
        driver.findElement(userEmail).sendKeys(email);
        driver.findElement(userPassword).sendKeys(password);
        driver.findElement(loginBtn).click();
        WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
        wait1.until(driver -> driver.getCurrentUrl().equals("https://ndosisimplifiedautomation.vercel.app/#dashboard"));
    }

         }
