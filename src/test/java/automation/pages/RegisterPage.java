package automation.pages;

import automation.utils.JsonReader;
import automation.utils.LoggerUtils;
import automation.utils.SeleniumUtils;
import com.aventstack.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.xml.xpath.XPath;
import java.io.File;

import static automation.Base.BaseClass.extentReports;

public class RegisterPage {
    private static final Logger logger=Logger.getLogger(String.valueOf(RegisterPage.class));
    ExtentTest tests=extentReports.createTest("RegisterTest");

    private WebDriver driver;
    private SeleniumUtils utils;
    JsonReader jsonreader=new JsonReader(new File("src/test/resources/TestData/registerData.json"));

    @FindBy(name = "firstname")
    private WebElement firstname;

    @FindBy(id = "input-lastname")
    private WebElement lastname;
    @FindBy(name = "email")
    private WebElement Email;
    @FindBy(name = "telephone")
    private WebElement telephone;
    @FindBy(name = "password")
    private WebElement pass;
    @FindBy(name = "confirm")
    private WebElement cpassword;
    @FindBy(xpath= "//input[@value='Continue']")
    private WebElement continuebtn;
    @FindBy(xpath="//*[text()=\" Warning: You must agree to the Privacy Policy!\"]")
    private WebElement errorMessage;
    @FindBy(id="Login")
    private WebElement loginLink;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new SeleniumUtils(driver);   // pass REAL driver
        PageFactory.initElements(driver, this);   // now driver is NOT null
    }

    public void newUserRegister() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("New User register begins");

//        String text=jsonreader.getObjectFieldFromArray(1,"firstName");
//Enter the firstname in app
        utils.type(firstname, jsonreader.getString("firstName"));
        //Print the details im Extent report
        tests.info("Entered the firstname:" + jsonreader.getString("firstName"));
        utils.type(lastname, jsonreader.getString("lastName"));
        tests.info("Entered the lastname:" + jsonreader.getString("lastName"));
        File registerpath=utils.takeScreenshots(driver,"register");
        tests.addScreenCaptureFromBase64String(String.valueOf(registerpath),"Registerpage completeion");
        utils.type(Email, jsonreader.getString("email"));
        tests.info("Entered the Email:" + jsonreader.getString("email"));
        utils.type(telephone, jsonreader.getString("Telephone"));
        tests.info("Entered the Phone number:" + jsonreader.getString("Telephone"));
        utils.type(pass, jsonreader.getString("password"));
        tests.info("Entered the Password:" + jsonreader.getString("password"));
        utils.type(cpassword, jsonreader.getString("confirmPassword"));
        tests.info("Entered the Confirmation passered:" + jsonreader.getString("confirmPassword"));
        utils.click(continuebtn);

        Thread.sleep(3000);
        boolean value = utils.isDisplayed(errorMessage);
        if (value) {
            logger.error("register not complete");

        } else {
            logger.info("register  complete");

        }

        tests.pass("New registeration passed");
    }
public void userLogin()
{
    logger.info("User login");
    utils.click(loginLink);
    tests.info("Clicked Login Button");
}
}
