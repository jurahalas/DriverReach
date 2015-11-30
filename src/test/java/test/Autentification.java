package test;

import com.driverreach.pages.HomePage;
import com.driverreach.pages.LoginPage;
import com.driverreach.utils.ConfigProperties;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Admin on 24.11.2015.
 */
public class Autentification extends Basic {

    @Test(priority = 1,groups = {"1"})
    public void signInSuccessfull(){
        LoginPage loginPage = open(ConfigProperties.getProperty("login.url"), LoginPage.class);
        HomePage homePage = loginPage.login(ConfigProperties.getProperty("login.name1"),ConfigProperties.getProperty("login.password1"));
        homePage.homeLabel();
       homePage.checkTheTable();

}

}
