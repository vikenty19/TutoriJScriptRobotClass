import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsCapturingTextOnThePage {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        // return ALL text on the page
        // JavascriptExecutor js = (JavascriptExecutor)driver;
      //  System.out.println(js.executeScript("return document.documentElement.innerText").toString());

        //return text of the single element
        WebElement shoppingCart = driver.findElement(By.cssSelector("[title = 'Shopping Cart']"));

        System.out.println(textOfElement(driver,shoppingCart));
        driver.quit();
    }
    public static String textOfElement(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return js.executeScript("return arguments[0].innerText;",element).toString();
    }
}
