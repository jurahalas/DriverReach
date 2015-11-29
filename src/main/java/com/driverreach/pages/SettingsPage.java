package com.driverreach.pages;

import com.thoughtworks.selenium.condition.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.assertNoJavascriptErrors;

/**
 * Created by Admin on 26.11.2015.
 */
public class SettingsPage extends HomePage{

    @FindBy(how = How.XPATH, using = ".//*[@id='page-wrapper']/div[2]/div/ol/li/strong")
    public SelenideElement settingsLabel;

    @FindBy(how = How.XPATH, using = ".//*[@id='page-wrapper']/div[3]/div/div/div/ul/li[4]/a")
    public SelenideElement billingTab;

    @FindBy(how = How.XPATH, using = ".//*[@id='page-wrapper']/div[3]/div/div/div/div/div/div/h2")
    public SelenideElement creditCard;

    @FindBy(how = How.XPATH, using = ".//*[@id='page-wrapper']/div[3]/div/div/div/div/div/div/div/a")
    public SelenideElement changeCreditCardButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='new_subscription']/div[5]/input")
    public SelenideElement saveChangeCreditCardButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='credit-cards-table']/thead/tr/th[2]")
    public SelenideElement error;

    @FindBy(how = How.XPATH, using = ".//*[@id='page-wrapper']/div[3]/div/div/div/div/div/div/h3")
    public SelenideElement noCreditCards;

    @FindBy(how = How.ID, using = "dr-modal")
    public SelenideElement window;

    @FindBy(how = How.XPATH, using = ".//*[@id='credit-cards-table']/tbody/tr/td[1]")
    public SelenideElement nameTable;


    public String nameCard(){
        String st = $(By.xpath(".//*[@id='credit-cards-table']/tbody/tr/td[1]")).getText();
        System.out.println(st);
        return st;
    }
    public String expirateionDataCard(){
        String str = $(By.xpath(".//*[@id='credit-cards-table']/tbody/tr/td[4]")).getText();
        System.out.println(str);
        return str;
    }

    public  void creditCard(String name,String number, String monthData, String year, String cvv ) throws InterruptedException {

        if (noCreditCards.isDisplayed()) {
            System.out.println(noCreditCards.getText());
            changeCreditCardButton.click();
            saveChangeCreditCardButton.shouldBe(visible);
            $(By.id("credit_card_name")).setValue(name);
            $(By.id("number")).setValue(number);
            $(By.xpath(".//*[@id='card_month_chosen']/a/div/b")).click();
            $(By.xpath(".//*[@id='card_month_chosen']/div/div/input")).setValue(monthData).pressEnter();
            $(By.xpath(".//*[@id='card_year_chosen']/a/div/b")).click();
            $(By.xpath(".//*[@id='card_year_chosen']/div/div/input")).setValue(year).pressEnter();
            $(By.id("cvv")).setValue(cvv);
            saveChangeCreditCardButton.click();
            noCreditCards.is(hidden);
            window.waitUntil(disappear,10000);
        }

            String a = $(By.xpath(".//*[@id='credit-cards-table']/thead/tr/th[2]")).getText();
            System.out.println(a);

           if ($(By.xpath(".//*[@id='credit-cards-table']/thead/tr/th[4]")).isDisplayed())
           {changeCreditCardButton.click();
               saveChangeCreditCardButton.shouldBe(com.codeborne.selenide.Condition.visible);
               $(By.id("credit_card_name")).setValue(name);
               $(By.id("number")).setValue(number);
               $(By.xpath(".//*[@id='card_month_chosen']/a/div/b")).click();
               $(By.xpath(".//*[@id='card_month_chosen']/div/div/input")).setValue(monthData).pressEnter();
               $(By.xpath(".//*[@id='card_year_chosen']/a/div/b")).click();
               $(By.xpath(".//*[@id='card_year_chosen']/div/div/input")).setValue(year).pressEnter();
               $(By.id("cvv")).setValue(cvv);
               saveChangeCreditCardButton.click();
               System.out.println("Card value changed");
               window.waitUntil(disappear,10000);
           }

                else if ($(By.xpath(".//*[@id='credit-cards-table']/thead/tr/th[4]")).is(hidden))
        {
               System.out.println("An error occurred while processing your card. Try again in a little bit.");


            }
        }

    public void checkUserName(){
        System.out.println(nameTable.getText());
        nameTable.shouldBe(nameCard());
        window.waitUntil(disappear,10000);
    }
}


