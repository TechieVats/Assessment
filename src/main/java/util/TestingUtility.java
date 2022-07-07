package util;

import base.BaseDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestingUtility extends BaseDriver {
    public static long PAGE_LOAD_TIMEOUT = 200;
    public static long IMPLICIT_WAIT = 10;
    public static long WEB_DRIVER_WAIT = 100;

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "//logs//screenshots//" + System.currentTimeMillis() + ".png"));
    }

    public static void wait(int time) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

}