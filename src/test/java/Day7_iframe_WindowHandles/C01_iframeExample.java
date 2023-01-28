package Day7_iframe_WindowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_iframeExample {
    /*
    1- Go to URL:" https://the-internet.herokuapp.com/iframe"
    2- Verify the Bolded text contains "Editor"
    3- Locate the text box.
    4- Delete the text in the text box
    5- Type "Hi everyone"
    6- Verify the text Elemental Selenium text is displayed on the page.
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
    public void iframeTest() throws InterruptedException {
        //Go to URL:" https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Verify the Bolded text contains "Editor" --->>> verify dendiğinde aklımıza assert classı gelmeli.
        WebElement edıtor= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(edıtor.getText().contains("Editor"));

        //Locate the text box
        driver.switchTo().frame(0);
        WebElement textbox=driver.findElement(By.id("tinymce"));

        //Delete the text in the text box.
        textbox.click();
        textbox.clear();// var olan metni silmek için 2.YOL: textbox.findeELement(By.tagname("p")).clear();
                        // var olan metni silmek için 3. YOL :(Keys.BACK_SPACE).content().size();(for döngüsüne alarak)

        //Type "Hi everyone"
        textbox.sendKeys("Hi Eveyone");

        //Verify the text Elemental Selenium text is displayed on the page.


         // sayfaya geri switch işlemi yapılır.

        driver.switchTo().defaultContent(); // burayı yazmadığımızda nosuchELement hatası alırız.bu element( "Elemental") ana frame içinde olduğu için
                                            // içerideki frame den ana frame geçmek, üst frame geçmek için kullandık ve doğru frame geçiş yaptık.
        Assert.assertTrue(driver.findElement(By.partialLinkText("Elemental")).isDisplayed());







    }




}
