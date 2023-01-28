package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class Task_01 extends BaseTest {
    /*
    1-https://www.amazon.com/ sayfasına git.
    2-arama kutusunu locate edlim
    3-"samsung headphones" ile arama yapalım
    4-Bulunan sonuç sayısını yazdıralım.
    5-İlk ürünü tıklayalım.
    6-Sayfadaki tüm ürün başlıklarını yadıralım.

     */

    @Test
    public void task() {
        driver.get("https://www.amazon.com/");
        WebElement searchbutton= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchbutton.sendKeys("samsung headphones"+ Keys.ENTER); // apple de yazdırsak oluyor.

        WebElement result= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println("bulunan sonuç sayısı:"+result.getText());

        WebElement firstoptions= driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        firstoptions.click();

        driver.navigate().back();

        List<WebElement> allproducts=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));// bütün ürünleri bir liste attık.sonra tek tek seçip yazdırdık.
        for (WebElement each:allproducts){
            System.out.println(each.getText());


        }

    }
}
