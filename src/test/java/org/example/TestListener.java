package org.example;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getName();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String fileName = methodName + "_" + dateFormat.format(date) + ".png";
        File screenshotFile = new File("screenshots/" + fileName);

        if (!screenshotFile.exists()) {
            screenshotFile.getParentFile().mkdirs();
            try {
                screenshotFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenshot = robot.createScreenCapture(screenRect);
            ImageIO.write(screenshot, "png", screenshotFile);
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }

        Reporter.log("<a href='" + screenshotFile.getAbsolutePath() + "'> <img src='" + screenshotFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
    }
}