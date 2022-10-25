package Simbir.com.UITests.TestSwipe;

import Simbir.com.Mangers.ManagerDriver;
import Simbir.com.UITests.TestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.qameta.allure.Story;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Свайп")
public class SwipeTest extends SwipeBaseTest {

    @Test
    @Story("Свайп элементов приложения в любую сторону")
    public void swipeElementsApp(){
        homeMenu.clickExitPopUp();
        homeMenu.clickExitPopUp2();
        homeMenu.leftSwipe();
        homeMenu.rightSwipe();
        homeMenu.rightSwipe();
    }
}