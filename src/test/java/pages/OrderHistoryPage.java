package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage extends HeaderPage {

    private WebDriver driver;

    @FindBy(css = "span.label.label-pill.bright")
    private WebElement status;

    @FindBy(css = "td.text-xs-right")
    private WebElement totalPrice;

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getStatus() {
        return status.getText().trim();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }
}
