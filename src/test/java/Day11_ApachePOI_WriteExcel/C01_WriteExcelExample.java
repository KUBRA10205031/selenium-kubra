package Day11_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcelExample {
    /*
    Store the path of the file as string and open the file.
    Open the workbook.
    Open the first worksheet.
    Go to the first row.
    Create a cell on the 3rd column (2nd index) on the first row.
    Write “POPULATION” on that cell.
    Create a cell on the 2nd row 3rd cell(index2), and write data.
    Create a cell on the 3rd row 3rd cell(index2), and write data.
    Create a cell on the 4th row 3rd cell(index2), and write data.
    Write and save the workbook.
    Close the file.
    Close the workbook.
     */
    @Test
    public void writeExcel() throws IOException {

        //Dosyamızın path'ını belirttik
       String path="src\\test\\java\\resources\\excelfile.xlsx";

       //dosyamızı açıyoruz.
        FileInputStream fis=new FileInputStream(path);

        //Dosyamızı bir workbook haline getiriyoruz.
        Workbook workbook= WorkbookFactory.create(fis);

        //Sheet'imizi oluşturduk.
        Sheet sheet2= workbook.getSheetAt(1);

        //ilk satırımıza gittik.
        Row row1= sheet2.getRow(0);

        //ilk satırımızın 3. hücresini oluşturduk.
        Cell row1cell3=row1.createCell(2);

        //Hücremize değer atadık.
        row1cell3.setCellValue("POPULATION");

        sheet2.getRow(1).createCell(2).setCellValue("Rusya'nın populasyonu");
        sheet2.getRow(3).createCell(2).setCellValue("Rusya'nın populasyonu");

        //Excel doyamıza yazma işlemini yapıyoruz.
        FileOutputStream fos=new FileOutputStream(path);

        workbook.write(fos);

        //dosyalarımızı kapattık.
        fis.close();
        fos.close();

        //workbook umuzu kapattık.
        workbook.close();



    }
}
