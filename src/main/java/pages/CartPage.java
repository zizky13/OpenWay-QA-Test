package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By itemQuantity = By.xpath("//*[@id=\"qty_67918450\"]");
    private int quantity;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getItemQuantity() {
        waitForPreloader();

        try {
            quantity = Integer.parseInt(driver.findElement(itemQuantity).getAttribute("value"));
        } catch (NumberFormatException e) {
            quantity = 0;
        }

    return quantity;
    }
}
