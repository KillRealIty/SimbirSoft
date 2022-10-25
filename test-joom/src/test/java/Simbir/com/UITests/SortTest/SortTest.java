package Simbir.com.UITests.SortTest;

import Simbir.com.Pages.SearchMenu.SearchPage;
import io.qameta.allure.Story;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Сортировка")
public class SortTest extends BaseSortTest {

    @Test
    @Story("Проверка сортировки в поисковой выдаче")
    public void searchSortPageCheck() {

        homeMenu.clickExitPopUp();
        homeMenu.clickExitPopUp2();
        homeMenu.clickSearch();
        searchPage.clickSearch();
        searchPage.sendKeys();
        searchPage.sortButton();
        searchPage.comparePrice();
    }
}
