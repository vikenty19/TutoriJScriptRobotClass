import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RobotMouseMove extends Demo {

    public static void main(String[] args) {
// Coordinates depend on the Screen and the type of the driver!!!
           WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        //To move mouse to hover exact button according to
        //X,Y coordinate
   /*     try {
            Robot robot = new Robot();
            robot.delay(2000);
            robot.mouseMove(200,380);
            //click left mouse btn on the link
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
          // right mouse btn click

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        driver.get(url);*/
        Robot robot1 = null;
        try {
            robot1 = new Robot();
            robot1.mouseMove(200,320);
            //Right btn mouse click
            robot1.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            robot1.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            robot1.delay(2000);
            // Enter press to chose first option
            robot1.keyPress(KeyEvent.VK_DOWN);
            robot1.keyRelease(KeyEvent.VK_DOWN);
            // press ENTER
            robot1.keyPress(KeyEvent.VK_ENTER);
            robot1.keyRelease(KeyEvent.VK_ENTER);


        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

    }
}