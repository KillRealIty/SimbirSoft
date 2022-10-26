package Simbir.com.UITests.TestSwipe;

import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
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