package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;
    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    WebElement productsPrices;
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    WebElement productsList;
    @CacheLookup
    @FindBy(xpath = "input-sort")
    WebElement sortBy;

    public String getLaptopsAndNotebooksText() {
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public ArrayList<Double> getProductsPriceList() {
        List<WebElement> products = getListOfElements((By) productsPrices);
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalProductsPrice;
    }

    public void selectSortByOption(String option) {
        selectByVisibleTextFromDropDown(sortBy, option);
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
}
