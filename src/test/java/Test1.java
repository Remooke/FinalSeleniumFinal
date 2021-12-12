import com.google.gson.internal.$Gson$Preconditions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import steps.BaseSteps;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Test1 {
    protected static WebDriver driver;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();


    @BeforeClass
    public static void setUp() throws Exception {
        if ("firefox".equals(properties.getProperty("browser"))) {
            System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
            driver = new ChromeDriver();
        }
        baseUrl = properties.getProperty("app.url");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
       // driver.get(baseUrl);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        //driver.quit();
    }

    @Test
    public void testTest() throws InterruptedException {
        driver.get("https://market.yandex.ru/catalog--naushniki-i-bluetooth-garnitury/26992150/filters?hid=90555&onstock=0&local-offers-first=0");
        FilterPage filterPage = new FilterPage(driver);
        //filterPage.setManufacturerFilter("LG");
        Wait<WebDriver> wait = new WebDriverWait(driver, (30));
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(), 'Показать ещё')]/parent::button")))).click();
       // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[contains(@value, 'Beats')]/parent::label")))).click();
Thread.sleep(6000);
        driver.findElement(By.xpath("//div[contains(@class,'_3918R _2GwyK')]//input[contains(@class,'_34OG2')]")).
                sendKeys("Beats");

        //driver.findElement(By.xpath("//span[contains(text(), 'Показать ещё')]/parent::button")).click();
        driver.findElement(By.xpath("//input[contains(@value, 'Beats')]/parent::label")).click();
       // driver.findElement(By.xpath("//div[contains(@data-filter-id, '7893318')]//input[contains(@value, 'LG')]/parent::label"));
    }


}
