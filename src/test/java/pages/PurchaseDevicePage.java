package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class PurchaseDevicePage {

    WebDriver driver;
    WebDriverWait wait;

    Map<String, By> deviceStorage = new HashMap<>();
    Map<String, By> shippingMethod = new HashMap<>();
    Map<String, By> deviceWarranty = new HashMap<>();


    By learnBtnNav = By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button/span[2]");
    By learningMaterial = By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]");
    By webAutomationAdvanceBtn = By.id("tab-btn-web");
    By inventoryForm = By.id("inventory-title");
    By deviceType = By.id("deviceType");
    By deviceBrand = By.id("brand");
    By deviceColor = By.id("color");
    By deviceQuantity = By.id("quantity");
    By deliveryAddress = By.id("address");
    By nextBtn = By.id("inventory-next-btn");
    By invoicePage = By.id("invoices-toggle-btn");
    By discountCode = By.id("discount-code");
    By applyBtn = By.id("apply-discount-btn");
    By discountFeedback = By.id("discount-feedback");
    By confirmPurchaseBtn = By.id("purchase-device-btn");
    By successToast = By.id("purchase-success-toast");
    By viewInvoiceBtn = By.id("view-history-btn");
    By InvoiceHistory = By.xpath("//*[@id=\"invoice-history-title\"]");
    By viewInvoiceHistoryBtn = (By.cssSelector("button[id^='view-invoice-INV']"));

    public PurchaseDevicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Device storage options
        deviceStorage.put("64GB", By.id("storage-64GB"));
        deviceStorage.put("128GB", By.id("storage-128GB"));
        deviceStorage.put("256GB", By.id("storage-256GB"));

        // Shipping method options
        shippingMethod.put("standard", By.id("shipping-standard"));
        shippingMethod.put("express", By.id("shipping-express"));

        // Device warranty options
        deviceWarranty.put("None", By.id("warranty-none"));
        deviceWarranty.put("1yr", By.id("warranty-1yr"));
        deviceWarranty.put("2yr", By.id("warranty-2yr"));

    }

    public void selectStorageSize(String devStorage) {
        driver.findElement(deviceStorage.get(devStorage)).click();
    }

    public void selectShippingMethod(String shipMethod) {
        driver.findElement(shippingMethod.get(shipMethod)).click();
    }

    public void selectDeviceWarranty(String warrantyOption) {
        driver.findElement(deviceWarranty.get(warrantyOption)).click();
    }

    public void fillPurchaseDeviceForm(String devType,
                                              String devBrand,
                                              String devStorage,
                                              String devColor,
                                              String devQuantity,
                                              String address,
                                              String shipMethod,
                                              String warrantyOption,
                                              String discCode) {

        // Navigate to the learning material and select the web automation advance course

        driver.findElement(learnBtnNav).click();
        WebDriverWait wait7 = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait7.until(driver -> driver.findElement(learningMaterial).isDisplayed());
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
        selectStorageSize(devStorage);
        //driver.findElement(deviceStorage).click();
        driver.findElement(deviceColor).click();
        driver.findElement(deviceColor).click();
        driver.findElement(deviceColor).sendKeys(devColor);
        driver.findElement(deviceQuantity).click();
        driver.findElement(deviceQuantity).sendKeys(devQuantity);
        driver.findElement(deliveryAddress).click();
        driver.findElement(deliveryAddress).sendKeys(address);
        driver.findElement(nextBtn).click();

        // Order preview and  purchase confirmation
        WebDriverWait wait3 = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
        wait3.until(driver -> driver.findElement(invoicePage).isDisplayed());
        selectShippingMethod(shipMethod);
        selectDeviceWarranty(warrantyOption);
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


}
