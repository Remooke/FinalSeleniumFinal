package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import pages.CatalogTVPage;

public class CatalogTVSteps {
    public String title;
    @Step("открываем фильтр поиска")
    public void clickFilterButton(){
        new CatalogTVPage(BaseSteps.getDriver()).clickFilterButton();
    }

    @Step("проверяем количество элементов {0}")
        public void checkCountOfElements(int expectedNumber){
        int actualNumber = new CatalogTVPage(BaseSteps.getDriver()).getCountOfElements();
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    @Step("ищем {0} элемент")
    public void TitleSearchOfElements(int i){
        title =  new CatalogTVPage(BaseSteps.getDriver()).getTitleElementsNumber(i);
        new CatalogTVPage(BaseSteps.getDriver()).TitleSearchOfElements(title);
    }

    @Step("выбираем товар")
    public void chooseProduct() {
        new CatalogTVPage(BaseSteps.getDriver()).clickElementsNumber(1);
        for(String winHandle : BaseSteps.getDriver().getWindowHandles()){
            BaseSteps.getDriver().switchTo().window(winHandle);
        }
    }




}
