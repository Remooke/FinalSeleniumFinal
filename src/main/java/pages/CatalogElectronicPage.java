package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogElectronicPage {

    @FindBy(xpath = "//div[contains(@data-apiary-widget-name, 'NavigationTree')]")
    WebElement navigationTree;

    public CatalogElectronicPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, (10));
        wait.until(ExpectedConditions.visibilityOf(navigationTree));
    }

    public void selectNavigationTree(String menuItem){
        navigationTree.findElement(By.xpath(".//a[text()='"+menuItem+"']")).click();
    }
}
