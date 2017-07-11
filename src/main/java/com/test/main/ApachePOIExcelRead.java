/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.main;

import com.test.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import java.util.ResourceBundle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author 330085
 */
public class ApachePOIExcelRead {
    
    private static final String FILE_NAME_ITEMCATEGORY = "src/main/resources/itemCategory.xlsx";
    private static final String FILE_NAME_ITEMGROUP = "src/main/resources/itemGroup.xlsx";
    private static final String FILE_NAME_ITEMTYPE = "src/main/resources/itemType.xlsx";
    private static ResourceBundle property = ResourceBundle.getBundle("state");
    
    public static void main(String[] args) {

        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME_ITEMTYPE));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            StringBuilder stringBuilder = new StringBuilder();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                String code="";
                //String stateId="";

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
//                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
//                        System.out.print(currentCell.getStringCellValue() + "--"+currentCell.getColumnIndex());
//                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
//                        System.out.print(currentCell.getNumericCellValue() + "--"+currentCell.getColumnIndex());
//                    }
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        if(currentCell.getColumnIndex() == 0)
                            code = currentCell.getStringCellValue();
                        /*else if(currentCell.getColumnIndex() == 1){
                            stateId = (String)property.getObject(currentCell.getStringCellValue());
                        }*/
                    }

                }
                //System.out.println(city+"--"+stateId);
                stringBuilder.append(Util.generateInsertForItemType(code, code));
                stringBuilder.append("\n");
            }
            System.out.println(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
