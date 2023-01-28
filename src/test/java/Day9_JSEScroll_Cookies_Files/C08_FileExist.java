package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;

public class C08_FileExist {

    @Test
    public void fileExists() {
       // C:\\Users\\serha\\OneDrive\\Desktop\\fileExist.png / C:\Users\serha\OneDrive\Desktop\fileExist.png

        System.out.println(System.getProperty("user.home")); // home yolunun rootunu yazdırdık.

        String homepath= System.getProperty("user.home"); //home yoluna atadık.

        String filepath= "\\OneDrive\\Desktop\\fileExist.png"; // Dosyanın kalan yolunu atadık.

        String fullPath= homepath+ filepath; // home ve dosya yollarını birleştirip full path'i elde ettik.

        //System.out.println(fullPath);

       File image= new File(fullPath) ;// Path 'imizi file ' a çevirdik.

        Assert.assertTrue(image.exists()); //exist methoduyla varolup olmadığını kontrol ettik.



    }

    }

