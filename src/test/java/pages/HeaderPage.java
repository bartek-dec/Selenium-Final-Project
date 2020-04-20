package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

    private WebDriver driver;

    @FindBy(className = "account")
    private WebElement userButton;

    @FindBy(css = ".logout.hidden-sm-down")
    private WebElement signOutButton;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signOut() {
        signOutButton.click();
    }

    public void goToAccount() {
        userButton.click();
    }
}
