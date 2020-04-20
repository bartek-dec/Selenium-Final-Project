package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {

    private WebDriver driver;

    @FindBy(css = ".logout.hidden-sm-down")
    private WebElement signOutButton;

    @FindBy(css = "span.label.label-pill.bright")
    private WebElement status;

    @FindBy(css = "td.text-xs-right")
    private WebElement totalPrice;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signOut() {
        signOutButton.click();
    }

    public String getStatus() {
        return status.getText().trim();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }
}
