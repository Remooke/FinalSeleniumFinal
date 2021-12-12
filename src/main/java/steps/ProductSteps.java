package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import pages.ProductPage;

public class ProductSteps {
    @Step("проверяем заголовок: {0}")
    public void checkHeader(String title){
        String actualHeader = new ProductPage(BaseSteps.getDriver()).getHeader();
        //String expectedTitle = new CatalogTVPage(BaseSteps.getDriver()).getTitleElementsNumber(0);
        Assert.assertEquals(title,actualHeader);
    }
}
