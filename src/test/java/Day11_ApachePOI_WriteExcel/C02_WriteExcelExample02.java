package Day11_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.*;

public class C02_WriteExcelExample02 {
    /*
    Create an object of File class to open xlsx file.
    Create an object of FileInputStream class to read excel file.
    Create an object of FileInputStream class to read excel file.
    Creating workbook instance that refers to .xlsx file.
    Creating a Sheet object.
    Get all rows in the sheet.
    Create a row object to retrieve row at index 3.
    Create a cell object to enter value in it using cell Index.
    Write the data in excel using output stream.

     */
    @Test
    public void changeExcelData() throws IOException {

        //Dosyamızın pathini aldık.
        String path="src\\test\\java\\resources\\excelData.xlsx";

        //Path'imizin file'ını oluşturduk.
        File file=new File(path);

        //File'ımızı açtık.
        FileInputStream fis=new FileInputStream(file);

        //Worbook.2umuzu oluşturduk.
        Workbook wb = WorkbookFactory.create(fis);

        //Sheet'imizi oluşturduk.
        Sheet İnformationData=wb.getSheet("İnformationData");

        //Total row sayısını bulduk ve yazdırdık.
        int totalRowsUsed=İnformationData.getLastRowNum()-İnformationData.getFirstRowNum();
        System.out.println("totalRowsUsed = " + totalRowsUsed);


        //Yeni bir row oluşturup row içerisindeki celleri de oluşturarak değerlerini atadık.
         Row row5= İnformationData.createRow(4);

         row5.createCell(0).setCellValue("Kübra");
         row5.createCell(1).setCellValue("yılmaz");
         row5.createCell(2).setCellValue("Kübra@hotmail.com");
         row5.createCell(3).setCellValue("5123+");
         row5.createCell(4).setCellValue("+9874");
         row5.createCell(5).setCellValue("+9874");

         //Dosyamıza yazma işlemini gerçekleştirdik.
        FileOutputStream fos=new FileOutputStream(file);

        //Objelerimizi kapattık.
        wb.write(fos);
        fos.close();
        fis.close();
        wb.close();



    }
}
