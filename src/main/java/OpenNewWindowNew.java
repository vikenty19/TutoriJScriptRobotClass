import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenNewWindowNew {
    public static String url = "https://omayo.blogspot.com";
    static String URL = "http://tutorialsninja.com/demo/";
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.id("ta1")).sendKeys("QQQQ");
        //we open new window simultaneously
       driver.switchTo().newWindow(WindowType.WINDOW);// if the new tab driver.switchTo().newWindow(WindowType.TAB);
     //  driver.switchTo().newWindow(WindowType.TAB);
      driver.manage().window().maximize();
        driver.get(URL);
        driver.findElement(By.name("search")).sendKeys("HP");
     //   driver.close();
    }
}
