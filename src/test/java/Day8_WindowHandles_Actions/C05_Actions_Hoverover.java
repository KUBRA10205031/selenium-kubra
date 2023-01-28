package Day8_WindowHandles_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C05_Actions_Hoverover extends BaseTest {
    @Test
    public void Hoverover(){
        /*
        1- Go to URL : https://www.amazon.com/
        2- Click on "Hello, Sign in Account & Lists" link.
        3- Click on Orders page.
        4- Verify the page title contains "Amazon".
         */

        driver.get("https://www.amazon.com/");
        WebElement accountaAndLists= driver.findElement(By.id("nav-link-accountList"));

        Actions actions=new Actions(driver);
        actions.moveToElement(accountaAndLists)
                .click(driver.findElement(By.id("nav_prefetch_yourorders")))
                .perform();
         Assert.assertEquals("Amazon Sign-In" , driver.getTitle());


    }
}
