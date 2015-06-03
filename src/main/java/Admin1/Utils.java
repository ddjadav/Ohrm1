package Admin1;

import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jagdish on 11/05/2015.
 */
public class Utils extends BaseClass {

    Random ram = new Random();
    int name = ram.nextInt(1000000);
    String ruser="Rajesh"+name;

    //method for timeout
    public static void timesetup(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    //method to maximazie Window
    public static void windowm(){
        driver.manage().window().maximize();
    }
    public static void rnumber(String user) {


    }
    public  static boolean isElementpresent(By element)
    {
        return driver.findElement(element).isDisplayed();

    }
    public  static boolean isTextPresent(String text)
    {
        return driver.findElement(By.tagName("body")).getText().contains(text);
    }

    public  static String gettext(By aa)
    {
        return driver.findElement(aa).getText();
    }

    public static String randomNumber()
    {
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(new Date());
    }
}
