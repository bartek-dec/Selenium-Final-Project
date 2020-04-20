package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderSummaryPage {

    private WebDriver driver;

    @FindBy(css = "button.btn.btn-primary.continue.float-xs-right")
    private WebElement addressContinueButton;

    @FindBy(css = "span.custom-radio.float-xs-left")
    private WebElement shoppingMethod;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement shoppingMethodContinueButton;

    @FindBy(css = ".payment-option.clearfix")
    private List<WebElement> paymentOptions;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement termsOfService;

    @FindBy(css = ".btn.btn-primary.center-block")
    private WebElement orderWithObligationButton;

    public OrderSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void confirmAddress() {
        addressContinueButton.click();
    }

    public void chooseShoppingMethod() {
        shoppingMethod.click();
    }

    public void confirmShoppingMethod() {
        shoppingMethodContinueButton.click();
    }

    public void choosePaymentOption(String payment) {
        WebElement paymentOption = findPaymentOption(payment);
        paymentOption.findElement(By.cssSelector(".ps-shown-by-js ")).click();
    }

    private WebElement findPaymentOption(String payment) {
        WebElement paymentOption = paymentOptions
                .stream()
                .filter(p -> p.getText().contains(payment))
                .findFirst()
                .orElse(null);

        return paymentOption;
    }

    public void selectTermsOfService() {
        termsOfService.click();
    }

    public void placeAnOrder() {
        orderWithObligationButton.click();
    }
}
