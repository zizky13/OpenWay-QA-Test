package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    // drivers inherited from BasePage

    // locators
    private By emailTextFormLocation = By.xpath("//*[@id=\"login\"]/div/table/tbody/tr[2]/td/input");
    private By passwordTextFormLocation = By.xpath("//*[@id=\"ps\"]");
    private By submitButtonLocation = By.xpath("//*[@id=\"button-login\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void findAndFillEmailForm(String email) {
        waitForPreloader();
        WebElement emailBox = wait.until(ExpectedConditions.elementToBeClickable(emailTextFormLocation));
        emailBox.click();
        emailBox.sendKeys(email);
    }

    private void findAndFillPasswordForm(String password) {
        waitForPreloader();
        WebElement passwordBox = wait.until(ExpectedConditions.elementToBeClickable(passwordTextFormLocation));
        passwordBox.click();
        passwordBox.sendKeys(password);
    }

    private void submit() {
        waitForPreloader();
        driver.findElement(submitButtonLocation).click();
    }

    public void loginAs(String email, String password) {
        findAndFillEmailForm(email);
        findAndFillPasswordForm(password);
        submit();
    }

}
