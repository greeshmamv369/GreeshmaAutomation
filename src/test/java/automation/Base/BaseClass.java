package automation.Base;

import automation.pages.RegisterPage;
import automation.utils.ExtentManager;
import automation.utils.LoggerUtils;
import automation.utils.PropertyReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseClass {
    private static final Logger logger=Logger.getLogger(String.valueOf(BaseClass.class));
    public static ExtentReports extentReports;
    protected WebDriver driver;

    // >>> Add your page objects here <<<
    protected RegisterPage registerPage;


    @BeforeMethod
    public void setup() {

        String browser = PropertyReader.get("browser");
        logger.info("The browser is:"+browser);
        switch (browser.toLowerCase()) {
            case "chrome":
//                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                logger.info("The chrome browser is initialised");
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                logger.info("The firefox browser is initialised");

                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                logger.info("The edge browser is initialised");

                break;

            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                logger.info("The chrome browser is default initialised");

                break;
        }

        DriverManager.setDriver(driver);

        driver.manage().window().maximize();
        logger.info("The window maximized");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("The implicit wait is applied");

        driver.get(PropertyReader.get("url"));
        logger.info("The url launched is:"+PropertyReader.get("url"));


        // >>> Initialize page objects AFTER driver exists <<<
        logger.info("page initialised");
        extentReports= ExtentManager.getInstance();
        registerPage = new RegisterPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        if (DriverManager.getDriver() != null) {
         if(extentReports!=null)
         {
             extentReports.flush();
         }
            DriverManager.getDriver().quit();
            logger.info("Browser closed");

            DriverManager.unload();
        }
    }
}
