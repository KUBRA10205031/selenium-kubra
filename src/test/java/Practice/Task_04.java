package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import java.util.List;

public class Task_04 extends BaseTest {
    /*
    1-https://the-internet.herokuapp.com/dropdown adresine gidin.
    2-Index kullanarak seçenek 1'i (Option 1) seçin ve yazdırın.
    2-Value kullanarak Seçenek 2' yi (Optin 2) seçin ve yazdırın.
    3-Visible Text (Görünen metin ) kullanarak Seçenek 1'i (Option 1) seçin ve yazdırın.
    4-Tüm dropdown değerleri (value) yazdırın.
    5-Dropdown 'un boyutunu bulun, Dropdown'da 4 öge varsa konsolda TRUE , değilse FALSE yazdırın.

     */
    @Test
    public void task() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement searchbutton= driver.findElement(By.id("dropdown"));
        Select select=new Select(searchbutton);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        List<WebElement> alloptions=select.getOptions();
        alloptions.forEach(t-> System.out.println(t.getText()));

        if (alloptions.size()==4){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }
}
