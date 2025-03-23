import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MultipleDropDown extends Demo{

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.get(letCodeUrl);
        By fruits = By.id("fruits");
        By languages = By.id("lang");
        By countries = By.id("country");

        selectOptionInDropDownMenuWithText(fruits,"Mango");
        selectOptionInDropDownMenuWithIndex(languages,"2");
        selectOptionInDropDownMenuWithValue(countries,"Brazil");
        selectOption(fruits,"text","Mango");
        selectOption(languages,"index","2");
        selectOption(countries,"value","Brazil");

        //multiChoice
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        driver.findElement(By.id("justAnInputBox")).click();
        List<WebElement> allBoxes = driver.findElements(By
                //  .cssSelector("#comboTree638619DropDownContainer .comboTreeItemTitle>input[type = 'checkbox']"));
                //  .xpath("//div[@id='comboTree638619DropDownContainer']//span[@class ='comboTreeItemTitle']/input"));
                .xpath("//span[@class ='comboTreeItemTitle']"));
        for (WebElement box : allBoxes) {
            try {
                box.click();
            } catch (Exception e) {
            }


        }
    }
    }