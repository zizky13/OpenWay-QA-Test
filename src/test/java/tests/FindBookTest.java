package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class FindBookTest extends BaseTest {
    @Test
    public void findBook() {
        HomePage home = new HomePage(driver);
        home.searchBook("Sapiens");
    }
}
