package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    protected void setUp(String url, driver){
        try {
            WebDriver driver = new ChromeDriver();

            WebDriverWait wait = new WebDriverWait(driver,10);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
            driver.get("www.yapo.cl");

            driver.manage().window().maximize();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div[1]")));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    protected WebDriver getDriver(){
        return driver;
    }
}
