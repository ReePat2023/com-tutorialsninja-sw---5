package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistners.CustomListners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {
    By topMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    @FindBy(linkText = "Desktops")
    WebElement desktopTab;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksLink;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsLinks;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyTab;
    By currencyList = By.xpath("//ul[@class = 'dropdown-menu']/li");


    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;

    //
    By myAccountOptions = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");


    public void selectMenu(String menu) throws InterruptedException {
        Reporter.log("select Menu  " + topMenu.toString());
        CustomListners.test.log(Status.PASS, "select Menu " + topMenu);
        Thread.sleep(1000);
        clickOnElement((WebElement) By.xpath("//nav[@id='menu']//a[normalize-space()='" + menu + "']"));
    }

    public void mouseHoverOnDesktopsLinkAndClick() {
        Reporter.log("Hovering and Clicking on desktop " + desktopTab.toString());
        mouseHoverToElementAndClick(desktopTab);
        CustomListners.test.log(Status.PASS, "Click on desktop");
    }

    public void mouseHoverOnLaptopsAndNotebooksLinkAndClick() {
        Reporter.log("mouseHover On Laptop  And Click  " + laptopsAndNotebooksLink.toString());
        CustomListners.test.log(Status.PASS, "mouseHover On Laptop And Click " + laptopsAndNotebooksLink);
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
    }

    public void mouseHoverOnComponentLinkAndClick() throws InterruptedException {
        Reporter.log("mouseHover On Component  And Click  " + componentsLinks.toString());
        CustomListners.test.log(Status.PASS, "mouseHover On Component And Click " + componentsLinks);
        Thread.sleep(1000);
        mouseHoverToElementAndClick(componentsLinks);
    }

    public void selectCurrency(String currency) throws InterruptedException {
        Reporter.log("Select Currency  " + currencyTab.toString());
        CustomListners.test.log(Status.PASS, "Select Currency " + currencyTab);
        clickOnElement(currencyTab);
        Thread.sleep(1000);
        List<WebElement> listOfElements = getListOfElements(currencyList);
        for (WebElement e : listOfElements) {
            if (e.getText().equalsIgnoreCase(currency)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnMyAccountTab() throws InterruptedException {
        Reporter.log("click On My QAccount Tab  " + myAccountTab.toString());
        CustomListners.test.log(Status.PASS, "click On My QAccount Tab " + myAccountTab);
        Thread.sleep(1000);
        clickOnElement(myAccountTab);
    }

    public void selectMyAccountOptions(String option) {

        List<WebElement> myAccountList = getListOfElements(myAccountOptions);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = getListOfElements(myAccountOptions);
        }
    }
}