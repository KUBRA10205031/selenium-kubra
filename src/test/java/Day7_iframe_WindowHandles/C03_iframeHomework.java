package Day7_iframe_WindowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_iframeHomework {

    /*
    1-Go to URL: "http://demo.guru99.com/test/guru99home/
    2-Find the number of iframes on the page.
    3-Link to the fourth iframe (JMeter Made Easy) (http://demo.guru99.com/test/guru99home) click here.
    4-Exit the iframe and return to the main page.

     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void close(){
        driver.quit();
    }
    @Test
    public void iframe(){
        driver.get("http://demo.guru99.com/test/guru99home/");
        List<WebElement>iframesayısı=driver.findElements(By.xpath("//iframe"));
        System.out.println("iframesayısı:"+iframesayısı.size());

        driver.switchTo().frame("a077aa5e");
        WebElement JMeteriframe= driver.findElement(By.cssSelector("[src='Jmeter720.png']"));
        JMeteriframe.click();
        driver.switchTo().defaultContent();
    }
}
