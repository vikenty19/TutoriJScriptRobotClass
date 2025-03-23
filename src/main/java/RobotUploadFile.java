import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class RobotUploadFile extends Demo{
    public static void main(String[] args) throws AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LoadUrl+"upload");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //first choosing path e.g.
        String path = System.getProperty("user.dir")+"\\Screenshots\\basic.png";
        StringSelection stringSelection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);//emulate Cntrl+C
        // To click on chooseFile button in this case we need Action class
        WebElement fileUpload = wait.until(ExpectedConditions.elementToBeClickable(By.id("file-upload")));

        Actions actions = new Actions(driver);
        actions.moveToElement(fileUpload)
                .click()
                .perform();

        Robot robot = new Robot();
        robot.delay(2000);//otherwise it's not working
        // emulation od ctrl+V action
        robot.keyPress(KeyEvent.VK_CONTROL);//push
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(2000);
        //Push Open btn == Push Enter on Keyboard
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        //click submit(Load) btn
        WebElement load = wait.until(ExpectedConditions.elementToBeClickable(By.id("file-submit")));
        load.click();
    }
}
