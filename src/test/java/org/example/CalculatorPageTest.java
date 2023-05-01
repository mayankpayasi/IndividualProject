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
    }
    /*
    @Test
    public void checkRegion()throws InterruptedException{
        calculatorPage1.openGcpPage(url);
        calculatorPage1.goToCloudCalculatorPage(searchText);
        //calculatorPage1.ManageCookie();
        calculatorPage1.NumberOfInstancesField("4");
        calculatorPage1.selectSeries();
        calculatorPage1.selectMachineType();
        calculatorPage1.AddGpusCheckBox();
        calculatorPage1.selectTypeOfGpus();
        calculatorPage1.selectNumberOfGpus();
        calculatorPage1.selectLocalSsd();
        calculatorPage1.selectDataCenterLocation();
        calculatorPage1.selectCommittedUsage();
        calculatorPage1.pushAddToEstimate();
        String region=calculatorPage1.getLocation().getText();
        System.out.println(region);
        System.out.println("Region: Frankfurt");
        Assert.assertEquals(region,"Region: Frankfurt");
    }
    @Test
    public void checkSSD() throws InterruptedException{
        calculatorPage1.openGcpPage(url);
        calculatorPage1.goToCloudCalculatorPage(searchText);
        //calculatorPage1.ManageCookie();
        calculatorPage1.NumberOfInstancesField("4");
        calculatorPage1.selectSeries();
        calculatorPage1.selectMachineType();
        calculatorPage1.AddGpusCheckBox();
        calculatorPage1.selectTypeOfGpus();
        calculatorPage1.selectNumberOfGpus();
        calculatorPage1.selectLocalSsd();
        calculatorPage1.selectDataCenterLocation();
        calculatorPage1.selectCommittedUsage();
        calculatorPage1.pushAddToEstimate();
        String ssd = calculatorPage1.getSsdData().getText();
        Assert.assertEquals(ssd, "Local SSD: 2x375 GiB\n" +
                "Committed Use Discount applied");
    }
    @Test
    public void checkInstanceType()throws InterruptedException {
        calculatorPage1.openGcpPage(url);
        calculatorPage1.goToCloudCalculatorPage(searchText);
        //calculatorPage1.ManageCookie();
        calculatorPage1.NumberOfInstancesField("4");
        calculatorPage1.selectSeries();
        calculatorPage1.selectMachineType();
        calculatorPage1.AddGpusCheckBox();
        calculatorPage1.selectTypeOfGpus();
        calculatorPage1.selectNumberOfGpus();
        calculatorPage1.selectLocalSsd();
        calculatorPage1.selectDataCenterLocation();
        calculatorPage1.selectCommittedUsage();
        calculatorPage1.pushAddToEstimate();
        String instance = calculatorPage1.getInstanceType().getText();
        Assert.assertEquals(instance, "Instance type: n1-standard-8\n"+
                "Committed Use Discount applied");
    }
    @Test
    public void checkCommitment()throws InterruptedException {
        calculatorPage1.openGcpPage(url);
        calculatorPage1.goToCloudCalculatorPage(searchText);
        //calculatorPage1.ManageCookie();
        calculatorPage1.NumberOfInstancesField("4");
        calculatorPage1.selectSeries();
        calculatorPage1.selectMachineType();
        calculatorPage1.AddGpusCheckBox();
        calculatorPage1.selectTypeOfGpus();
        calculatorPage1.selectNumberOfGpus();
        calculatorPage1.selectLocalSsd();
        calculatorPage1.selectDataCenterLocation();
        calculatorPage1.selectCommittedUsage();
        calculatorPage1.pushAddToEstimate();
        String time = calculatorPage1.getCommitment().getText();
        Assert.assertEquals(time, "Commitment term: 1 Year");
    }
    @Test
    public void checkCost()throws InterruptedException {
        calculatorPage1.openGcpPage(url);
        calculatorPage1.goToCloudCalculatorPage(searchText);
        //calculatorPage1.ManageCookie();
        calculatorPage1.NumberOfInstancesField("4");
        calculatorPage1.selectSeries();
        calculatorPage1.selectMachineType();
        calculatorPage1.AddGpusCheckBox();
        calculatorPage1.selectTypeOfGpus();
        calculatorPage1.selectNumberOfGpus();
        calculatorPage1.selectLocalSsd();
        calculatorPage1.selectDataCenterLocation();
        calculatorPage1.selectCommittedUsage();
        calculatorPage1.pushAddToEstimate();
        String cost = calculatorPage1.getCost().getText();
        Assert.assertEquals(cost, "Total Estimated Cost: USD 1,081.20 per 1 month");
    }

     */

}