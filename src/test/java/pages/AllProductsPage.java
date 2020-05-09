package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AllProductsPage extends HeaderPage {

    private static final String filterByPrice = "Price";

    private WebDriver driver;

    private WebDriverWait wait;

    @FindBy(css = ".product-miniature.js-product-miniature")
    private List<WebElement> products;

    @FindBy(css = "section.facet.clearfix")
    private List<WebElement> filters;

    public AllProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public void selectProduct(String productName) {
        WebElement product = findProduct(productName);

        product.findElement(By.cssSelector(".thumbnail.product-thumbnail")).click();
    }

    public void selectPriceRange(String lower, String upper) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.urlContains("currency")));

        getPriceFilter().findElements(By.className("facet-label"))
                .stream()
                .filter(e -> e.getText().contains(lower))
                .filter(e -> e.getText().contains(upper))
                .findFirst()
                .get()
                .click();
    }

    public List<WebElement> selectFilteredProducts() {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.urlContains(filterByPrice)));

        return driver.findElements(By.className("thumbnail-container"));
    }

    private WebElement findProduct(String productName) {
        WebElement product = products
                .stream()
                .filter(p -> p.getText().contains(productName))
                .findFirst()
                .orElse(null);

        return product;
    }

    private WebElement getPriceFilter() {
        WebElement filter = filters
                .stream()
                .filter(e -> e.getText().contains(filterByPrice))
                .findFirst()
                .orElse(null);

        return filter;
    }
}
