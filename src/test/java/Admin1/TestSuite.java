package Admin1;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Jagdish on 11/05/2015.
 */
public class TestSuite extends BaseTest {
    //Admin login test
    //Utils utils=new Utils();
    String Adminusername = "admin";
    String AdminPassword = "Insoft12";
    String firstName = "dipal", lastName = "Tester";
    String newUserName = "TestUsername" + Utils.randomNumber();
    String userPassword="Password1";
    String usrname = "username" + new Date();
    String location = "ASC_London";
    String sucessmessage = "Successfully Saved";

//    @Test
//    public void verifyAdminCamLoginwithValidCredentials() {
//        blib.login(Adminusername, AdminPassword);
//        assertEquals("Welcome Admin", driver.findElement(By.id("welcome")).getText());
//        blib.logout();
//
//    }

    @Test(@DataProvider="dp")
    public void VerifyAdminCanAddEmployeeSuccessfully() {
        blib.login(hashCode(Ad), AdminPassword);
        assertEquals("Welcome Admin", utils.gettext(By.id("welcome")));
        blib.click(By.id("menu_pim_viewPimModule"));
        blib.click(By.id("menu_pim_addEmployee"));
        assertEquals("Add Employee", utils.gettext(By.xpath(".//*[@id='content']/div/div[1]/h1")));
        blib.addEmp(firstName, lastName, newUserName, userPassword, userPassword, );

        blib.logout();
        blib.login(firstName+Utils.randomNumber(), "Rajesh02");
        assertEquals("Welcome " + firstName, Utils.gettext(By.id("welcome")));
        blib.logout();
    }
    @Test
    public void verifyAdminCanAddAndDeleteUser(){
        blib.login(Adminusername, AdminPassword);
        assertEquals("Welcome Admin", utils.gettext(By.id("welcome")));
        blib.addEmp(firstName, lastName, newUserName, userPassword, userPassword, location);
        assertTrue(utils.isTextPresent(sucessmessage));
        blib.deleteEmp();
    }
  //  @Test
    public void VerifyAdminCanDeleteUSer() {
        blib.login(Adminusername, AdminPassword);
        assertEquals("Welcome Admin", utils.gettext(By.id("welcome")));
        blib.click(By.id("menu_pim_viewPimModule"));
        blib.enterText(By.id("empsearch_id"), "0320");
        blib.click(By.id("searchBtn"));
        blib.click(By.xpath(".//*[@id='ohrmList_chkSelectRecord_321']"));
        blib.click(By.id("btnDelete"));
        blib.click(By.id("dialogDeleteBtn"));
        assertFalse(driver.findElement(By.xpath(".//*[@id='ohrmList_chkSelectRecord_321']")).isDisplayed());
    }

    @Test
    public void VerifyAdminCanUpdateOrgsGeneralInfo() {
        blib.login(Adminusername, AdminPassword);
        assertEquals("Welcome Admin", Utils.gettext(blib.welcomemessage));
        blib.click(By.id("menu_admin_viewAdminModule"));
        blib.click(By.id("menu_admin_Organization"));
        blib.click(By.id("menu_admin_viewOrganizationGeneralInformation"));
        blib.click(By.id("btnSaveGenInfo"));
        blib.enterText(By.id("organization_name"), "Unique It Support");
        blib.enterText(By.id("organization_phone"), "02030699536");
        blib.enterText(By.id("organization_email"), "info@uniqueitsupport.co.uk");
        blib.enterText(By.id("organization_fax"), "02030699536");
        blib.selecttext(By.id("organization_country"), "Ghana");
        blib.click(By.id("btnSaveGenInfo"));
        assertTrue(utils.isTextPresent("Successfully Saved"));

    }

  //  @Test
    public void VerifyAdminCanAssignLeve() {
        blib.login(Adminusername, AdminPassword);
        assertEquals("Welcome Admin", utils.gettext(By.id("welcome")));
        blib.click(By.id("menu_leave_viewLeaveModule"));
        blib.click(By.id("menu_leave_assignLeave"));
        blib.enterText(By.id("assignleave_txtEmployee_empName"), "Rajesh Patel");
        //blib.selecttext(By.id("assignleave_txtEmployee_empName"), "Rajesh Patel");
        blib.selecttext(By.id("assignleave_txtLeaveType"), "Diwali");
        blib.click(By.id("assignleave_txtFromDate"));
        blib.selecttext(By.xpath("//div[@id='ui-datepicker-div']/div/div/select[2]"), "2016");
        blib.selecttext(By.xpath("//div[@id='ui-datepicker-div']/div/div/select"),"May");
        blib.selecttext(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[4]/td/a"),"18");
        blib.click(By.id("assignleave_txtToDate"));
        blib.selecttext(By.id("ui-datepicker-month"), "Jul");
        blib.selecttext(By.id("ui-datepicker-year"), "2017");
        blib.selecttext(By.id("ui-datepicker-day"), "20");
        blib.enterText(By.id("Special Grant For Good Worker"), "Special Grant For Good Worker");
        blib.click(By.id("assignBtn"));
    }

}
