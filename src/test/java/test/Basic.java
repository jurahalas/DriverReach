package test;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.driverreach.utils.ConfigProperties;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Created by Admin on 24.11.2015.
 */
public class Basic {

    public void openUrl(){
        open(ConfigProperties.getProperty("login.url"));
    }
    public WebDriver driver;



    @BeforeTest
    @Parameters({"browser"})
   /* public void Before(String browser){

        if(browser.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        }
    }*/

    public void Before(String browser) throws MalformedURLException {

        if(browser.equalsIgnoreCase("chrome")){

            System.out.println("Chrome browser");
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            capability.setBrowserName("chrome");

            capability.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL("http://192.168.43.219:4444/wd/hub"), capability);



        }


        if(browser.equalsIgnoreCase("internet explorer")){
            System.out.println("internet explorer browser");
            DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
            capability.setBrowserName("internet explorer");

            capability.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL("http://192.168.43.219:4444/wd/hub"), capability);


        }
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);

    }


    @AfterTest
    public void quitTest(){

        WebDriverRunner.closeWebDriver();
        driver.quit();
    }
}
