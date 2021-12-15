package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class FilterPage {

    @FindBy(xpath = "//div[contains(@class, '_307sS _2k6P8')]")
    WebElement priceFilter;

    @FindBy(xpath = "//div[contains(@data-filter-id, '7893318')]")
    WebElement manufacturerFilter;

    @FindBy(xpath = "//a[contains(@class, '_2qvOO _3qN-v _1Rc6L')]")
    WebElement searchButton;

    @FindBy(xpath = "//span[contains(text(), 'Показать ещё')]/parent::button")
    WebElement allManufacturerView;

    @FindBy(xpath = "//div[contains(@class,'_3918R _2GwyK')]//input[contains(@class,'_34OG2')]")
    WebElement manufacturerEnter;

    public FilterPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        Wait<WebDriver> wait = new WebDriverWait(driver, (30));
        wait.until(ExpectedConditions.elementToBeClickable(allManufacturerView));
        wait.until(ExpectedConditions.elementToBeClickable(manufacturerFilter));
        wait.until(ExpectedConditions.visibilityOf(manufacturerEnter));
    }

    public void setPriceFilter(String priceFromOrTo, String valuePrice){
        priceFilter.findElement(By.xpath(".//div[contains(@data-prefix, '"+priceFromOrTo+"')]/input[contains(@class, '_2xtC2')]")).sendKeys(valuePrice);
    }

    public void setManufacturerFilter(String manufacturer){
        manufacturerFilter.findElement(By.xpath(".//input[contains(@value, '"+manufacturer+"')]/parent::label")).click();
    }


    public void viewManufacturer(){
        allManufacturerView.click();
    }
    public void clickSearchButton(){
        searchButton.click();
    }

    //новый способ ввода производителя
    public void manufacturerEnterNew(String manufacturer) throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) BaseSteps.getDriver();
        jse.executeScript("scroll(242, 694)");
        //allManufacturerView.click();
        manufacturerEnter.clear();
        manufacturerEnter.sendKeys(manufacturer);
        manufacturerEnter.sendKeys(Keys.TAB);
        Thread.sleep(3000);
        manufacturerFilter.findElement(By.xpath(".//input[contains(@value, '"+manufacturer+"')]/parent::label")).click();
    }

}
