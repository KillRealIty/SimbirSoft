package Simbir.com.Mangers;

import Simbir.com.Constatnts.Configuration;
import Simbir.com.Constatnts.GlobalData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static Simbir.com.Helpers.DeviceDataReader.getDesiredCapabilities;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static io.appium.java_client.remote.MobilePlatform.IOS;

public class ManagerDriver {

    protected static AppiumDriver driver;

    public static URL createUrl() {

        try {
            return new URL(GlobalData.BASE_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("Can not create URL: " + GlobalData.BASE_URL);
        }
    }

    private static AppiumDriver createDriver() {

        switch (Configuration.PLATFORM_NAME) {
            case ANDROID:
                return driver = new AndroidDriver(createUrl(), getDesiredCapabilities());
            case IOS:
                return driver = new IOSDriver(createUrl(), getDesiredCapabilities());
        }
        return driver;
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            try {
                driver = createDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalData.WAIT_MANAGER_DRIVER));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void reset() {
        ((AndroidDriver) driver).terminateApp("/app/joom.apk");
    }
}
