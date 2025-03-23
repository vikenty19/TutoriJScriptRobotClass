import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertLightBox extends Demo {
    public static void main(String[] args) {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        wait =new WebDriverWait(driver,Duration.ofSeconds(10));
        //lightbox handle
        driver.get(URL);
        driver.findElement(By.name("search")).sendKeys("HP");
      //  WebElement find1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa-search")));
        WebElement find1 = Demo.selectWebElement(By.cssSelector(".fa-search"));
        find1.click();
        WebElement find2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".caption a")));
        find2.click();
        WebElement find3 = Demo.selectWebElement(By.xpath("//a[text() = 'HP LP3065']"));
      //  WebElement find3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = 'HP LP3065']")));
        String text = find3.getText();
        find3.click();
        WebElement find4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title = 'HP LP3065']")));
        find4.click();
        WebElement find5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title = 'Close (Esc)']")));
        find5.click();

        System.out.println(text + "   This is my computer");
        driver.quit();
    }

}
