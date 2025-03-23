import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicallyLoading extends Demo{
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get( LoadUrl);
          driver.findElement(By.linkText("Dynamic Loading")).click();
          driver.findElement((By.linkText("Example 1: Element on page that is hidden"))).click();
          driver.findElement(By.cssSelector("div#start button")).click();
          // Wait while loading Two ways = invisibility of element
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id = 'loading']/img")));
        // or visibility next one
     //  WebElement pageHead=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='finish']/h4")));
        WebElement textOnPage = driver.findElement(By.xpath("//div[@id ='finish']/h4"));
       String text =textOnPage.getText();
       System.out.println(text);

        driver.quit();
    }
}
