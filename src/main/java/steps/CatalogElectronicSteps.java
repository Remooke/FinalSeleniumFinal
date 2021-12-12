package steps;

import io.qameta.allure.Step;
import pages.CatalogElectronicPage;

public class CatalogElectronicSteps {

    @Step("выбран выбран пункт: {0}")
    public void selectNavigationTree(String menuItem){
        new CatalogElectronicPage(BaseSteps.getDriver()).selectNavigationTree(menuItem);
    }
}
