package Simbir.com.Pages.HomeMenu;

import Simbir.com.Constatnts.Configuration;
import Simbir.com.Constatnts.GlobalData;
import Simbir.com.Mangers.ManagerDriver;
import Simbir.com.Pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.objenesis.instantiator.sun.MagicInstantiator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeMenu extends BasePage {

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView")
    private WebElement banner2;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Close\"]")
    private WebElement banner1;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private WebElement search;

    @Step("Закрываем первое объявление при входе в приложение")
    public void clickExitPopUp() {
        KeyEvent keyEvent = new KeyEvent();
        WebDriverWait wait = new WebDriverWait(ManagerDriver.getDriver(), Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(banner1));
        AndroidDriver androidDriver = (AndroidDriver) ManagerDriver.getDriver();
        androidDriver.pressKey(keyEvent.withKey(AndroidKey.BACK));
    }

    @Step("Закрываем второе объявление при входе в приложение")
    public void clickExitPopUp2() {
        KeyEvent keyEvent = new KeyEvent();
        AndroidDriver androidDriver = (AndroidDriver) ManagerDriver.getDriver();
        androidDriver.pressKey(keyEvent.withKey(AndroidKey.BACK));
    }

    @Step("Закрываем второе объявление при входе в приложение")
    public void clickSearch() {
        search.click();
    }

    @Step("Свайп вправо")
    public void rightSwipe() {

        int edgeBorder = 10;
        AndroidDriver androidDriver = (AndroidDriver) ManagerDriver.getDriver();
        Dimension dims = androidDriver.manage().window().getSize();
        PointOption pointOptionStart = PointOption.point(dims.width/2, dims.height/2);
        TouchAction action = new TouchAction((PerformsTouchActions) ManagerDriver.getDriver());
        action.press(pointOptionStart)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(GlobalData.SWIPE_TIME)))
                .moveTo(PointOption.point(dims.width - edgeBorder, dims.height /2))
                .release()
                .perform();
    }

    @Step("Свайп влево")
    public void leftSwipe() {

        int edgeBorder = 10;
        AndroidDriver androidDriver = (AndroidDriver) ManagerDriver.getDriver();
        Dimension dims = androidDriver.manage().window().getSize();
        PointOption pointOptionStart = PointOption.point(dims.width/2, dims.height/2);
        TouchAction action = new TouchAction((PerformsTouchActions) ManagerDriver.getDriver());
        action.press(pointOptionStart)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(GlobalData.SWIPE_TIME)))
                .moveTo(PointOption.point(edgeBorder, dims.height / 2))
                .release()
                .perform();
    }
}
