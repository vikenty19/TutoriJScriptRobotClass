import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JSCalendarHandlingAndRefresh {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(By.id("datepicker")));
        javaScriptEnterDate(driver,dateField,"11/25/2023");
        //refresh page example
        pageRefresh(driver);
        // Lets create alert
       alertMessage(driver,"11/25/2023");
       Thread.sleep(2000);
       driver.switchTo().alert().accept();
    }
    public static void pageRefresh(WebDriver driver){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("history.go(0)");
    }
public static void alertMessage(WebDriver driver,String text){
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("alert('you entered the date  "+text+"')");
}
    public static void javaScriptEnterDate(WebDriver driver,WebElement element,String text){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+text+"'",element);
    }
}
