import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenShots extends Demo{

    public static void main(String[] args)  {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        //Take Screenshot here
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //write file into path of the project from apache
        File destinationFile = new File("./Screenshots/omayo.png");//path to put down the file -creating automatically
        try {
            FileUtils.copyFile(srcFile,destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //multiple windows ScreenShots
        driver.findElement(By.linkText("onlytestingblog")).click();

        File srcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile1,new File("./Screenshots/basic.png"));//apache library
            FileHandler.copy(srcFile1,new File("./Screenshots1/basic1.png"));//Selenium option BUT!
            // we need to create Screenshot1 file preliminary!!
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

}
