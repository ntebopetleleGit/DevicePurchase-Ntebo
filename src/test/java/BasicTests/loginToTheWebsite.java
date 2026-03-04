package BasicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class loginToTheWebsite {

    WebDriver driver;


    @Test                  //added to mark this method testable - it enables the execution
    public void loginWithValidCredentials() throws InterruptedException {

        // driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/#overview");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@id='app-root']/nav/div/div[3]/button/span[2]")).click();
        driver.findElement(By.id("login-email")).sendKeys("lizbee@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("@123abcde");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(5000);


        String expectedUrl = "https://ndosisimplifiedautomation.vercel.app/#dashboard";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
        System.out.println("Logged in successfully --> The URL matches the expected URL - " + actualUrl);
    }


}
