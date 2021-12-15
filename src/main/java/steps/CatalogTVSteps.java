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
    public void TitleSearchOfElements(int i) throws InterruptedException {
        title =  new CatalogTVPage(BaseSteps.getDriver()).getTitleElementsNumber(i);
        new CatalogTVPage(BaseSteps.getDriver()).TitleSearchOfElements(title);
    }

    @Step("выбираем товар")
    public void chooseProduct() throws InterruptedException {
        new CatalogTVPage(BaseSteps.getDriver()).clickElementsNumber(1);
        for(String winHandle : BaseSteps.getDriver().getWindowHandles()){
            BaseSteps.getDriver().switchTo().window(winHandle);
        }
    }

    @Step("ищем по заголовку элемент и переходим на найденный товар {string}")
    public void chooseProduct1(String title) throws InterruptedException {
        new CatalogTVPage(BaseSteps.getDriver()).goToElement(title);
        for(String winHandle : BaseSteps.getDriver().getWindowHandles()){
            BaseSteps.getDriver().switchTo().window(winHandle);
        }
    }





}
