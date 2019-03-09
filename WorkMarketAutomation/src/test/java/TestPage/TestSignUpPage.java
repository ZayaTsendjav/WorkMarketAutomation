package TestPage;
import Page.SignUpPage;
import base.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSignUpPage extends Util {
    SignUpPage logIn;
    @BeforeMethod
    public void init(){
        logIn = PageFactory.initElements(driver, SignUpPage.class);
    }
    @Test
    public void VerifyLoginPage() throws InterruptedException {
        logIn.userIndividual();
        String Actual = driver.findElement(By.xpath("//body[@class='registration-landing']/div/div/div[2]/div[2]")).getText();
        String Expected = "YourPasswordEnteredIsNotAllowedBecauseIt'sTooSimple";
        Assert.assertEquals(Actual, Expected);
    }
}
