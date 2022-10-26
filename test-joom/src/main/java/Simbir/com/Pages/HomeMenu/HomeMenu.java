package Simbir.com.Pages.HomeMenu;

import Simbir.com.Constatnts.GlobalData;
import Simbir.com.Mangers.ManagerDriver;
import Simbir.com.Pages.BasePage;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import dev.failsafe.internal.util.Assert;

import java.time.Duration;

public class HomeMenu extends BasePage {

    @FindBy(id = "com.joom:id/close_button")
    private WebElement banner1;

    @FindBy(id = "com.joom:id/hint")
    private WebElement search;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Best\"]/android.view.ViewGroup/android.widget.TextView")
    private WebElement best;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Promotions\"]/android.view.ViewGroup/android.widget.TextView")
    private WebElement promotions;

    @Step("Закрываем первое объявление при входе в приложение")
    public void clickExitPopUp() {
        banner1.click();
    }

    @Step("Закрываем второе объявление при входе в приложение")
    public void clickExitPopUp2() {
        banner1.click();
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

        Assert.isTrue(best.isSelected(), "Выбрано поле Best");
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
        Assert.isTrue(promotions.isSelected(), "Выбрано поле Promotions");
    }
}
