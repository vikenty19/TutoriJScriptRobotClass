import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationAlert extends Demo{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.get(url);
        WebElement confirmation = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirm")));
        confirmation.click();
       wait.until(ExpectedConditions.alertIsPresent());//wait fo alert
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();//= cancel
      // alert.accept == ok
        WebElement textField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ta1")));
        textField.sendKeys("viktor morozov");

        // promt alert
        driver.get(LoadUrl);
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.cssSelector("ul>li:nth-child(3)>button")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        String alert1Text = alert1.getText();
        System.out.println(alert1Text);
        //enter text in alert field
        alert1.sendKeys("QQQQQ");
        alert1.accept();
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        String resultText = result.getText();
        System.out.println(resultText);
    }
}
