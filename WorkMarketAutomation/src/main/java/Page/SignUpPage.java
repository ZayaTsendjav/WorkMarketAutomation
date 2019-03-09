package Page;

import base.Util;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class SignUpPage extends Util {
    @FindBy(how = How.XPATH, using = "//button[@tabindex='0']/div/div/span[contains(text(),'Join as an individual')]")
    public static WebElement joinAsIndividual;
    @FindBy(how = How.CSS, using = "#firstname")
    public static WebElement userFirstName;
    @FindBy(how = How.XPATH, using = "//input[@id='lastname']")
    public static WebElement userLastName;
    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    public static WebElement userEmail;
    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    public static WebElement userPassWord;
    @FindBy(how = How.XPATH, using = "//input[@value='on']")
    public static WebElement checkBox;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Register')]")
    public static WebElement registerButton;
    @FindBy(how = How.XPATH, using = "//body[@class='registration-landing']/div/div/div[2]/div[2]")
    public static WebElement loginErrorMessage;

    public void userIndividual()  {
        joinAsIndividual.click();
        userFirstName.click();
        userFirstName.sendKeys("Zaya");
        userLastName.click();
        userLastName.sendKeys("Tsendjav");
        userEmail.click();
        userEmail.sendKeys("qa+candidatetest@workmarket.com");
        userPassWord.click();
        userPassWord.sendKeys("candidate123");
        checkBox.click();
        registerButton.click();

    }
}



