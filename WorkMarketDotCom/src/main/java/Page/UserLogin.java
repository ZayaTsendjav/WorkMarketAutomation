package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserLogin extends Util {
    @FindBy (how = How.XPATH, using = "//ul[@class='nav navbar-nav navbar-right hidden-xs hidden-sm']//a[contains(text(),'Log In')]")
    public static WebElement loginIcon;
    @FindBy (how = How.XPATH, using = "//input[@name='userEmail']")
    public static WebElement userEmail;
    @FindBy (how = How.XPATH, using = "//input[@id='login-password']")
    public static WebElement loginPassword;
    @FindBy (how = How.XPATH, using = "//button[@id='login_page_button']")
    public static WebElement login;
    @FindBy(how = How.XPATH,using = "//body[contains(@class,'TestPage-search')]/div[contains(@class,'open')]/header[@id='wm-main-nav']/div[contains(@data-radium,'true')]/div/button[contains(@type,'button')]/div/*[1]")
    public static WebElement hamburgerMenu;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Find Talent')]")
    public static WebElement findTalent;

    public void userIndividualLogin() {
        loginIcon.click();
        userEmail.click();
        userEmail.sendKeys("qa+candidatetest@workmarket.com");
        loginPassword.click();
        loginPassword.sendKeys("candidate123");
        login.click();
    }
    public void clickOnHamburgerMenu(){
        hamburgerMenu.click();
        findTalent.click();

    }
}
