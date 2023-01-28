package Day7_iframe_WindowHandles;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class C04_WindowHandles extends BaseTest {
    /*
    1- Go to URL: http://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/
    2- Print the existing windowHandles ids by clicking all the links on the page.
    3- Click on the links that open a new page.
    4- Close other pages other than the home page.
    5- Set the driver back to the main page.
     */

    @Test
    public void WindowHandles(){
        driver.get("http://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/");

        // ilk ana sayfamızın id 'sini sakladık istediğimiz zaman ana sayfaya dönebilelim karıştırmayalım diye.
       String homePageId= driver.getWindowHandle();

         // sitede kaç tane ayrı sekmede pencere açacak link var bunu bulduk.listeye ekledik(HTML "//a[@target='_blank']")
        List<WebElement> links=driver.findElements(By.xpath("//a[@target='_blank']"));

        //listedeki her bir linke tek tek tıkla yeni sekmede aç.
        //links.forEach(WebElement::click);

        //listedeki sadece iki linke tıkla yeni sekmede aç .
        links.get(0).click(); //----> ilk linke tıkla
        links.get(1).click(); //--------> ikinci linke tıkla.


        // oluşturulan açılan pencereleri gertwindowhandles methoduyla bunların id'lerini bir set içerisine aldık.
        Set< String>windows=driver.getWindowHandles();



        //iterator oluşturuldu.//1-hasnext methodu ile bir sonraki değerin olup olmadığını kontrol ediyorduk
                               // 2- next methodu ile de bir sonraki elemente geçiş yapmış oluyorduk.
        // oluşturulan set' de içinde gezmek için iterator oluşturdum.

        Iterator<String> iterator= windows.iterator();

        //gezinme işlemi
        while (iterator.hasNext()){
            //Her bir gezinilen id kullanılarak o anki sekmeye switch ediyoruz.
            driver.switchTo().window(iterator.next());

            //Switch ettiğimiz sayfanın ana sayfa olup olmadığını kontrol ediyoruz.
            //Ana sayfa ise sekmeyi kapatmıyoruz değilse kapatıyoruz.
            // getWindowhandle sekmemizin id'sini ana sayfamızın id'si ile eşit mi diye kontrol ediyoruz.
            // ana sayfaya gelene kadar diğer sekmeleri kapat komutu veriyoruz.
            if(driver.getWindowHandle().equals(homePageId)){
                //driver close 'u es geçiyoruz.
                continue;
            }
            //sekmeyi kapatıyoruz.
            driver.close();


        }



    }
}
