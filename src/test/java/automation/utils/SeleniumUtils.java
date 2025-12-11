package automation.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.Duration;

public class SeleniumUtils {

    private WebDriver driver;
    private static final int DEFAULT_TIMEOUT = 10;

    // Constructor
    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
    }

    // ---------------- Basic Actions ----------------
    public void type(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
        LoggerUtils.logInfo("Element with text entered"+element);
    }

    public void click(WebElement element) {
        waitForClickability(element);
        element.click();
        LoggerUtils.logInfo("Element clicked");

    }

    public String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    // ---------------- Wait Utilities ----------------
    public void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForPresence(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    // ---------------- Advanced Actions ----------------
    public void hover(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    public void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).perform();
    }

    public void rightClick(WebElement element) {
        new Actions(driver).contextClick(element).perform();
    }

    // ---------------- Dropdown Handling ----------------
    public void selectByVisibleText(WebElement dropdown, String text) {
        new Select(dropdown).selectByVisibleText(text);
    }

    public void selectByValue(WebElement dropdown, String value) {
        new Select(dropdown).selectByValue(value);
    }

    public void selectByIndex(WebElement dropdown, int index) {
        new Select(dropdown).selectByIndex(index);
    }
    //_______________________________Screenshots________________________
    public File takeScreenshots(WebDriver driver, String Filename)
    {
        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File descFile=new File("src/test/resources/Screenshots");
        return descFile;
    }
}