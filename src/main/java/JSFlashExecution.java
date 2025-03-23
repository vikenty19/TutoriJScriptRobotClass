import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSFlashExecution {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
       WebElement cartButton = driver.findElement(By.cssSelector("#cart>button"));
       // getting color index or color depends on the program
       String defaultColor = cartButton.getCssValue("background-color");
        System.out.println(defaultColor);
        javaScriptFlash(driver,cartButton);
        driver.findElement(By.cssSelector(".dropdown")).click();
        driver.findElement(By.cssSelector("ul.dropdown-menu-right> li:nth-child(2)")).click();
        WebElement loginBtn = driver.findElement(By.cssSelector("input[type = 'submit']"));
      //      javaScriptFlash(driver,cartButton);
            javaScriptFlash(driver,loginBtn);
        driver.quit();
    }
    public static void javaScriptFlash(WebDriver driver,WebElement element)  {
        String defaultColor = element.getCssValue("background-color");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        for (int i = 1; i <40 ; i++) {
            //Change button color taken from the style window
            js.executeScript("arguments[0].style.background='blue';",element); //background
            js.executeScript("arguments[0].style.color='red';",element);//text color changing
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Return to default color
            js.executeScript("arguments[0].style.background='" + defaultColor + "';",element);
        }
    }
}