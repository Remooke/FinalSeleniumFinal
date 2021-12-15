package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.mn.Харин;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class ScenarioSteps {

    YandexSteps yandexSteps = new YandexSteps();
    MarketSteps marketSteps = new MarketSteps();
    CatalogElectronicSteps catalogElectronicSteps = new CatalogElectronicSteps();
    CatalogTVSteps catalogTVSteps = new CatalogTVSteps();
    FilterSteps filterSteps = new FilterSteps();
    ProductSteps productSteps = new ProductSteps();
    String title;

    @When("выбирает сервис \"(.*)\"$")
    public void setYandexSteps(String menuItem) {
        yandexSteps.selectServiceMenu(menuItem);
    }

    @When("выбирает меню \"(.*)\"$")
    public void setMarketSteps(String menuItem) {
        marketSteps.selectMarket(menuItem);
    }

    @When("выбирает подменю \"(.*)\"$")
    public void chooseSubMenu(String menuItem) {
        catalogElectronicSteps.selectNavigationTree(menuItem);
    }

    @When("открывает расширенный фильтр")
    public void chooseFilterButton() {
        catalogTVSteps.clickFilterButton();
    }

    @When("выбирает цену {string},{string}")
    public void choosePriceFilter(String priceFromOrTo, String price) {
        filterSteps.setPriceFilter(priceFromOrTo, price);
    }

    @When("выбирает Производителя {string}")
    public void chooseManufacturerFilter(String manufacturer) throws InterruptedException {
        Thread.sleep(6000);
        filterSteps.setManufacturerFilter(manufacturer);
    }

    @When("применяет фильтр")
    public void filter() {
        filterSteps.clickSearchButton();
    }

    @Then("количество элементов равно \"(.*)\"$")
    public void checkElements(int i) {
        catalogTVSteps.checkCountOfElements(i);
    }

    @Когда("ищет заголовок элемента {int}")
    public void ищетЗаголовокЭлемента(int arg0) throws InterruptedException {
        catalogTVSteps.TitleSearchOfElements(arg0);
        title = catalogTVSteps.title;
    }


    @Когда("выбирает товар")
    public void выбираетТовар() throws InterruptedException {
        Thread.sleep(6000);
        catalogTVSteps.chooseProduct();
    }

    @Тогда("значение заголовка совпадает")
    public void значениеЗаголовка() {
        productSteps.checkHeader(title);
    }

    @Когда("раскрывает производителей")
    public void openView() throws InterruptedException {
      //  Thread.sleep(6000);
        filterSteps.view();
    }

    @И("выбирает производителя новый способ {string}")
    public void выбираетПроизводителяНовыйСпособ(String arg0) throws InterruptedException {
        filterSteps.setManufacturerFilter2(arg0);
    }

    @Когда("выбирает товар2")
    public void chooseProduct2() throws InterruptedException {
        Thread.sleep(6000);
        catalogTVSteps.chooseProduct1(title);
    }




   /* страница каталог электроника
    клик телевизоры
    страница каталог телевизоры
    клик все фильтры
    страница фильтров
    цена от 20000
    производитель Samsung и LG
    клик показать
    страница каталог телевизоры
    чек элементов 12
    сэйв заголовок первого элемента
    ввод поиска значения элемента
    клик поиск
    страница поиска
    клик на первй элемент
    чек заголовок  */

}
