package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage {

    private static final String euro = "EUR";
    private static final String dollar = "USD";

    private WebDriver driver;

    private WebDriverWait wait;

    @FindBy(className = "account")
    private WebElement userButton;

    @FindBy(css = ".logout.hidden-sm-down")
    private WebElement signOutButton;

    @FindBy(css = ".hidden-sm-down.btn-unstyle")
    private WebElement currencyButton;

    @FindBy(css = ".currency-selector.dropdown.js-dropdown")
    private WebElement currency;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public void signOut() {
        signOutButton.click();
    }

    public void goToAccount() {
        userButton.click();
    }

    public void selectEUR() {
        if (!currencyButton.getText().contains(euro)) {
            currencyButton.click();

            wait.until(ExpectedConditions.visibilityOfAllElements(currency.findElements(By.tagName("li"))));
            selectCurrency(euro).click();
        }
    }

    public void selectUSD() {
        if (!currencyButton.getText().contains(dollar)) {
            currencyButton.click();

            wait.until(ExpectedConditions.visibilityOfAllElements(currency.findElements(By.tagName("li"))));
            selectCurrency(dollar).click();
        }
    }

    private WebElement selectCurrency(String currencyName) {
        WebElement element = currency.findElements(By.tagName("li"))
                .stream()
                .filter(e -> e.getText().contains(currencyName))
                .findFirst()
                .orElse(null);

        return element;
    }
}
