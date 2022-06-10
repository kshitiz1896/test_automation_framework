package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.WatchEvent;
import java.util.Properties;

public class BaseSetup
{
    public static WebDriver driver ;
    public static FileReader fr1;
    public static FileReader fr2 ;
    public static Properties properties = new Properties() ;


@BeforeMethod
    public void setUp() throws IOException {

            fr1 = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/config.properties");
            fr2 = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/Locators.properties");
            properties.load(fr1);
            properties.load(fr2);

        if (properties.getProperty("browser").equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver() ;
            driver.get(properties.getProperty("url"));
        }
        if (properties.getProperty("browser").equalsIgnoreCase("Safari"))
        {
            WebDriverManager.safaridriver().setup();
            driver=new SafariDriver() ;
            driver.get(properties.getProperty("url"));
        }
    }


    @AfterMethod
    public void tearDown()
    {
     driver.close();
     System.out.println("Teardown Successful");
    }

}
