package ru.academit.shestialtynov.excel_main;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.academit.shestialtynov.excel.Person;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Person ivanov = new Person(30, "Ivanov", "Peter", "+7996584236");
        Person makarova = new Person(28, "Makarova", "Olga", "+7985284236");
        Person sergeev = new Person(35, "Sergeev", "Mikhail", "+799658453");
        Person kim = new Person(31, "Kim", "Igor", "+7996551396");
        Person kuznetsov = new Person(43, "Kuznetsov", "Iliya", "+792385236");

        List<Person> list = new ArrayList<>();
        list.add(ivanov);
        list.add(makarova);
        list.add(sergeev);
        list.add(kim);
        list.add(kuznetsov);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Persons");

        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short)11);
        headerFont.setFontName("Arial");
        headerFont.setBold(true);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.BOTTOM);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);

        Row header = sheet.createRow(1);
        header.setHeightInPoints(25);
        Cell ageHeader = header.createCell(1);
        ageHeader.setCellStyle(headerStyle);
        ageHeader.setCellValue("Age");
        Cell surnameHeader = header.createCell(2);
        surnameHeader.setCellStyle(headerStyle);
        surnameHeader.setCellValue("Surname");
        Cell nameHeader = header.createCell(3);
        nameHeader.setCellStyle(headerStyle);
        nameHeader.setCellValue("Name");
        Cell phoneNumberHeader = header.createCell(4);
        phoneNumberHeader.setCellStyle(headerStyle);
        phoneNumberHeader.setCellValue("Phone Number");

        Font cellFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short)11);
        headerFont.setFontName("Arial");

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(cellFont);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.BOTTOM);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.BOTTOM);

        int i = 2;

        for (Person person : list) {
            Row row = sheet.createRow(i);
            row.setHeightInPoints(20);

            Cell ageCell = row.createCell(1);
            ageCell.setCellStyle(cellStyle);
            ageCell.setCellValue(person.getAge());

            Cell surnameCell = row.createCell(2);
            surnameCell.setCellStyle(cellStyle);
            surnameCell.setCellValue(person.getSurname());

            Cell nameCell = row.createCell(3);
            nameCell.setCellStyle(cellStyle);
            nameCell.setCellValue(person.getName());

            Cell phoneNumberCell = row.createCell(4);
            phoneNumberCell.setCellStyle(cellStyle);
            phoneNumberCell.setCellValue(person.getPhoneNumber());

            i++;
        }

        sheet.autoSizeColumn(1);
        sheet.setColumnWidth(1, sheet.getColumnWidth(1) + (3 * 256));
        sheet.autoSizeColumn(2);
        sheet.setColumnWidth(2, sheet.getColumnWidth(2) + (3 * 256));
        sheet.autoSizeColumn(3);
        sheet.setColumnWidth(3, sheet.getColumnWidth(3) + (3 * 256));
        sheet.autoSizeColumn(4);
        sheet.setColumnWidth(4, sheet.getColumnWidth(4) + (3 * 256));

        try (OutputStream fileOut = new FileOutputStream("persons.xlsx")) {
            workbook.write(fileOut);
        }

        workbook.close();
        System.out.println("Создан Excel файл \"persons.xls\"");
    }
}
