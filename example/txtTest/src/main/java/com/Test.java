package com;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author daxue0929
 * @date 2023/8/10
 */

public class Test {
    public static String dest = "/Users/daxue0929/Desktop/test";
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/daxue0929/Desktop/test/原始文件.xlsx");

        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet("Sheet1");
        int lastRowNum = sheet.getLastRowNum()+1;
        for (int i=0;i<lastRowNum ;i++) {
            Cell cell = sheet.getRow(i).getCell(0);
            String content = cell.getStringCellValue();
            int fileName = i+1;
            File target = new File("/Users/daxue0929/Desktop/test/" +fileName  + ".txt");
            if (!target.exists()) {
                target.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(target);
            BufferedOutputStream bw = new BufferedOutputStream(fileOutputStream);

            byte[] outputbyte = content.getBytes();
            bw.write(outputbyte);
            bw.flush();
        }
    }
}


