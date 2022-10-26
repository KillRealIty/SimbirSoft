package Simbir.com.Helpers;

import Simbir.com.Constatnts.Configuration;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DeviceDataReader {

    public static DesiredCapabilities getDesiredCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        Properties properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String deviceName = properties.getProperty("deviceName");
        String platformName = Configuration.PLATFORM_NAME;
        String partialAppPath = getProperty(MobileCapabilityType.APP);
        String fullAppPath = System.getProperty("user.dir") + partialAppPath;

        capabilities.setCapability(MobileCapabilityType.APP, fullAppPath);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);

        return capabilities;
    }

    public static String getProperty(String propertyName) {

        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(Configuration.PATH_PROPERTIES)) {
            properties.load(fis);
            return properties.getProperty(propertyName);
        } catch (IOException e) {
            throw new UnsupportedOperationException("Error reading property: " + propertyName);
        }
    }
}
