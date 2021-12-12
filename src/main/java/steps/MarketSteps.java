package steps;

import io.qameta.allure.Step;
import pages.MarketPage;
import pages.YandexPage;

public class MarketSteps {
    @Step("выбран выбран пункт: {0}")
    public void selectMarket(String menuItem){
        new MarketPage(BaseSteps.getDriver()).selectMarketPage(menuItem);
    }
}
