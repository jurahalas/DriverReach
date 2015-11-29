package com.driverreach.pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.driverreach.utils.ConfigProperties;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.qatools.allure.annotations.Step;

//import static com.codeborne.selenide.Condition.empty;
//import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


/**
 * Created by Admin on 24.11.2015.
 */
public class LoginPage {

    @FindBy(how = How.ID, using = "user_forms_login_form_email")
    public SelenideElement emailField;

    @FindBy(how = How.ID, using = "user_forms_login_form_password")
    public SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//*[@id='new_user_forms_login_form']/div[3]/input")
    public SelenideElement loginButton;


    public HomePage login( String username, String password) {
        //open(siteUrl);
        emailField.shouldBe(Condition.visible).setValue(username);
        passwordField.shouldBe(Condition.visible).setValue(password);
        loginButton.shouldBe(Condition.visible).click();
        return page(HomePage.class);
        }
}
