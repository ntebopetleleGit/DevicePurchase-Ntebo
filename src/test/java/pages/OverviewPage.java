package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class OverviewPage {

    WebDriver driver;

    By LogoutButton = By.xpath("/html/body/div/div/nav/div[1]/div[2]/button[1]/span[2]");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
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

// Click Cancel
        // alert.dismiss();
        //  driver.quit();

}
