package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".discount.discount-percentage")
    private WebElement discount;

    @FindBy(css = ".form-control.form-control-select")
    private WebElement sizeSelector;

    @FindBy(id = "quantity_wanted")
    private WebElement quantitySelector;

    @FindBy(css = ".btn.btn-primary.add-to-cart")
    private WebElement addToCartButton;

    @FindBy(css = "a.btn.btn-primary")
    private WebElement proceedButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public WebElement getDiscount() {
        return discount;
    }

    public void selectSize(String size) {
        new Select(sizeSelector).selectByVisibleText(size);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.urlContains("size-" + size.toLowerCase())));
    }

    public void provideQuantity(String quantity) {
        quantitySelector.clear();
        quantitySelector.sendKeys(quantity);
    }

    public void addProductsToCart() {
        getAddToCartButtonn().click();
    }

    public void proceedToCheckout() {
        getProceedButton().click();
    }

    private WebElement getProceedButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(proceedButton));

        return button;
    }

    private WebElement getAddToCartButtonn() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

        return button;
    }
}
