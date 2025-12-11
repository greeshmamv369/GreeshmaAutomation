package automation.pages;

import automation.utils.SeleniumUtils;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static automation.Base.BaseClass.extentReports;

public class ProductClickPage {
    private WebDriver driver;
    private SeleniumUtils utils;
    ExtentTest tests=extentReports.createTest("RegisterTest");

    @FindBy(xpath = "//a[text()='Cameras']")
    private WebElement camera;


    public ProductClickPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new SeleniumUtils(driver);   // pass REAL driver
        PageFactory.initElements(driver, this);   // now driver is NOT null
    }
    public void PdClick() {
    utils.click(camera);
    }
}
