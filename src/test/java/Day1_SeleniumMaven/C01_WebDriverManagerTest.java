package Day1_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriverManagerTest {
    public static void main(String[] args) {

        /*
        1- Set Path
        2- Create chrome driver
        3- Maximize the window.
        4- Open google home page. https://www.google.com/
        5- Verify that you are Google in the title.
         */


        //System.setProperty' nin yerine artık maven ile WebDriver Manager classını kullanarak chromedriver binary lerimiz indirdik.
        WebDriverManager.chromedriver().setup();

        //chrome driverımızı yazıyoruz.
        WebDriver driver=new ChromeDriver();

        //windowu max ettik.
        driver.manage().window().maximize();

        // google ana sayfasına gittik.
        driver.get("https://www.google.com/");

        // tittle mızı aldık.
        String title =driver.getTitle();

        //title ımızı doğruladık.
        if (title.equals("Google")){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title testi FAILED");

        }
      //driverımızı kapattık
        driver.quit();



    }
}
