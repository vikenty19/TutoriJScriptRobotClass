import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class FullScreenShots extends Demo{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        //Screenshot of the particular element
       WebElement multiSelectBox =  driver.findElement(By.id("multiselect1"));
       File srcFile =multiSelectBox.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(srcFile,new File("./Screenshots1/multiWindow.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Screenshot of the section
        WebElement areaField = driver.findElement(By.cssSelector("#main #HTML11 .widget-content"));
        File srcFile1 = areaField.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(srcFile1,new File("./Screenshots1/areaShot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
