package steps;

import io.qameta.allure.Step;
import pages.FilterPage;

public class FilterSteps {

    @Step("выбираем ценовой диапазон: {0} {1}")
    public void setPriceFilter(String priceFromOrTo, String valuePrice){
        new FilterPage(BaseSteps.getDriver()).setPriceFilter(priceFromOrTo,valuePrice);
    }

    @Step("выбираем производителя: {0}")
    public void setManufacturerFilter(String manufacturer){
        new FilterPage(BaseSteps.getDriver()).setManufacturerFilter(manufacturer);
    }

    @Step("показывает всех производителей")
    public void view(){
        new FilterPage(BaseSteps.getDriver()).viewManufacturer();
    }

    @Step("применяем фильтр")
    public void clickSearchButton(){
        new FilterPage(BaseSteps.getDriver()).clickSearchButton();
    }

    @Step("выбираем производителя по новому")
    public void setManufacturerFilter2(String manufacturer) throws InterruptedException {
        new FilterPage(BaseSteps.getDriver()).manufacturerEnterNew(manufacturer);
    }
}
