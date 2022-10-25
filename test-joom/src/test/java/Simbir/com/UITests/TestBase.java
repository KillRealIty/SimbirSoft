package Simbir.com.UITests;

import Simbir.com.Mangers.ManagerDriver;
import io.appium.java_client.MobileCommand;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    public static void launch(){
        ManagerDriver.getDriver().execute(MobileCommand.LAUNCH_APP);
    }

    @AfterAll
    public static void quit(){
        ManagerDriver.reset();
    }
}
