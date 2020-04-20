package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;

public class OrderConfirmationPage {

    private WebDriver driver;

    private String totalValue;

    @FindBy(className = "account")
    private WebElement userButton;

    @FindBy(css = ".font-weight-bold")
    private WebElement totalPrice;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToAccount() {
        userButton.click();
    }

    public void saveTotalValue() {
        List<WebElement> tableData = totalPrice.findElements(By.tagName("td"));
        totalValue = tableData.get(1).getText().trim();
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void takeSnapShot() throws Exception {
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        File destFile = new File("src/snapShots/test.png");

        FileUtils.copyFile(srcFile, destFile);
    }
}
