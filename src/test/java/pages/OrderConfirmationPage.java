package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class OrderConfirmationPage extends HeaderPage {

    private static final String filePath = "src/snapShots/test.png";

    private WebDriver driver;

    private String totalValue;

    @FindBy(css = ".font-weight-bold")
    private WebElement totalPrice;

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void saveTotalValue() {
        List<WebElement> tableData = totalPrice.findElements(By.tagName("td"));
        totalValue = tableData.get(1).getText().trim();
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void takeSnapShot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        File destFile = new File(filePath);

        FileUtils.copyFile(srcFile, destFile);
    }
}
