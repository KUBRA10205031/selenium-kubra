package Day1_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_JunitAssertions {


      /*
      --> Go to Amazon homapage.
      --> Do the following tasks by creating 3 different test methods.
      1- Test if the URL contains Amazon.
      2- Test if the title does not contain Facebook
      3- Test that the Amazon logo appears in the upper left corner.

       */

    // assertEquals -> değer eşitliğini kontrol eder adres eşitliği değil
    // assertTrue -> içerdeki şartın doğruluğunu kontrol eder
    // assertFalse -> içerdeki şartın doğru olmadığını kontrol eder.
    // assertNull -> içerisindeki ifadenin null olduğunu yani herhangi bir atama yapılmamış olduğunu kontrol eder.
    // assertNotNull -> içerisindeki ifadenin null olmadığını kontrol eder.
    // assertSame -> adres karşılaştırması yapar.
    // assertNotSame ->adres karşılaştırması yapıp eşit olmaması durumunda bize doğruyu verir..
    // assertArrayEquals -> Arraylerin eşit uzunlukta ve içerikte olup olmadığını kontrol eder.


    WebDriver driver;          //method dışındaki bir field'ın method içerisinde declare edilmeden kullanılmasını sağladık.
                               // Artık dışardaki objem buradaki before methodu sayesinde chrome driver değerini almış olacak
                               // ve ben daha sonrasında bu driver objemi istediğim task metodunun içerisinde kullanabileceğim.
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup(); //mavende olduğumuz için artık System.setProperty olarak değil
                                                 // bu methodla chrome driverımızı indirdik.
        driver = new ChromeDriver();

    }
    @After
    public void after(){
        driver.quit();

    }
    @Test
    public void assertinTest(){
        driver.get("https://www.amazon.com/"); //amazon sitesine gittik.
        String currentUrl= driver.getCurrentUrl();
        currentUrl.contains("amazon");

        //URL amazon kelimesini içeriyor mu kontrol sağlanıyor.
        Assert.assertTrue("Url 'amazon' içermiyor",currentUrl.contains("amazon"));


    }
    @Test
    public void URLTest() {
        driver.get("https://www.amazon.com/"); //amazon sitesine gittik.
        String currentUrl = driver.getCurrentUrl();
        currentUrl.contains("amazon");

        //URL amazon kelimesini içeriyor mu kontrol sağlanıyor.
        Assert.assertTrue("Url 'amazon' içermiyor", currentUrl.contains("amazon"));
    }
    @Test
    public void titleTest(){
        driver.get("https://www.amazon.com/");
        String title = driver.getTitle();
        Assert.assertFalse(title.contains("Facebook")); // == Assert.assertTrue(!title.contains("Facebook"));

    }
    // TO BE CONTınued (WEBBELEMENTS)

































    }

