package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.awt.*;

public class C10_FilesUpload extends BaseTest {
    /*
    1-Go to URL: https://the-internet.herokuapp.com/upload
    2-Find the path of the file that you want to upload.
    3-Click on Upload button.
    4-Verify the upload message.
     */

    @Test
    public void FilesUpload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement upload= driver.findElement(By.xpath("//input[@id='file-upload']"));
        upload.sendKeys("C:\\Users\\serha\\OneDrive\\Belgeler\\AD_Port");

        WebElement uploadbutton=driver.findElement(By.xpath("//input[@value='Upload']"));
        uploadbutton.click();

        WebElement message=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals("File Uploaded!",message.getText());


    }
}
