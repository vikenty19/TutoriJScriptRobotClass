import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenShotRobot extends Demo {
    public static void main(String[] args) throws AWTException, IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(URL);
        Thread.sleep(2000);
        //Robot class allows to make alert and screenshots with page title
        Robot robot2 = new Robot();
        // we need to create rectangle of screenshot field
        Rectangle rectangle2 = new Rectangle(25,50,1000,500);
        //screenshot image should be saved as BufferedImage variable
        BufferedImage srcImage = robot2.createScreenCapture(rectangle2);//ScreenShotRobot must be created in advance
        // Writing down in the created folder
        ImageIO.write(srcImage,"PNG",new File("./ScreenShotRobot/dimensionByHand.png"));
        Robot robot  = new Robot();
        // it needs to use ALL dimension of the screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();//getting a screen size
        Rectangle rectangle = new Rectangle(dimension);

       BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
        //writing image with title into the fileString
       String destinationPath = System.getProperty("user.dir")+ "/ScreenShotRobot/robotWholeScreen.png";
        ImageIO.write(bufferedImage,"png",new File(destinationPath));
        //Alert Screenshot
        driver.get(url);
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert1")));
        alert.click();
        Thread.sleep(1000);
        Robot robot1  = new Robot();
        // it needs dimension of the screen
         Dimension dimension1 = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle1 = new Rectangle(dimension1);
        BufferedImage bufferedImage1 = robot1.createScreenCapture(rectangle1);
        String  destinationPath1 = System.getProperty("user.dir")+ "/ScreenShotRobot/robotAlert.png";
        ImageIO.write(bufferedImage1,"png",new File(destinationPath1));
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
driver.quit();


    }
}
