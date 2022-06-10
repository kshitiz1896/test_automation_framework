package Testcase;

import base.BaseSetup;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ReadDataFromExcel;

import static base.BaseSetup.driver;

public class Login extends BaseSetup
{
    @Test(dataProviderClass = ReadDataFromExcel.class , dataProvider = "ExcelData")
    public static void LoginTest(String username , String password) throws InterruptedException {
        System.getProperty("user.dir");
        driver.manage().window().maximize();
        driver.findElement(By.xpath(properties.getProperty("signup_link"))).click();
        driver.findElement(By.id(properties.getProperty("Login_id"))).sendKeys(username);
        driver.findElement(By.id(properties.getProperty("next_button"))).click();
        driver.findElement(By.name(properties.getProperty("Password"))).sendKeys(password);
        Thread.sleep(5000);
        driver.findElement(By.id(properties.getProperty("Next_button_2"))).click();
        Thread.sleep(5000);
    }

//    @DataProvider(name="dataProvider")
//    public Object[][] testData()
//    {
//        return new Object[][]
//                {
//                        {"kshitiztyagi319@gmail.com","pass123"},
//                        {"kshitiztyagi319@gmail.com","pass12345"},
//                        {"kshitiztyagi18960@gmail.com","Behappy1896$"}
//                };
//    }
}
