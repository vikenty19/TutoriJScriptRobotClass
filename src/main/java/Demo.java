import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Demo {

    public static String url = "https://omayo.blogspot.com";
    static String KoelUrl = "http://qa.koel.app";
    static String URL = "http://tutorialsninja.com/demo/";
    static String LoadUrl = "https://the-internet.herokuapp.com/";

    static String letCodeUrl = "https://letcode.in/dropdowns";
    static WebDriver driver;
    static  WebDriverWait wait;


    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        wait =new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get(url);


          /*     Thread.sleep(3000);
     /*  WebElement P = driver.findElement(By.xpath("//button[contains(text(), 'Submit')]"));
        System.out.println(P.getText());

           */
        // navigate-forward- back
        driver.navigate().to("https://selenium143.blogspot.com/");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
// dimension
      /*  Dimension  d = driver.findElement(By.id("but2")).getSize();
        System.out.println(d.height);
        System.out.println(d.width);
        Dimension v =new Dimension(400,400);
        driver.manage().window().setSize(v);*/
// page load time
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        driver.quit();


    }

    //Methods for MultiDropDown
    public static WebElement selectWebElement(By field) {
        return wait.until(ExpectedConditions
                .elementToBeClickable(field));

    }

    public static void selectOptionInDropDownMenuWithText(By field, String text) {

        Select select = new Select(selectWebElement(field));
        select.selectByVisibleText(text);

    }

    public static void selectOptionInDropDownMenuWithIndex(By field, String index) {

        Select select = new Select(selectWebElement(field));
        select.selectByIndex(Integer.parseInt(index));

    }

    public static void selectOptionInDropDownMenuWithValue(By field, String value) {

        Select select = new Select(selectWebElement(field));
        select.selectByValue(value);
    }
    ///////////////////////////////

    public static void selectOption(By field, String optionType, String value) {
        Select select = new Select(selectWebElement(field));
        switch (optionType) {
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
        }
    }

    }
