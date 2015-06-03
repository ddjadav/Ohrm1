package Admin1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.id;

/**
 * Created by Jagdish on 11/05/2015.
 */
public class BaseTest extends BaseClass {

    BusinessLibrary blib = new BusinessLibrary();
    Utils utils = new Utils();
    String Adminusername = "admin";
    String AdminPassword = "Insoft12";
    String URL="http://insoftt.trial47.orangehrmlive.com/";
//
//    public void verifyAdminCamLoginwithValidCredentials() {
//        blib.login(Adminusername, AdminPassword);
//        assertEquals("Welcome Admin", driver.findElement(id("welcome")).getText());
//    }
    @Before
    public void openBrowser() {
        driver = new FirefoxDriver();
        driver.get(URL);
        utils.windowm();
    }
    //close browser
    @After
    public void closebrowser() {
        driver.quit();
    }

}
