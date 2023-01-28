package Day3_LocatorsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Practice {

    /*
    1- Create the driver with Beforeclass and make it static inside the class.
    2- Go to http://www.google.com
    3- Type "Green Mile" in the search box and print the number of results.
    4- Type "Premonition" in the search box and print the number of results.
    5- Type "The Curious Case of Benjamin Button " in the search box and print the number of results.
    6- Close with AfterClass
     */

    static WebDriver driver;
    @BeforeClass
    public static void crateDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Before
    public void BeforeEach(){
        driver.get("http://www.google.com");
    }

    @AfterClass
    public static void closeDriver(){
        driver.quit();
    }
    @Test
    public void LocaterPractice() throws InterruptedException {
    WebElement aramabutonu =driver.findElement(By.xpath("//input[@name='q']"));
    aramabutonu.sendKeys("Green Mile"+ Keys.ENTER);

    WebElement sonuc=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonuc.getText());
        Thread.sleep(5000);


    }
    @Test
    public void LocaterPractice1() throws InterruptedException {
        WebElement aramabutonu1 =driver.findElement(By.xpath("//input[@name='q']"));
        aramabutonu1.sendKeys("Premonition"+ Keys.ENTER);

        WebElement sonuc1=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonuc1.getText());
        Thread.sleep(5000);


    }
    @Test
    public void LocaterPractice2() throws InterruptedException {
        WebElement aramabutonu2 = driver.findElement(By.xpath("//input[@name='q']"));
        aramabutonu2.sendKeys("The Curious Case of Benjamin Button" + Keys.ENTER);

        WebElement sonuc2 = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonuc2.getText());
        Thread.sleep(5000);
    }


    }
