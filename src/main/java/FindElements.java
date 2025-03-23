import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {
    public static String url = "https://omayo.blogspot.com";
    static String KoelUrl = "http://qa.koel.app";
    static String URL = "http://tutorialsninja.com/demo/";

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

  /*      List<WebElement> options =driver.findElements(By.cssSelector("#multiselect1 option"));
        for (WebElement e:options) {
            System.out.println(e.getText());
        }

        for (int i = 0;i<options.size();i++){
            System.out.println(options.get(i).getText());


        }*/

        String selector = "[class='widget LinkList'] li";
        List<WebElement> links = driver.findElements(By.cssSelector(selector ));
        System.out.println(links.size());


        for (int i = 1; i <=links.size()-3 ; i++) {
            String path = selector+":nth-child("+i+")";
            System.out.println(path);
           driver.findElement(By.cssSelector(path)).click();
            Thread.sleep((2000));
            driver.navigate().back();

        }



        driver.quit();


    }


}