package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/*---->>> RADİO BUTTON HOMEWORK --->>>*/

        /*
           1- Go to URL: https://demoqa.com/radio-button
           2- Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
           3- Her bir seçenek seçildiğinde aşağıda çıkan text’leri konsolda yazdırınız.
       */

public class C07_RadioButtonHomework {
    WebDriver driver;
    @Before

    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void close(){
        driver.quit();
    }
    @Test
    public void RadioButtonHomework() throws InterruptedException {

        driver.get("https://demoqa.com/radio-button");

        WebElement yesselected= driver.findElement(By.xpath("//label[@for='yesRadio']"));
        WebElement impressiveselected=driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        WebElement noselected=driver.findElement(By.xpath("//label[@for='noRadio']"));

        yesselected.click();
        Assert.assertTrue("yes seçilmiyor.",!(yesselected.isSelected()));// yes butonunun seçili değil mi? kontrol et.seçili değilse yes seçilmiyor yazdır.seçiliyse alt satırdan devam et.
        Assert.assertTrue(!((impressiveselected.isSelected())&&(noselected.isSelected())));
        WebElement yesbutonuseçili=driver.findElement(By.xpath("//p[@class='mt-3']"));
        System.out.println(yesbutonuseçili.getText());


        impressiveselected.click();
        Assert.assertTrue("impressive seçilmiyor.",!(impressiveselected.isSelected()));
        Assert.assertTrue(!((yesselected.isSelected())&&(noselected.isSelected())));
        WebElement impressivebutonuseçili=driver.findElement(By.xpath("//p[@class='mt-3']"));
        System.out.println(impressivebutonuseçili.getText());



        noselected.click();
        Assert.assertTrue("no seçilmiyor.",!(noselected.isSelected()));
        Assert.assertTrue(!((yesselected.isSelected())&&(impressiveselected.isSelected())));












    }

}
