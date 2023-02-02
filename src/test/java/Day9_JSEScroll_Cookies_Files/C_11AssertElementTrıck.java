package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class C_11AssertElementTrıck extends BaseTest {

    @Test
    public void FilesUpload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");

        //Upload edilecek dosyamızı seçiyoruz.
        WebElement upload= driver.findElement(By.xpath("//input[@id='file-upload']"));
        upload.sendKeys("C:\\Users\\serha\\OneDrive\\Belgeler\\AD_Port");


        //Upload butonuna basıyoruz.
        WebElement uploadbutton=driver.findElement(By.xpath("//input[@value='Upload']"));
        uploadbutton.click();


        //Yeniden ımplement edeceğiz.
        //Elementin locator unu özellikle yanlış yazıp durumu nasıl handle ettiğimizi kontrol ediyoruz.
        List<WebElement> uploadedMessageList=driver.findElements(By.tagName("h3"));

        Assert.assertEquals("Upload mesajı görüntülenemedi.",1,uploadedMessageList.size());
        WebElement uploadedMessage=uploadedMessageList.get(0);

        Assert.assertTrue(uploadedMessage.isDisplayed());
        Assert.assertEquals("Mesajın texti istenilen gibi görüntülenemiyor.","File Uploaded!",uploadedMessage.getText());




    }
}
