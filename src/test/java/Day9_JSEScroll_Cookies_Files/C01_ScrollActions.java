package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C01_ScrollActions extends BaseTest {

    @Test
    public void scrollPageUpDown() throws InterruptedException {
        driver.get("https://amazon.com");
        Actions actions=new Actions(driver);
        Thread.sleep(2000);

        actions.sendKeys(Keys.PAGE_DOWN).perform();// sayfadaki aşağı yukarı tabıyla işlem yapılıyor.bir sayfa boyunca aşağı iniyor.
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);



    }

    @Test
    public void scrollArrowUpDown() throws InterruptedException {
        driver.get("https://amazon.com");
        Actions actions=new Actions(driver);
        Thread.sleep(2000);

        actions.sendKeys(Keys.ARROW_DOWN).perform(); //klavyedeki aşağı yukarı ok tuşlarıyla bir tık değişim yapıyor.
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(2000);



    }
}
