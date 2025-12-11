package automation.pages;

import automation.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPageee {

    WebDriver driver;
    SeleniumUtils utils;
    By firstname =By.id("input-firstname");
    By lastname = By.id("input-lastname");
    By  email =By.id("input-email");
    By telephone= By.id("input-telephone");
    By password=By.id("input-password");
    By confirmpass=By.id("input-confirm");
    By submit=By.xpath("//input[@value='Continue']");
    public  RegisterPageee(WebDriver driver)
    {
        this.driver=driver;
        this.utils = new SeleniumUtils(driver);
    }
public void registerDetails(String Vfirstname,String vlastname,String Vemail,String vtelephone,String vpassword,String vconfirm)
{

    utils.type(driver.findElement(firstname),Vfirstname);
    utils.type(driver.findElement(lastname),vlastname);
    utils.type(driver.findElement(email),Vemail);
    utils.type(driver.findElement(telephone),vtelephone);
    utils.type(driver.findElement(password),vpassword);
    utils.type(driver.findElement(confirmpass),vconfirm);


  /*
wait.until(ExpectedConditions.visibilityOfElementLocated(firstname)).sendKeys(Vfirstname);
    wait.until(ExpectedConditions.visibilityOfElementLocated(lastname)).sendKeys(vlastname);
    wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(Vemail);
    wait.until(ExpectedConditions.visibilityOfElementLocated(telephone)).sendKeys(vtelephone);
    wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(vpassword);
    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmpass)).sendKeys(vconfirm);
    wait.until(ExpectedConditions.visibilityOfElementLocated(submit)).click();

   */
}
}
