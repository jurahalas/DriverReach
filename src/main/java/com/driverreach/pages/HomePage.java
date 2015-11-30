package com.driverreach.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Admin on 25.11.2015.
 */
public class HomePage {

    @FindBy(how = How.XPATH, using = ".//*[@id='page-wrapper']/div[1]/nav/div/div/button")
    public SelenideElement dropdown;

    @FindBy(how = How.XPATH, using = ".//*[@id='page-wrapper']/div[1]/nav/div/div/ul/li[3]/a")
    public SelenideElement logout;

    @FindBy(how = How.XPATH, using = ".//*[@id='page-wrapper']/div[2]/div/ol/li/strong/span")
    public SelenideElement homeLabel;

    @FindBy(how = How.XPATH, using = ".//*[@id='DataTables_Table_0']/tbody/tr")
    public ElementsCollection tableList;

    @FindBy(how = How.XPATH, using = ".//*[@id='DataTables_Table_0']/tbody/tr/td")
    public SelenideElement emptyTable;

    @FindBy(how = How.XPATH, using = ".//*[@id='side-menu']/li[2]/a")
    public SelenideElement settingsButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='page-wrapper']/div[3]/div/div[2]/div/div/ul/li[1]/a/span")
    public SelenideElement applicationLabel;

    @FindBy(how = How.XPATH, using = ".//*[@id='profile-info-wrapper']/div/div/div/div[2]/div[1]/div/h2")
    public SelenideElement profileName;

    @FindBy(how = How.XPATH, using = ".//*[@id='DataTables_Table_0']/tbody/tr[5]/td")
    public SelenideElement tableElement;


    public HomePage logout() {
        dropdown.click();
        logout.click();
        return page(HomePage.class);
    }

    public void emptyElementOfTable() {
        for (SelenideElement element : $$("#DataTables_Table_0>tbody")) {
            element.shouldNotBe(Condition.empty);
        }
    }

   /* public int value(){
      int t = tableList.getSize()
        System.out.println(t);
        return t;
    }*/

    /* public  int value() {
         int t = $$(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr")).size();
         System.out.println(t);
         return t;
     }*/
  /* public  int value() {
       int t = tableList.size();
       System.out.println(t);
       return t;
   }*/
    public void random() {
        int e = tableList.size();
        System.out.println(e);
        Random rn = new Random();
        int answer = rn.nextInt(e) + 1;
        System.out.println(answer);

        String st = $(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[" + answer + "]/td[2]")).getText();
        System.out.println(st);

        //click on table row
        $(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[" + answer + "]/td[8]/div/button")).click();
        $(By.linkText("View application")).click();
        applicationLabel.shouldBe(Condition.visible);
        profileName.shouldHave(Condition.text(st));
    }

    public SettingsPage clickOnSettings() {
        settingsButton.click();
        return page(SettingsPage.class);
    }

    public void checkTheTable() {
        if (tableElement.is(hidden)) {
            logout();
        } else {
            emptyElementOfTable();
            random();
            logout();
        }


    }
    public void homeLabel(){
        homeLabel.shouldHave(text("Home"));
    }
}