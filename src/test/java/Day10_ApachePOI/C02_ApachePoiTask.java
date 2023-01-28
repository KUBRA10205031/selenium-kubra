package Day10_ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C02_ApachePoiTask {
    @Test
            public void apacheTask() throws IOException {

        /*
        Add the excel file on the resources folder.
        Open the file.
        Open the workbook using file input stream.
        Open the first worksheet.
        Go to first row.
        Go to first cell on that first row and print.
        Go to second cell on that first row and print.
        Go to 2nd row first cell and assert if the data equal to Russia.
        Go to 3rd row 2nd cell-chain the row and cell.
        Find the number of used row.
        Print country, area key value pairs as map object.
         */

        String path="src/test/java/resources/excelfile.xlsx";

        // Open the file.
        FileInputStream fis=new FileInputStream(path);

        //Open the workbook using file input stream.
        Workbook workbook= WorkbookFactory.create(fis);

        //Open the first worksheet.
        Sheet sheet1= workbook.getSheetAt(0);

        //Go to first row
        Row row1=sheet1.getRow(0);

        //Go to first cell on that first row and print
        Cell row1cell1=row1.getCell(0);

        //Go to first cell on that first row and print
        System.out.println("row1cell1 = " + row1cell1.toString().toLowerCase()); //country

        //Go to second cell on that first row and print
        Cell row1cell2=row1.getCell(1);
        System.out.println("row1cell2 = " + row1cell2);

        //Go to 2nd row first cell and assert if the data equal to Russia.
        Row row2=sheet1.getRow(1);
        Cell row2cell1=row2.getCell(0);

        Assert.assertEquals("Rusya",row2cell1.toString());

        // Go to 3rd row 2nd cell-chain the row and cell.

        Row row3=sheet1.getRow(2);

        Cell row3cell2=row3.getCell(1);
        System.out.println("row3cell2 = " + row3cell2);

        //  Find the number of used row.
        System.out.println(sheet1.getPhysicalNumberOfRows()); //16--Satır sayısını direkt verir.
        System.out.println(sheet1.getLastRowNum()+1); //15--Son satırın indexini veirir.

         int totalRows=sheet1.getPhysicalNumberOfRows();
        //Print country, area key value pairs as map object.
        Map<String,String>countryAreas=new HashMap<>();

        //Herbir satırdaki datlar map objesine for döngüsüyle ekleniyor.
        for (int row = 0; row < totalRows; row++) {
            String country=sheet1.getRow(row).getCell(0).toString();

            //Herbir satırdaki ülkeyi yazdırıyoruz.
            System.out.println((row+1)+".satır="+country);

            String area=sheet1.getRow(row).getCell(1).toString();
            System.out.println("country="+country+"-Area ="+area);

            //Her bir satırdaki ülke ve yüzölçümü değerlerini mapimizin içine yerleştirdik.
            countryAreas.put(country,area);

        }
        //Mapimizi yazdırıyoruz.
        System.out.println(countryAreas);


    }
}
