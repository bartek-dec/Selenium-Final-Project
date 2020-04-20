package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllProductsPage {

    private WebDriver driver;

    @FindBy(css = ".product-miniature.js-product-miniature")
    private List<WebElement> products;

    public AllProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectProduct(String productName) {
        WebElement product = findProduct(productName);

        product.findElement(By.cssSelector(".thumbnail.product-thumbnail")).click();
    }

    private WebElement findProduct(String productName) {
        WebElement product = products
                .stream()
                .filter(p -> p.getText().contains(productName))
                .findFirst()
                .orElse(null);

        return product;
    }
}
