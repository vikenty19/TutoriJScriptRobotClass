import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class JsTakeScreenShotsAndBorder {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        WebElement cartButton = driver.findElement(By.cssSelector("#cart>button"));

        highlightTheBorderAndTakeScreenShot(driver,cartButton);
        //Get title of the page or url
        String title=pageTitle(driver);
        String urlOfPage = pageUrl(driver);
        System.out.println(title+"  "+ urlOfPage);
        //Enter text in the field
        WebElement btn = driver.findElement((By.name("search")));
        enterText(driver,btn,"HP");
     //   driver.quit();


    }
    public static void enterText(WebDriver driver,WebElement element,String text){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+text+"'",element);
    }
    public static String pageTitle(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
      String title =   js.executeScript("return document.title").toString();
        return title;
    }
    public static String pageUrl(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url =   js.executeScript("return document.URL").toString();
        return url;
    }
    public static void highlightTheBorderAndTakeScreenShot(WebDriver driver,WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.background = ' red'",element);
        js.executeScript("arguments[0].style.border = '5px solid green'",element);
        File srcfile =( (TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(srcfile,new File("./Screenshots/highlightedElement.png"));//Screenshot folder must've been created preliminary
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        js.executeScript("arguments[0].style.border = ''",element);//remove the border

    }
}
