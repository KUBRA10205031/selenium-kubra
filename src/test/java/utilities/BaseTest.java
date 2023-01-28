package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*---->>>> INTERWİEV SORUSU ------>>>>>>
 1-Abstract yaparak TestBase Class'ından obje oluşturulmasının önüne geçeriz.
 2-TesBase Class'ı sadece extends ile inherit ederk kullanacağız.Dolayısıyla oluşturduğumuz driver variable'i
 için protected access modifier seçiyoruz.
 */

public class BaseTest { //abstract da eklenebilir,şart değil market de kullanılmayabilir.

    protected WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    /* Eğer extend class'ında bir methodu yoruma almak isterseniz ya da
       çalışmamasını isterseniz kullancağınız class 'da Override ederek
       kullanımını durdurabilirsiniz.
       örn: @After class'ından driver.quit 'i durdurmak sitiyorum sayfa
       kapanmasın istiyorum
       bunun için çalışan class'da override edilebilir.
          @Override
              public void tearDown(){
                                           }                       */

    @After
   public void close(){driver.quit();
    }
}
