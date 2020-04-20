package task2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BuyProduct {

    private WebDriver driver;

    private LoginPage loginPage;
    private AccountPage accountPage;
    private MainPage mainPage;
    private AllProductsPage allProductsPage;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;
    private OrderSummaryPage orderSummaryPage;
    private OrderConfirmationPage orderConfirmationPage;
    private OrderHistoryPage orderHistoryPage;

    @Given("user logged in to account")
    public void logInToAccount() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");

        loginPage = new LoginPage(driver);
        loginPage.enterCredentials();
        loginPage.signIn();
    }

    @When("user goes to all products")
    public void goToAllProducts() {
        accountPage = new AccountPage(driver);
        accountPage.goToMainPage();

        mainPage = new MainPage(driver);
        mainPage.goToAllProducts();
    }

    @And("user chooses product name (.*)")
    public void selectProduct(String productName) {
        allProductsPage = new AllProductsPage(driver);
        allProductsPage.selectProduct(productName);
    }

    @And("discount is (.*)")
    public void confirmDiscount(String discount) {
        productPage = new ProductPage(driver);
        productPage.getDiscount().isDisplayed();

        if (!productPage.getDiscount().getText().contains(discount)) {
            throw new InvalidArgumentException("Discount value does not match");
        }
    }

    @And("user chooses product size (.*)")
    public void selectSize(String size) {
        productPage.selectSize(size);
    }

    @And("user chooses quantity (.*) of products")
    public void selectQuantity(String quantity) {
        productPage.provideQuantity(quantity);
    }

    @And("user adds products to the basket")
    public void addProductsToCart() {
        productPage.addProductsToCart();
    }

    @And("user goes to shopping card")
    public void goToShoppingCart() {
        productPage.proceedToCheckout();
    }

    @And("user goes to checkout")
    public void goToCheckout() {
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.proceedToCheckout();
    }

    @And("user confirms address")
    public void confirmAddress() {
        orderSummaryPage = new OrderSummaryPage(driver);
        orderSummaryPage.confirmAddress();
    }

    @And("user chooses pick up method as pick up in store")
    public void confirmShoppingMethod() {
        orderSummaryPage.chooseShoppingMethod();
        orderSummaryPage.confirmShoppingMethod();
    }

    @And("user chooses payment method as (.*)")
    public void choosePaymentMethod(String payment) {
        orderSummaryPage.choosePaymentOption(payment);
    }

    @And("user agrees to the terms of service")
    public void selectTermsOfService() {
        orderSummaryPage.selectTermsOfService();
    }

    @And("user chooses order with an obligation to pay option")
    public void placeAnOrder() {
        orderSummaryPage.placeAnOrder();
    }

    @And("user does a print screen")
    public void takeSnapShot() {
        orderConfirmationPage = new OrderConfirmationPage(driver);
        try {
            orderConfirmationPage.takeSnapShot();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @And("user goes to order history")
    public void goToOrderHistory() {
        orderConfirmationPage.saveTotalValue();
        orderConfirmationPage.goToAccount();

        accountPage.goToOrderHistory();
    }

    @Then("order status is (.*)")
    public void checkStatus(String status) {
        orderHistoryPage = new OrderHistoryPage(driver);

        Assert.assertEquals(status, orderHistoryPage.getStatus());
    }

    @And("products price conform to price from the basket")
    public void comparePrice() {
        Assert.assertEquals(orderConfirmationPage.getTotalValue(), orderHistoryPage.getTotalPrice());
    }

    @And("user logs out from account")
    public void signOut() {
        orderHistoryPage.signOut();
    }

    @And("user close the browser")
    public void tearDown() {
        driver.close();
    }
}
