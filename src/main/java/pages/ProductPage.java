package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;
import steps.CatalogTVSteps;

public class ProductPage {
    @FindBy(xpath = "//h1")
    WebElement header;

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String getHeader(){
        return header.getText();
    }

    public void checkHeader(){
        String expectedTitle = new CatalogTVPage(BaseSteps.getDriver()).getTitleElementsNumber(1);

        Assert.assertEquals(expectedTitle,getHeader());
    }

}
