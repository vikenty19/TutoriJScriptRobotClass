import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthPopUpAlertPushNotification extends Demo {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        // authenticate user you should enter your login and password admin is for demo only!
        Thread.sleep(3000);
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");// admin --> login,admin-->password

        //Pop up notifications from Chrome

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("https://www.justdial.com/");



    }
}
