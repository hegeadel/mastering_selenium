package packt.selenium.chap39.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by adel.hegedus on 2016. 04. 12.
 */
public class Google {
    private WebDriver driver;
    private String baseURL;

    public Google(WebDriver driver) {
        this.driver = driver;

        baseURL = "http://www.google.hu/";
        driver.get(baseURL + "?gfe_rd=cr&ei=OrkMV-_6Fs_R8gfF04HICg&gws_rd=ssl");

        if (!"Google-Abc".equals(driver.getTitle())) {
            throw new WrongPageException("Incorrect page for Google");
        }
    }

    public GoogleSearchPage goToSearchPage() {
        driver.findElement(By.id("lst-ib")).sendKeys("Mastering Selenium Testing Tools");
        By searchButton = By.name("btnG");
        driver.findElement(searchButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        return new GoogleSearchPage(driver);
    }
}
