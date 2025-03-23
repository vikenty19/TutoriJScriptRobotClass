import io.github.bonigarcia.wdm.WebDriverManager;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class DropDown extends Demo{

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement selectOption = wait.until(ExpectedConditions.elementToBeClickable(By.id("drop1")));
        selectOption.click();
        //create object Select class
        Select select = new Select(selectOption);
        select.selectByVisibleText("doc 4");

        select.selectByIndex(0);

        select.selectByValue("ghi");
        //get options text of drop menu
        List<WebElement> options = select.getOptions();
        for(WebElement i:options){
            System.out.println(i.getText());
        }

        //multi-selection boxes

        WebElement menuSelect = wait.until(ExpectedConditions
                .elementToBeClickable(By.id("multiselect1")));
        Select select1 = new Select(menuSelect);
        select1.selectByVisibleText("Volvo");
        select1.selectByIndex(2);
        Thread.sleep(2000);
        select1.deselectByValue("Hyundaix");
        Thread.sleep(2000);


driver.quit();

    }
    public static void generateTimeStamp(){
        Date date = new Date();
        String exactTime = date.toString().replace(":","_");
        System.out.println(exactTime);
    }
}
