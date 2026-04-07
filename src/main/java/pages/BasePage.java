package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    // drivers
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    // web elements
    private WebElement signInBtn;
    private WebElement loginBtn;

    // locators
    private By searchBookTextArea = By.id("filter_name_desktop");
    private By signInBtnToHover = By.xpath("//*[@id=\"nav-signin-text\"]/a");
    private By searchBookBtn = By.xpath("/html/body/header/div[2]/div/div[1]/div[2]/div/form/div/button");
    private By loginBtnToHover = By.xpath("/html/body/header/div[2]/div/div[1]/div[3]/div/div[3]/div/ul/li[1]/a");
    private By bookToAddLocation = By.xpath("/html/body/section/div/div/div[2]/div[1]/div[1]/div/div[1]/a");
    private By addToCartLocation = By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/div[1]/div[3]/div[1]/button");
    private By preloader = By.className("preloader");
    private By cartButtonLocation = By.xpath("//*[@id=\"show-your-cart\"]/a");

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action = new Actions(driver);
    }

    // ==== START OF FUNCTIONS SECTION ====
    void waitForPreloader() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(preloader));
    }

    private void enterSearchTerm(String title) {
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(searchBookTextArea));
        searchBox.click();
        searchBox.sendKeys(title);
    }

    private void clickSearch() {
        waitForPreloader();
        driver.findElement(searchBookBtn).click();
    }

    private void selectFirstResult() {
        waitForPreloader();
        wait.until(ExpectedConditions.elementToBeClickable(bookToAddLocation)).click();
    }

    private void addToCart() {
        waitForPreloader();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartLocation)).click();
        wait.withTimeout(Duration.ofSeconds(5));
    }

    private void hoverToSignIn() {
        // - Wait for the sign in to be visible
        // - Perform hover
        signInBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtnToHover));
        action.moveToElement(signInBtn).perform();
    }

    private void hoverToLogin() {
        // - wait for the login button to be clickable
        loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginBtnToHover));
    }

    public void searchAndAddFirstResultToCart(String title) {
        enterSearchTerm(title);
        clickSearch();
        selectFirstResult();
        addToCart();
    }

    public void goToLogin() {
        // wait for any preloader
        waitForPreloader();
        // hover to sign in dropdown
        hoverToSignIn();
        // hover to log in menu
        hoverToLogin();
        // click the login button
        loginBtn.click();
    }

    public void goToCartPage() {
        waitForPreloader();
        wait.until(ExpectedConditions.elementToBeClickable(cartButtonLocation)).click();
    }
}
