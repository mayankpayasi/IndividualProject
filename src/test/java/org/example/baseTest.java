package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class baseTest {
    WebDriver driver;
    CalculatorPage calculatorPage1;
    PasteBinPage PasteBinPage1;
    String url;
    String searchText;

    @BeforeMethod

    public void setDriver() throws IOException {

        PropertiesOperations p = new PropertiesOperations();
        String browser = p.getPropertyFileData("browser");
        url=p.getPropertyFileData("url");
        searchText=p.getPropertyFileData("searchtext");

        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if(browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        calculatorPage1 = new CalculatorPage(driver);
        PasteBinPage1 = new PasteBinPage(driver);

    }


    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }


}