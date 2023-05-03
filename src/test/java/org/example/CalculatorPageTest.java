package org.example;
import java.lang.*;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorPageTest extends baseTest{


    @Test
    public void checkInformationInVmClassString() throws InterruptedException {
        calculatorPage1.openGcpPage(url);
        calculatorPage1.goToCloudCalculatorPage(searchText);
        //calculatorPage1.ManageCookie();
        calculatorPage1.NumberOfInstancesField("4");
        calculatorPage1.selectSeries();
        calculatorPage1.selectMachineType();
        calculatorPage1.AddGpusCheckBox();
        Thread.sleep(1000);
        calculatorPage1.selectTypeOfGpus();
        calculatorPage1.selectNumberOfGpus();
        Thread.sleep(1000);
        calculatorPage1.selectLocalSsd();
        calculatorPage1.selectDataCenterLocation();
        Thread.sleep(1000);
        calculatorPage1.selectCommittedUsage();
        calculatorPage1.pushAddToEstimate();
        String vmClass=calculatorPage1.getVmClassData().getText();
        Assert.assertEquals(vmClass,"Provisioning model: Regular");
        
        String instance = calculatorPage1.getInstanceType().getText();
        System.out.println(instance);
        Assert.assertEquals(instance, "Instance type: n1-standard-8\n"+
                "Committed Use Discount applied");


        String region=calculatorPage1.getLocation().getText();
        System.out.println(region);
        //System.out.println("Region: Frankfurt");
        Assert.assertEquals(region,"Region: Frankfurt");

        String ssd = calculatorPage1.getSsdData().getText();
        System.out.println(ssd);
        Assert.assertEquals(ssd, "Local SSD: 2x375 GiB\n" + "Committed Use Discount applied");

        String time = calculatorPage1.getCommitment().getText();
        System.out.println(time);
        Assert.assertEquals(time, "Commitment term: 1 Year");

        String cost = calculatorPage1.getCost().getText();
        System.out.println(cost);
        Assert.assertEquals(cost, "Total Estimated Cost: USD 1,081.20 per 1 month");
    }
}
