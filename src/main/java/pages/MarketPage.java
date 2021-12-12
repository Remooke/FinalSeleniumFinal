package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MarketPage {
    @FindBy(xpath = "//div[contains(@data-zone-name, 'menu')]")
    WebElement marketMenu;

    public MarketPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void selectMarketPage(String menuItem){
        marketMenu.findElement(By.xpath(".//span[contains(text(), '"+menuItem+"')]")).click();

    }


}
