package Day8_WindowHandles_Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.Set;

public class C01_WindowHandleSe4 extends BaseTest {
    /*
    1- Go to URL: https://testproject.io/
    2- Selenium's 4 newWindow() method to open a new.
    3- Window for Testproject's Blog page.
    4- https:/blog.testproject.io/
     */

    @Test
    public void WindowHandlesSe4(){
        //ana sekmemizi açıyoruz.
        driver.get("https://testproject.io/");

        //Yeni pencere oluşturup o peecereye switch ediyoruz geçiş yapıyoruz. --- zz 1.YOL
        driver.switchTo().newWindow(WindowType.WINDOW);
        //2.YOL
        WebDriver newWindow=driver.switchTo().newWindow(WindowType.WINDOW);
        newWindow.get("https://testproject.io/");


        driver.get("https:/blog.testproject.io/");
        //yeni pencerimizde URL imizi ziyatret ediyoruz.----*** 1.YOL
        driver.switchTo().newWindow(WindowType.TAB);

        //2.YOL ---***
        WebDriver newTab=driver.switchTo().newWindow(WindowType.TAB);
        newTab.get("https:/blog.testproject.io/");

    }
    @Test
    public void newTab(){
        //Ana sekmemizden testproject açıldı.
       driver.get("https://testproject.io/");

       // yeni bir sekme oluşturuldu.
        WebDriver newTab=driver.switchTo().newWindow(WindowType.TAB);

        //yeni sekmeden amazona gidildi.
        newTab.get("https://www.amazon.com/");

        //Aktif tab in title 'ı yazdırıldı. --** Aktif tab imiz=yeni oluşturulan tab
        System.out.println(driver.getTitle());
    }
    @Test
    public void handleWindow(){

        //ana sekmemizde amazona  gdiyoruz.
        driver.get("https://www.amazon.com/");

        //getwindowhandle()  -- getwindowhandles()--set döndürüyor.
        String homepageHandle=driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        //yeni sekmemizde amazon tr'yi açtık.
        driver.get("https://www.amazon.com.tr/");

        //yeni pencere oluşturduk.
        driver.switchTo().newWindow(WindowType.WINDOW);

        //yeni pencerede google 'ı açtık.
        driver.get("https://www.google.com/");

        Set<String> handles =driver.getWindowHandles();
        Iterator<String> iterator=handles.iterator();


        while (iterator.hasNext()){
            String currentTab =iterator.next();

            driver.switchTo().window(currentTab);

            System.out.println(driver.getTitle());

            //1.YOL
            if(!driver.getWindowHandle().equals(homepageHandle))
             driver.close();
        }

             //2.YOL
        if (!driver.getTitle().contains("Spend")){
            driver.close();
        }


    }
}

