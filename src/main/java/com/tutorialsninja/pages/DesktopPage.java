package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistners.CustomListners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopsText;
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    WebElement productsList;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;


    public String getDesktopsText() {
        Reporter.log("get Desktops Text  " + desktopsText.toString());
        CustomListners.test.log(Status.PASS, "get Desktops Text " + desktopsText);
        return getTextFromElement(desktopsText);
    }

    public ArrayList<String> getProductsNameList() {
        Reporter.log("get Products Name List ");
        CustomListners.test.log(Status.PASS, "get Products Name List ");
        List<WebElement> products = getListOfElements((By) productsList);
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        return originalProductsName;
    }

    public void selectProductByName(String product) {
        List<WebElement> products = getListOfElements((By) productsList);
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }

    public void selectSortByOption(String option) throws InterruptedException {
        Reporter.log("select Sort By Option  " + sortBy.toString());
        CustomListners.test.log(Status.PASS, "select Sort By Option " + sortBy);
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(sortBy, option);
    }
}
