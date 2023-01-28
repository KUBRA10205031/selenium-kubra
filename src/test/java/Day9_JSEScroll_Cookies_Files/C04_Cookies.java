package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.BaseTest;

import java.util.Set;

public class C04_Cookies extends BaseTest {
    @Test
    public void cookies() {
        /*
        1-Go to URL: https://kitchen.applitools.com/ingredients/cookie
        2-Get cookie.
        3-Find the total number of cookies.
        4-Print all the cookies.
        5-Add cookies.
        6-Edit cookies.
        7-Delete Cookies
        8-Delete All Cookies.

         */
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        System.out.println("test get cookie");
        Cookie cookie=driver.manage().getCookieNamed("protein");// cookie'yi isimle çağırmış olduk
        Assert.assertEquals("chicken", cookie.getValue());

        //Find the total number of cookies.
        Set<Cookie> allCookies=driver.manage().getCookies();
        int numofcookies=allCookies.size();
        System.out.println("numofcookies = "+numofcookies);

        //Print all the cookies.

        for (Cookie each:allCookies){
            System.out.println("each cookie :"+ each);
            System.out.println("each cookie name:"+each.getName());
            System.out.println("each cookie value:"+each.getValue());


        }

        //Add cookie.
        System.out.println("add cookie");
        Cookie cookie1=new Cookie("fruit","apple"); // cookie oluşturduk.
        driver.manage().addCookie(cookie1);
        Assert.assertEquals("eşleşme olmadı.",cookie1.getValue(),driver.manage().getCookieNamed(cookie1.getName()).getValue());

        allCookies=driver.manage().getCookies(); // sayfada varolan cookie'leri döndürür.
        System.out.println("son toplam cookies sayısı:"+allCookies.size()); // cookieler eklendikten sonraki sayısı.

        Cookie editedCookie=new Cookie(cookie1.getName(),"mango");
        driver.manage().addCookie(editedCookie);
        Assert.assertEquals(editedCookie.getValue(),driver.manage().getCookieNamed(cookie1.getName()).getValue());
        System.out.println(driver.manage().getCookieNamed(cookie1.getName()).getValue()); //mango



    }

    @Test
    public void deleteCookies() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        Set<Cookie> allCookies=driver.manage().getCookies();
        int numofcookies=allCookies.size();
        System.out.println("numofcookies = "+numofcookies);//num of cookies=2


        Cookie addedCookies=new Cookie("drinks","ayran"); //cookie oluşturduk.
        driver.manage().addCookie(addedCookies); //cookie ekledik
        allCookies =driver.manage().getCookies(); //sayfada var olan cookieleri döndürür.
        System.out.println("allcookies:"+allCookies.size());//all cookies=3

        System.out.println("delete cookies");
        driver.manage().deleteCookie(addedCookies); // cookie sildik.
        Assert.assertNull("cookie halen var",driver.manage().getCookieNamed(addedCookies.getName()));
        allCookies =driver.manage().getCookies(); //sayfada var olan cookieleri döndürür.
        System.out.println("allcookies:"+allCookies.size());//2


        driver.manage().deleteAllCookies(); // browser'dan hepsi silinecek.
        allCookies =driver.manage().getCookies(); //sayfada var olan cookieleri döndürür.
        System.out.println("allcookies:"+allCookies.size()); //all cookies= 0

    }
}
