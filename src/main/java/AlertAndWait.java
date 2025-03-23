import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertAndWait extends Demo {


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Global Wait waits for every element

        driver.get(url);
        driver.findElement(By.cssSelector("button.dropbtn")).click();

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));//Waiting of special element
        WebElement gmail = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#myDropdown>a:nth-child(3)")));
        // gmail.click();
        // driver.findElement(By.cssSelector("#myDropdown>a:nth-child(3)")).click();

        // Alerts handle
        driver.findElement(By.id("alert1")).click();
        //wait until alert is present
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();//switch to alert window     //   System.out.println(driver.switchTo().alert().getText());
        //     driver.switchTo().alert().accept();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();//close the alert window
        //   alert.dismiss();//another wau to close the alert close
        WebElement textField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ta1")));
        textField.sendKeys("viktor morozov");
        driver.quit();

    }
}
