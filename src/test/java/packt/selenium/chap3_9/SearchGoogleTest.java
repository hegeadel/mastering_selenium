package packt.selenium.chap3_9;

import packt.selenium.chap39.pageobjects.Google;
import packt.selenium.chap39.pageobjects.GoogleSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by adel.hegedus on 2016. 04. 12.
 */
public class SearchGoogleTest { //Test class
    private WebDriver driver;
    public Google googlePage;
    public GoogleSearchPage searchPage;

    @BeforeTest //Create browser
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterTest  //Close browser
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test   //Execute the test
    public void testGoogleSearch(){
        googlePage = new Google(driver);
        Reporter.log(driver.getTitle(),1,true);
        searchPage = googlePage.goToSearchPage();
        Reporter.log(driver.getTitle(),1,true);
        String numberOfResults = searchPage.getNumberOfResults();
        Reporter.log(numberOfResults,1,true);
    }
}
