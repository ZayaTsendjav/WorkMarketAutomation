package TestPage;

import Page.SignUpPage;
import Page.UserLogin;
import base.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestUserLogin extends Util {
    UserLogin userlogin;
    @BeforeMethod
    public void init(){
        userlogin = PageFactory.initElements(driver, UserLogin.class);
    }
    @Test
    public void userLoginTest() {
        userlogin.userIndividualLogin();
        String Actual = driver.findElement(By.xpath("//img[@alt='Work Market Logo']")).getText();
        String Expected = "WorkMarket";
        Assert.assertEquals(Actual, Expected);
    }
    @Test
    public void userTalentNav(){
        userlogin.clickOnHamburgerMenu();
        String Actual = driver.findElement(By.xpath("//div[contains(text(),'Find Talent')]")).getText();
        String Expected = "FindTalent";
        Assert.assertEquals(Actual, Expected);
    }
}
