package Practice;

import com.github.javafaker.Faker;
import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v102.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class Task_02 extends BaseTest {
    /*
    1-"https://facebook.com" adresine gidin.
    2-"create new accocunt" butonuna basın.
    3-"firstname" giriş kutusuna bir isim yazın.
    4-"surname" giriş kutusuna bir soyisim yazın.
    5-"e-mail" giriş kutusuna bir mail yazın.
    6-"e-mail" onay kutusuna e maili tekrar yazın
    7- bir şifre girin.
    8- tarih için gün seçin
    9-tarih için yıl seçin
    10-cinsiyeti seçin
    11-işaretlediğiniz cinsiyeti seçili diğer cinsiyet kutularının seçili olmadığını doğrulayın.
    12-sayfayı kapatın.
     */
    @Test
    public void task() {
        driver.get("https://facebook.com");
        WebElement accountbutton=driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        accountbutton.click();                      //(BY.linkText("Yeni Hesap Oluştur"); --->> başında "a" olduğu için linktext ile işlem yapılabilir.

        Faker faker=new Faker();
        Actions actions=new Actions(driver);
        WebElement firstname=driver.findElement(By.name("firstname"));
        String email=faker.internet().emailAddress();
        actions.click(firstname)
                .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,30))).sendKeys(Keys.TAB)
                .sendKeys("May").sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1970,2000))).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER)
                .perform();
        WebElement radiobutton= driver.findElement(By.xpath("//input[@value='2']"));
        radiobutton.click(); // erkek seçildi.
        Assert.assertTrue("erkek seçili değil.",radiobutton.isSelected());

        WebElement radıowoman=driver.findElement(By.xpath("//input[@value='1']"));
        WebElement radıospecial=driver.findElement(By.xpath("//input[@value='-1']"));
        Assert.assertFalse("kadın ve ya özel seçili",(radıospecial.isSelected()&&radıowoman.isSelected()));





        //---------------->>>>>>>  2. YOL --------->>>>>>>>>>



        WebElement firstname1=driver.findElement(By.name("firstname"));
        firstname.sendKeys(faker.name().firstName()+Keys.TAB);

        WebElement lastname= driver.findElement(By.name("lastname"));
        lastname.sendKeys(faker.name().lastName()+Keys.TAB);

        WebElement email1=driver.findElement(By.name("reg_email__"));
        email1.sendKeys(faker.internet().emailAddress()+Keys.TAB);

        WebElement password= driver.findElement(By.name("reg_passwd__"));
        password.sendKeys(faker.internet().password()+Keys.TAB);




    }
}
