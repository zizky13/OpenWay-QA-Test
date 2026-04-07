package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // locators
    private By searchBookTextArea = By.id("filter_name_desktop");
//    private By signInBtnToHover = By.id("nav-signin-text");
    private By searchBookBtn = By.xpath("/html/body/header/div[2]/div/div[1]/div[2]/div/form/div/button");
//    private By loginBtn = By.xpath("/html/body/header/div[2]/div/div[1]/div[3]/div/div[3]/div/ul/li[1]/a");
    private By bookToAddLocation = By.xpath("/html/body/section/div/div/div[2]/div[1]/div[1]/div/div[1]/a");
//    private By addToCartLocation = By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/div[1]/div[3]/div[1]/button");




    public HomePage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchBook(String title) {
        // Search book
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(searchBookTextArea));
        searchBox.click();
        searchBox.sendKeys(title);
        driver.findElement(searchBookBtn).click();

        // select the first book found
        WebElement bookToAdd = wait.until(ExpectedConditions.elementToBeClickable(bookToAddLocation));
        bookToAdd.click();

        // add book to cart
//        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocation));
//        addButton.click();
//        wait.withTimeout(Duration.ofSeconds(5));
    }

}
