import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JsScrolling {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");
        //Scroll till button will be visible
        WebElement btn2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timerButton")));

              scrollToElement(driver,btn2);
        //Scroll to the footer of the page
        scrollToFooter(driver);
          Thread.sleep(3000);
       //Scroll up a bit
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-500)");// Up 500 px
        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0,0)");//Top of the page
        Thread.sleep(2000);
        driver.quit();
    }
    public static void scrollToFooter(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    public static void scrollToElement(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);

    }
}
