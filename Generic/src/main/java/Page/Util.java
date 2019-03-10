package Page;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Util {
    public static WebDriver driver = null;
    public static Actions builder = null;
    public static WebDriverWait wait = null;

    @BeforeMethod
    public void initializeTest() {
        String getOsNameFromSystem = System.getProperty("os.name");
        System.out.println("Opening the browser : Chrome");
        if (getOsNameFromSystem.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "/Users/zayka/Desktop/WorkMarketAutomation/Generic/driver/chromedriver");
        } else if (getOsNameFromSystem.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "/Users/zayka/Desktop/WorkMarketAutomation/Generic/driver/chromedriver.exe");
        }
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // 20
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS); //35
        driver.get("https://dev.workmarket.com/register/campaign/10081C503B209A0C8E7F05FDCC1AA98D4C904DEEF5F73265CAE38C744E7EAD3E");
        driver.get("http://dev.workmarket.com/login");
        driver.manage().window().fullscreen();
    }

    @AfterMethod
    public void tearDownTest() {
        System.out.println("Closing the browser : Chrome");
        //driver.quit();
    }

    public void clickOnCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    public void clickOnElement(String locator) {
        try {
            driver.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex1) {
            try {
                driver.findElement(By.xpath(locator)).click();
            } catch (Exception ex2) {
                driver.findElement(By.id(locator)).click();
            }
        }
    }

    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void typeByCssNEnter(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }

    public void typeByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void takeEnterKeys(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    public void clearInputField(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public List<WebElement> getListOfWebElementsById(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.id(locator));
        return list;
    }

    public String getCurrentPageUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public String getTextByXpath(String locator) {
        String st = driver.findElement(By.xpath(locator)).getText();
        return st;
    }

    public String getTextById(String locator) {
        return driver.findElement(By.id(locator)).getText();
    }

    public String getTextByName(String locator) {
        String st = driver.findElement(By.name(locator)).getText();
        return st;
    }

    public void mouseHoverByCSS(String locator) {
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();

        }
    }

    public void mouseHoverByXpath(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }

    //Taking Screen shots
    public void takeScreenShot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("screenShots.png"));
    }

    public void clearInput(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public void keysInput(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    public void typeOnInputBox(String locator, String value) {
        try {
            driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            System.out.println("ID locator didn't work");
        }
        try {
            driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex2) {
            System.out.println("Name locator didn't work");
        }
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex3) {
            System.out.println("CSS locator didn't work");
        }

       /* public void scrollDown(){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)");
        }*/
    }
    }
