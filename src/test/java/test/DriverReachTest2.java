package test;

import com.driverreach.pages.HomePage;
import com.driverreach.pages.LoginPage;
import com.driverreach.pages.SettingsPage;
import com.driverreach.utils.ConfigProperties;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import test.Basic;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

/**
 * Created by Admin on 26.11.2015.
 */
public class DriverReachTest2 extends Basic {

    @Test(priority = 1)
    public void test2() throws InterruptedException //throws MalformedURLException
    {
       // setWebDriver(new RemoteWebDriver(new URL("http://192.168.2.60:4444/wd/hub"), DesiredCapabilities.firefox()));

        LoginPage loginPage = open(ConfigProperties.getProperty("login.url"), LoginPage.class);
        HomePage homePage = loginPage.login(ConfigProperties.getProperty("login.name2"), ConfigProperties.getProperty("login.password2"));
        homePage.homeLabel.shouldHave(text("Home"));
        SettingsPage settingsPage = homePage.clickOnSettings();
        settingsPage.settingsLabel.shouldHave(text("Settings"));
        settingsPage.billingTab.click();
        settingsPage.creditCard.shouldHave(text("Credit Card"));
        settingsPage.creditCard("TestCardName","4242424242424242","5","2017", "123");
        homePage.logout();

        loginPage = open(ConfigProperties.getProperty("login.url"), LoginPage.class);
        homePage = loginPage.login(ConfigProperties.getProperty("login.name2"), ConfigProperties.getProperty("login.password2"));
        homePage.homeLabel.shouldHave(text("Home"));
        settingsPage = homePage.clickOnSettings();
        settingsPage.settingsLabel.shouldHave(text("Settings"));
        settingsPage.billingTab.click();
        settingsPage.checkUserName();
        homePage.logout();
        loginPage.emailField.shouldBe(visible);

    }
}
