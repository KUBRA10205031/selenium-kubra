package Day10_ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ExcelMethods {
    public static void main(String[] args) throws IOException {

        //Excel dosyamızın pathini aldık.
        String path="src/test/java/resources/excelfile.xlsx";

        //Dosyamızı açtık.
        FileInputStream fileInputStream=new FileInputStream(path);

        //Açtığımız dosyayı excel workbook'una çevirdik.
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        // workbook' umuzdan sheet'imize geçiş yaptık.
        Sheet sheet1=workbook.getSheetAt(0);

        //Sheet'imizden istediğimiz satırı aldık.Index 0' dan başlar // sheet'imizden rowumuza geçiş yaptık.
        Row row1=sheet1.getRow(0);

        //satırımızdan istedğimiz hücreyi aldık Index 0'dan başlar.// sheetimizden cellimize geçiş yaptık.
        Cell cell1=row1.getCell(0);


        //Hücrelerimizde string operayonları gerçekleştirmek istersek toString() methodunu kullanrak hücreyi Stringe çevirebiliriz.
        System.out.println("cell1 = " + cell1.toString().toLowerCase());


    }
}
