import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //Alert
    //   jse.executeScript("alert('Vik Plakhov')");
        //Prompt
   //     jse.executeScript("prompt('what is your name?')");
        //confirmation
    //    jse.executeScript("confirm('Do you want to proceed?')");
        // click

      // jse.executeScript("document.getElementById('alert1').click()");
        //another way
       WebElement alert = driver.findElement(By.id("alert1"));
       javaScriptClick(driver,alert);
        Thread.sleep(3000);
      //  jse.executeScript("alert('Vik Plakhov')");
       // Thread.sleep(3000);
       driver.switchTo().alert().accept();// to close alert

     /*  jse.executeScript("document.getElementById('ta1').value = 'Vikenty Plakhov'");
       jse.executeScript("document.getElementById('pah').style.color='blue'");
        jse.executeScript("document.getElementById('pah').style.background='red'");*/

    }
    public static void javaScriptClick(WebDriver driver,WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("arguments[0].click()",element);
    }
}
