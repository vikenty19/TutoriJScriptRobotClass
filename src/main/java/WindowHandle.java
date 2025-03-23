import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import static dev.failsafe.internal.util.Assert.*;

public class WindowHandle {
    public static String url = "https://omayo.blogspot.com";
    static String KoelUrl = "http://qa.koel.app";
    static String URL = "http://tutorialsninja.com/demo/";
    static WebDriver driver=null;
    static Set<String> allWindows;


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        //write down text
        driver.findElement(By.id("ta1")).sendKeys("Viktor Morozov");
        //id parent window -we need it to return to this window
        String parentWindowId = driver.getWindowHandle();
               //click to open pop window (first child window)
        driver.findElement(By.xpath("//div[@id ='HTML37']//a")).click();
        //click to open second child window
        driver.findElement(By.linkText("Blogger")).click();

          allWindows = driver.getWindowHandles();//all windows id Set!
        //iteration windows from Set
        switchToAnotherWindow("New window");
        String textOnPopWindow =driver.findElement(By.xpath("//div/h3")).getText();
        System.out.println(textOnPopWindow);//first window is found

        //another iteration to find next window

        switchToAnotherWindow("Blogger.com");
        driver.findElement(By.cssSelector(".sign-in")).click();//   "//span[text()='Sign in']"
         Thread.sleep(5000);
        System.out.println(driver.findElement(By.cssSelector("#headingText span")).getText());
        System.out.println(driver.getTitle());
        //Switch to the parent window (back)
        driver.switchTo().window(parentWindowId);

        driver.findElement(By.name("q")).sendKeys("Putin is shit");
        Thread.sleep(2000);
    //    driver.quit();

            }


    // search for window
    public static void switchToAnotherWindow(String title){
        Iterator<String> itr = allWindows.iterator();

        while (itr.hasNext()){

            String win = itr.next();
            driver.switchTo().window(win);
            if (driver.getTitle().contains(title)){

                break;
            }


        }


    }
}
