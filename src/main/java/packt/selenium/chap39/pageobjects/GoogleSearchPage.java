package packt.selenium.chap39.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by adel.hegedus on 2016. 04. 12.
 */
public class GoogleSearchPage {
    private WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        if (!"Mastering Selenium Testing Tools - Google keresés".equals(driver.getTitle())) {
            throw new WrongPageException("Incorrect page for Google Search Page");
        }
    }

    public String getNumberOfResults() {
        return driver.findElement(By.id("resultStats")).getText();
    }
}
