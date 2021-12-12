package steps;

import io.qameta.allure.Step;
import pages.YandexPage;

public class YandexSteps {

    @Step("выбран сервис {0}")
    public void selectServiceMenu(String menuItem){
        new YandexPage(BaseSteps.getDriver()).selectServiceMenu(menuItem);
        for(String winHandle : BaseSteps.getDriver().getWindowHandles()){
            BaseSteps.getDriver().switchTo().window(winHandle);
        }
    }

}
