package Simbir.com.Pages.SearchMenu;

import Simbir.com.Constatnts.GlobalData;
import Simbir.com.Mangers.ManagerDriver;
import Simbir.com.Pages.BasePage;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchPage extends BasePage {

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private WebElement search;

    @FindBy(id = "com.joom:id/input")
    private WebElement searchField;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
    private WebElement sortButton;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]")
    private WebElement ascendingPrice;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView")
    private WebElement firstPrice;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView")
    private WebElement secondPrice;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView")
    private WebElement thirdPrice;

    @Step("Нажать поле поиска, откроется поисковая страница")
    public void clickSearch() {
        search.click();
    }

    @Step("Написать запрос и отправить")
    public void sendKeys() {

        KeyEvent keyEvent = new KeyEvent();
        AndroidDriver androidDriver = (AndroidDriver) ManagerDriver.getDriver();
        searchField.sendKeys(GlobalData.SEARCH);
        androidDriver.pressKey(keyEvent.withKey(AndroidKey.ENTER));
        androidDriver.pressKey(keyEvent.withKey(AndroidKey.ENTER));
    }

    @Step("Нажать кнопку сортировки и выбрать цену по возрастанию")
    public void sortButton() {

        sortButton.click();
        ascendingPrice.click();
    }

    @Step("Сравнить цены")
    public void comparePrice() {

        String firstPriceText = firstPrice.getText();
        String secondPriceText = secondPrice.getText();
        String thirdPriceText = thirdPrice.getText();

        int first = Integer.parseInt(firstPriceText.replaceAll("\\D", ""));
        int second = Integer.parseInt(secondPriceText.replaceAll("\\D", ""));
        int third = Integer.parseInt(thirdPriceText.replaceAll("\\D", ""));

        Assert.isTrue(first <= second && second <= third, "Сортировка не правильная");
    }
}
