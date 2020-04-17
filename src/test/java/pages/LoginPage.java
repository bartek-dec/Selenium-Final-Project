package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    private static final String email = "jan123@mail.com";
    private static final String password = "qwerty";

    private WebDriver driver;

    @FindBy(className = "form-control")
    private List<WebElement> inputs;

    @FindBy(id = "submit-login")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterCredentials() {
        inputs.get(0).sendKeys(email);
        inputs.get(1).sendKeys(password);
    }

    public void signIn() {
        signInButton.click();
    }
}
