package utilities;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class ReadDataFromExcel
{
//    public static void main(String[] args) throws IOException
//    {
//        ReadDataFromExcel readData = new ReadDataFromExcel();
//        readData.getDataFromExcel("Login");
//    }


    @DataProvider(name = "ExcelData")
    public String[][] getDataFromExcel(Method m) throws IOException , EncryptedDocumentException
    {
        String excelSheetName = m.getName() ;
        //File file = new File(System.getProperty("user.dir")+"/TestAutomationFramework/src/test/resources/testdata/ExcelData.xlsx");
        FileInputStream fis = new FileInputStream("/Users/kshitiztyagi/Desktop/TestAutomationFramework/src/test/resources/testdata/LoginData.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheet(excelSheetName) ;

        int totalRows = sheetName.getLastRowNum() ;
        System.out.println(totalRows);
        Row rowCell = sheetName.getRow(0);
        //System.out.println(rowCell);
        int totalCols = rowCell.getLastCellNum() ;
        System.out.println(totalCols);

        DataFormatter format = new DataFormatter() ;

        String[][] testData = new String[totalRows][totalCols] ;
        for (int i=1 ; i<=totalRows; i++){
            for (int j=0 ; j<totalCols ; j++){
                testData[i-1][j] =format.formatCellValue(sheetName.getRow(i).getCell(j));
                System.out.println(testData[i-1][j]);
            }
        }
        return testData ;
    }
}
