package BasicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(dataProvider = "loginData")

public class LoginToTheWebsiteToPurchase {

        WebDriver driver;

        By loginBtnNav = By.xpath("//div[@id='app-root']/nav/div/div[3]/button/span[2]");
        By userEmail = By.id("login-email");
        By userPassword = By.id("login-password");
        By loginBtn = By.id("login-submit");
        // By pageTitle = By.xpath("//h2[contains(text(), 'Welcome back')]");
        By learnBtnNav = By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button/span[2]");
        By learningMaterial = By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]");
        By webAutomationAdvanceBtn = By.id("tab-btn-web");
        By inventoryForm = By.id("inventory-title");
        By deviceType = By.id("deviceType");
        By deviceBrand = By.id("brand");
        By deviceStorage = By.id("storage-128GB");
        By deviceColor = By.id("color");
        By deviceQuantity = By.id("quantity");
        By deliveryAddress = By.id("address");
        By nextBtn = By.id("inventory-next-btn");
        By invoicePage = By.id("invoices-toggle-btn");
        By shippingMethod = By.id("shipping-express");
        By deviceWarranty = By.id("warranty-1yr");
        By discountCode = By.id("discount-code");
        By applyBtn = By.id("apply-discount-btn");
        By discountFeedback = By.id("discount-feedback");
        By confirmPurchaseBtn = By.id("purchase-device-btn");
        By successToast = By.id("purchase-success-toast");
        By viewInvoiceBtn = By.id("view-history-btn");
        By InvoiceHistory = By.xpath("//*[@id=\"invoice-history-title\"]");
        //By viewInvoiceHistoryBtn = By.id("view-invoice-INV-1772566733012");
        By viewInvoiceHistoryBtn = (By.cssSelector("button[id^='view-invoice-INV']"));


        public void login (String email, String password, String devType, String devBrand, String devStorage,
                           String devColor, String devQuantity, String address, String shipMethod,
                           String warrantyOption, String discCode) {

            driver = new FirefoxDriver();
            driver.get("https://ndosisimplifiedautomation.vercel.app/#overview");
            driver.manage().window().maximize();
            driver.findElement(loginBtnNav).click();
            driver.findElement(userEmail).sendKeys(email);
            driver.findElement(userPassword).sendKeys(password);
            driver.findElement(loginBtn).click();
            WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
            wait1.until(driver -> driver.getCurrentUrl().equals("https://ndosisimplifiedautomation.vercel.app/#dashboard"));

            /*String expectedUrl = "https://ndosisimplifiedautomation.vercel.app/#dashboard";
            String actualUrl = driver.getCurrentUrl();

            Assert.assertEquals(actualUrl, expectedUrl);
            System.out.println("Logged in successfully --> The URL matches the expected URL - " + actualUrl);


public void purchase() {*/

            // Navigate to the learning material and select the web automation advance course

            driver.findElement(learnBtnNav).click();
            driver.findElement(learningMaterial).click();
            driver.findElement(webAutomationAdvanceBtn).click();
            WebDriverWait wait2 = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
            wait2.until(driver -> driver.findElement(inventoryForm).isDisplayed());

            // Fill out the inventory form to purchase a device
            driver.findElement(webAutomationAdvanceBtn).click();
            driver.findElement(deviceType).click();
            driver.findElement(deviceType).sendKeys(devType);
            driver.findElement(deviceBrand).click();
            driver.findElement(deviceBrand).sendKeys(devBrand);
            driver.findElement(deviceStorage).click();
            driver.findElement(deviceColor).click();
            driver.findElement(deviceColor).sendKeys(devColor);
            driver.findElement(deviceQuantity).sendKeys(devQuantity);
            driver.findElement(deliveryAddress).sendKeys(address);
            driver.findElement(nextBtn).click();

 // Order preview and  purchase confirmation
            WebDriverWait wait3 = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
            wait3.until(driver -> driver.findElement(invoicePage).isDisplayed());
            driver.findElement(shippingMethod).click();
            driver.findElement(deviceWarranty).click();
            driver.findElement(discountCode).sendKeys(discCode);
            driver.findElement(applyBtn).click();
            WebDriverWait wait4 = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
            wait4.until(driver -> driver.findElement(discountFeedback).isDisplayed());
           // Assert.assertEquals(driver.findElement(discountFeedback).getAttribute("SAVE10"), discCode);
            driver.findElement(confirmPurchaseBtn).click();

 // View invoice page
            WebDriverWait wait5 = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
            wait5.until(driver -> driver.findElement(successToast).isDisplayed());
            Assert.assertTrue(driver.findElement(successToast).isDisplayed());
            driver.findElement(viewInvoiceBtn).click();
            WebDriverWait wait6 = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
            wait6.until(driver -> driver.findElement(InvoiceHistory).isDisplayed());
            driver.findElement(viewInvoiceHistoryBtn).click();





}

        @DataProvider(name = "loginData")
        public Object[][] getData () {
            return new Object[][]{
                    {"lizbee@gmail.com", "@123abcde","Phone","Apple","128GB","Blue","2","123 Main Street, Anytown, SA",
                            "standard", "1yr","SAVE10"},

            };
        }
    }
/*
public void logout() {
    if (isUserLoggedIn()) {
        driver.findElement(LogoutButton).click();
        driver.findElement(By.xpath("/html/body/div/div/nav/div[1]/div[3]/div/div/button[3]/span[2]")).click();
        // Click OK on the confirmation popup
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][]{
                {"lizbee@gmail.com", "@123abcde"},

        };
    }*/
