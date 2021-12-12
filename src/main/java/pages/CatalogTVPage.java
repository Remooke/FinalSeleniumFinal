package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CatalogTVPage {
    @FindBy(xpath = "//span[text()='Все фильтры']")
    WebElement filterButton;

    @FindBy(xpath = "//a[contains(@class, '_2f75n _24Q6d cia-cs')]")
    WebElement element;

    @FindBy(id = "header-search")
    WebElement headerSearch;

    @FindBy(xpath = "//button[contains(@data-r, 'search-button')]")
    WebElement SearchButton;




    public CatalogTVPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, (10));
        wait.until(ExpectedConditions.elementToBeClickable(filterButton));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickFilterButton(){
        filterButton.click();
    }

    public int getCountOfElements(){
        return filterButton.findElements(By.xpath("//a[contains(@class, '_2f75n _24Q6d cia-cs')]")).size();
    }

    public void clickElementsNumber(int i) {
       element.findElements(By.xpath("//a[contains(@class, '_2f75n _24Q6d cia-cs')]")).get(i-1).click();
    }

    public String getTitleElementsNumber(int i){
        //return element.findElement(By.xpath(".//span")).getText();
       List<WebElement> elementName = element.findElements(By.xpath("./span"));
       String s = elementName.get(i-1).getText();
       return s;
    }


    //ввод в поисковую строку заголовок n элемента
    public void TitleSearchOfElements(String title){
        headerSearch.sendKeys(title);
        SearchButton.click();
    }


    //сравнить заголовок n элемента с заголовками после поиска и кликнуть, если совпадает
   /* public void goToElement(String title) {

        List<WebElement> elementName = element.findElements(By.xpath("./span"));
        for (int i = 0; i < elementName.size(); i++){
            String s = elementName.get(i).getText();
            System.out.println(s);
            System.out.println(i);
            if (s.equals(title)){
                clickElementsNumber(i);
                break;
            }
            else System.out.println("Товар не найден на странице");
        }
    }*/





}
