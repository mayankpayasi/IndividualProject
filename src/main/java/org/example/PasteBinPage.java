package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofMillis;

public class PasteBinPage {
    WebDriver driver;

    PasteBinPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="postform-text")
    WebElement newPaste;

    @FindBy(id = "select2-postform-expiration-container")
    WebElement elem;

    @FindBy(xpath = "//span[@class= 'select2-results']/ul/li[3]")
    WebElement select_result;

    @FindBy(xpath = "//input[@id='postform-name']")
    WebElement title;

    @FindBy(id = "postform-name")
    WebElement title1;

    @FindBy(xpath = "//button[text() = 'Create New Paste']")
    WebElement CreateNewPaste;

    public void openBinPage(){
        driver.get("https://pastebin.com/");
    }

    public void createBin() throws InterruptedException {

        newPaste.sendKeys("Hello from WebDriver");
        Thread.sleep(5000);
    }
    public void code() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,360)", "");


        Thread.sleep(2000);
        System.out.println(new WebDriverWait(driver, ofMillis(5000)).until(ExpectedConditions.elementToBeClickable(elem)).isDisplayed());
        new WebDriverWait(driver, ofMillis(5000)).until(ExpectedConditions.elementToBeClickable(elem)).click();
        select_result.click();
        Thread.sleep(3000);

        JavascriptExecutor jp = (JavascriptExecutor) driver;
        jp.executeScript("window.scrollBy(0,560)", "");

        title.click();
        title1.sendKeys("helloweb");}

    public void setCreateNewPaste() throws InterruptedException {
        JavascriptExecutor jt = (JavascriptExecutor) driver;
        jt.executeScript("window.scrollBy(0,590)", "");

        CreateNewPaste.click();
        Thread.sleep(5000);
    }
}