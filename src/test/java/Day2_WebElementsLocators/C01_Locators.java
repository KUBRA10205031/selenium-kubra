package Day2_WebElementsLocators;

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

public class C01_Locators {


    WebDriver driver;


    @Before
    public  void setup(){
        //driver oluşturuldu.
        WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();

        //sayfanın yenilenmesi beklendi.10 sn beklendi.thread sleep benzeri bir method.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       //linkedin sitesine gidildi.
       driver.get("https://www.linkedin.com/");
       driver.manage().window().maximize();   // driver maximize edildi.

        //sayfanın yenilenmesi beklendi.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public  void tearDown(){
        //driverımız kapatıldı.
        driver.quit();
    }

    @Test
    public void idLocators(){ // linkedin email alanının id sini alarak işlem yapıldı.

        //idLocator -> "session_key"
        WebElement email = driver.findElement(By.id("session_key")); // email alanı çalıştığım için email koydum
        email.sendKeys("Clarsuway selenium dersinden selamlar");
    }

    @Test
    public void nameLocators(){ // linkedin şifre alanının name'i alınarak şlem yapıldı.
        //nameLocators -name="session_password"
        WebElement passwordname=driver.findElement(By.name("session_password"));
        passwordname.sendKeys("şifre");

    }
    @Test
    public void classLocators(){
        //class="input__input"
        WebElement email=driver.findElement(By.className("input__input"));
        email.sendKeys("Class locator test.");

    }
    @Test
    public void tagLocators(){
        //tag locator = input
        WebElement email=driver.findElement(By.tagName("input"));
        email.sendKeys("Tag locator test.");
    }
    @Test
    public void tagnameLocators() throws InterruptedException {
        //tag locator = input
        List<WebElement> emailList = driver.findElements(By.tagName("input"));

        //2.input  tag im/ 2. elementimiz email text alanımız.bu yüzden bu elemanı email değişkenine assign ettik.

        WebElement email = emailList.get(1);

        email.sendKeys("Tag locator test.");
        Thread.sleep(10000);
    }
    @Test
    public void LinkTextLocator(){
      WebElement forgotPwd = driver.findElement(By.linkText("Şifrenizi mi unuttunuz?"));
      forgotPwd.click();

        }
    @Test
    public void partialLinkTextLocators(){
        //linkTest "şifrenizi mi unuttunuz."
        WebElement forgotPwd = driver.findElement(By.partialLinkText("Şifrenizi mi unuttunuz?"));
        forgotPwd.click();

    }
    @Test
    public void absoluteXpath() {
        //linkTest "şifrenizi mi unuttunuz."
        WebElement email = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[2]/div[1]/input"));
        email.sendKeys("kubra absolute xpath konusu gayet başarılı.");
    }
    @Test
    public void relativeXpath() {
        //xpath locator -> //input[@name='session_key']"
        WebElement email = driver.findElement(By.xpath("//input[@name='session_key']"));
        email.sendKeys("kubra relative xpath konusu gayet başarılı.");
    }

    @Test
    public void multipleAttributeXpath() {  // birden fazla attribute alarak xpath kullandık.
      //xpath locator="//input[@class='input__input'][@name='session_key']"
        WebElement email = driver.findElement(By.xpath("//input[@class='input__input'][@name='session_key']"));

        email.sendKeys("kubra multipleAttributeXpath konusu gayet başarılı.");
    }

    @Test
    public void andOrXpath() {
        //xpath locator= //input[@class='input__input'and@name='session_key']
        WebElement email = driver.findElement(By.xpath("//input[@class='input__input'and@name='session_key']"));

        email.sendKeys("kubra andOrXpath konusu gayet başarılı.");
    }

    @Test
    public void containsXpath(){
        // xpath locator =//input[contains(@id,'session_key')]
        WebElement email= driver.findElement(By.xpath("//input[contains(@id,'key')]"));
        email.sendKeys("kubra containsXpath konusu gayet başarılı.");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void startswithXpath(){
        // xpath locator = //input[starts-with(@id,'session')]
        WebElement email= driver.findElement(By.xpath("//input[starts-with(@id,'session')]"));
        email.sendKeys("kubra startswithXpath konusu gayet başarılı.");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void containstextXpath() throws InterruptedException {
        // xpath locator = //input[starts-with(@id,'session')]
        WebElement email = driver.findElement(By.xpath("//button[contains(text(),'Oturum açın')]"));
        email.sendKeys("kubra containstextXpath konusu gayet başarılı.");
        // Thread.sleep(5000); --> önerilmez..
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }































}
