package Day9_JSEScroll_Cookies_Files;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_FileExist {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir")); // projemizin rootunun yolunu verir.

        String projectRoot =System.getProperty("user.dir"); //bulmak istediğimiz file proje içerisinde olduğundan proje yolunu aldık.

        String filePath="\\src\\test\\java\\resources\\fileExist.jpg"; // bulmak istedğimiz doyanın proje klasöründen sonraki yolunu aldık(copy path from content root)

        filePath = projectRoot + filePath;  //almış olduğumuz 2 yolu birleştirip absolute path'imizi elde ettik.

        System.out.println(Files.exists(Paths.get(filePath))); // dosya var mı yok mu diye bakıyorum true false döndürecek.

        if(Files.exists(Paths.get(filePath))){ // bu path' de bir dosya olup olmadığını doğruladık.kontrol ettik.
            System.out.println("dosya bulundu"); // varsa bulundu yazdırdık
        }
        else{
            System.out.println("dosya bulunumadı"); //yoksa bulunmadı yazdırdık.
        }


    }
}
