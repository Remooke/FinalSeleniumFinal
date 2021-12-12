package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class YandexPage {

    @FindBy(xpath = "//div[contains(@class, 'services-new__content')]")
    WebElement serviceMenu;

    public YandexPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    public void selectServiceMenu(String menuItem){
        serviceMenu.findElement(By.xpath(".//div[contains(text(), '"+menuItem+"')]")).click();
    }




}
