import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Test {
    public static   WebDriver driver=new ChromeDriver();

    static Set<String> allWindows;
    static String URL = "http://tutorialsninja.com/demo/";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com");
        driver.findElement(By.id("ta1")).sendKeys("Viktor Morozov");
        String parent = driver.getWindowHandle();
        driver.findElement(By.xpath("//div[@id ='HTML37']//a")).click();
        driver.findElement(By.linkText("Blogger")).click();
         allWindows = driver.getWindowHandles();
        switchTheWindow("New window");
        String textOnPopWindow =driver.findElement(By.xpath("//div/h3")).getText();
        System.out.println(textOnPopWindow);
        driver.close();
        switchTheWindow("Blogger.com");
        driver.findElement(By.cssSelector(".sign-in")).click();
        driver.switchTo().window(parent);
        driver.findElement(By.id("ta1")).sendKeys("Putin is crap");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL);
        driver.findElement(By.name("search")).sendKeys("HP");


    }
    public static void switchTheWindow(String title) {
        Iterator<String> itr = allWindows.iterator();
        while (itr.hasNext()) {
            String win = itr.next();
            driver.switchTo().window(win);
            if (driver.getTitle().contains(title)) {
                System.out.println(driver.getTitle());

                break;


            }
        }
    }
}