package com.example.readexcel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputContentInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class MainActivity extends AppCompatActivity {

    ListView list_excel;

    ArrayList<HashMap<String, String>> list = new ArrayList<>();
    HashMap<String, String> item = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_excel = (ListView)findViewById(R.id.list_excel);

//        readExcel();

//        beauty_list(); // 미용
//        cafe_list(); // 카페
//        circulation_list(); // 유통
//        culture_list(); // 문화
//        cvs_list(); // 편의점
//        education_list(); // 교육
//        etc_list(); // 기타
//        medicine_list(); // 의료
        restaurant_list(); // 음식점

        SimpleAdapter adapter = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2,
                new String[]{"name", "location"},
                new int[]{android.R.id.text1, android.R.id.text2});

        list_excel.setAdapter(adapter);
    }

//    public void beauty_list() {
//        try {
//            // File read
//            InputStream is = getBaseContext().getResources().getAssets().open("Gaya_Test.xls");
//            // Excel file
//            Workbook wb = Workbook.getWorkbook(is);
//
//            // Workbook is not null
//            if (wb != null) {
//                Sheet sheet = wb.getSheet(0);
//                // sheet is not null
//                if (sheet != null) {
//                    int colTotal = sheet.getColumns();
//                    int rowIndexStart = 0;
//                    int rowTotal = sheet.getColumn(colTotal - 1).length;
//
//                    for (int row = rowIndexStart; row < rowTotal; row++) {
//                        String category = sheet.getCell(2, row).getContents();
//
//                        switch (category) {
//                            case "미용" :
//                                String name = sheet.getCell(0, row).getContents();
//                                item.put("name", name);
//                                String location = sheet.getCell(1, row).getContents();
//                                item.put("location", location);
//                                list.add(item);
//
//                                System.out.println(item);
//
//                                item = new HashMap<>();
//                        }
//                    }
//                }
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }catch (BiffException e) {
//            e.printStackTrace();
//        }
//    }
//    public void cafe_list() {
//        try {
//            // File read
//            InputStream is = getBaseContext().getResources().getAssets().open("Gaya_Test.xls");
//            // Excel file
//            Workbook wb = Workbook.getWorkbook(is);
//
//            // Workbook is not null
//            if (wb != null) {
//                Sheet sheet = wb.getSheet(0);
//                // sheet is not null
//                if (sheet != null) {
//                    int colTotal = sheet.getColumns();
//                    int rowIndexStart = 0;
//                    int rowTotal = sheet.getColumn(colTotal - 1).length;
//
//                    for (int row = rowIndexStart; row < rowTotal; row++) {
//                        String category = sheet.getCell(2, row).getContents();
//
//                        switch (category) {
//                            case "카페" :
//                                String name = sheet.getCell(0, row).getContents();
//                                item.put("name", name);
//                                String location = sheet.getCell(1, row).getContents();
//                                item.put("location", location);
//                                list.add(item);
//
//                                System.out.println(item);
//
//                                item = new HashMap<>();
//                        }
//                    }
//                }
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }catch (BiffException e) {
//            e.printStackTrace();
//        }
//    }
//    public void circulation_list() {
//        try {
//            // File read
//            InputStream is = getBaseContext().getResources().getAssets().open("Gaya_Test.xls");
//            // Excel file
//            Workbook wb = Workbook.getWorkbook(is);
//
//            // Workbook is not null
//            if (wb != null) {
//                Sheet sheet = wb.getSheet(0);
//                // sheet is not null
//                if (sheet != null) {
//                    int colTotal = sheet.getColumns();
//                    int rowIndexStart = 0;
//                    int rowTotal = sheet.getColumn(colTotal - 1).length;
//
//                    for (int row = rowIndexStart; row < rowTotal; row++) {
//                        String category = sheet.getCell(2, row).getContents();
//
//                        switch (category) {
//                            case "유통" :
//                                String name = sheet.getCell(0, row).getContents();
//                                item.put("name", name);
//                                String location = sheet.getCell(1, row).getContents();
//                                item.put("location", location);
//                                list.add(item);
//
//                                System.out.println(item);
//
//                                item = new HashMap<>();
//                        }
//                    }
//                }
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }catch (BiffException e) {
//            e.printStackTrace();
//        }
//    }
//    public void culture_list() {
//        try {
//            // File read
//            InputStream is = getBaseContext().getResources().getAssets().open("Gaya_Test.xls");
//            // Excel file
//            Workbook wb = Workbook.getWorkbook(is);
//
//            // Workbook is not null
//            if (wb != null) {
//                Sheet sheet = wb.getSheet(0);
//                // sheet is not null
//                if (sheet != null) {
//                    int colTotal = sheet.getColumns();
//                    int rowIndexStart = 0;
//                    int rowTotal = sheet.getColumn(colTotal - 1).length;
//
//                    for (int row = rowIndexStart; row < rowTotal; row++) {
//                        String category = sheet.getCell(2, row).getContents();
//
//                        switch (category) {
//                            case "문화/취미" :
//                                String name = sheet.getCell(0, row).getContents();
//                                item.put("name", name);
//                                String location = sheet.getCell(1, row).getContents();
//                                item.put("location", location);
//                                list.add(item);
//
//                                System.out.println(item);
//
//                                item = new HashMap<>();
//                        }
//                    }
//                }
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }catch (BiffException e) {
//            e.printStackTrace();
//        }
//    }
//    public void cvs_list() {
//        try {
//            // File read
//            InputStream is = getBaseContext().getResources().getAssets().open("Gaya_Test.xls");
//            // Excel file
//            Workbook wb = Workbook.getWorkbook(is);
//
//            // Workbook is not null
//            if (wb != null) {
//                Sheet sheet = wb.getSheet(0);
//                // sheet is not null
//                if (sheet != null) {
//                    int colTotal = sheet.getColumns();
//                    int rowIndexStart = 0;
//                    int rowTotal = sheet.getColumn(colTotal - 1).length;
//
//                    for (int row = rowIndexStart; row < rowTotal; row++) {
//                        String category = sheet.getCell(2, row).getContents();
//
//                        switch (category) {
//                            case "편의점" :
//                                String name = sheet.getCell(0, row).getContents();
//                                item.put("name", name);
//                                String location = sheet.getCell(1, row).getContents();
//                                item.put("location", location);
//                                list.add(item);
//
//                                System.out.println(item);
//
//                                item = new HashMap<>();
//                        }
//                    }
//                }
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }catch (BiffException e) {
//            e.printStackTrace();
//        }
//    }
//    public void education_list() {
//        try {
//            // File read
//            InputStream is = getBaseContext().getResources().getAssets().open("Gaya_Test.xls");
//            // Excel file
//            Workbook wb = Workbook.getWorkbook(is);
//
//            // Workbook is not null
//            if (wb != null) {
//                Sheet sheet = wb.getSheet(0);
//                // sheet is not null
//                if (sheet != null) {
//                    int colTotal = sheet.getColumns();
//                    int rowIndexStart = 0;
//                    int rowTotal = sheet.getColumn(colTotal - 1).length;
//
//                    for (int row = rowIndexStart; row < rowTotal; row++) {
//                        String category = sheet.getCell(2, row).getContents();
//
//                        switch (category) {
//                            case "교육" :
//                                String name = sheet.getCell(0, row).getContents();
//                                item.put("name", name);
//                                String location = sheet.getCell(1, row).getContents();
//                                item.put("location", location);
//                                list.add(item);
//
//                                System.out.println(item);
//
//                                item = new HashMap<>();
//                        }
//                    }
//                }
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }catch (BiffException e) {
//            e.printStackTrace();
//        }
//    }
//    public void etc_list() {
//        try {
//            // File read
//            InputStream is = getBaseContext().getResources().getAssets().open("Gaya_Test.xls");
//            // Excel file
//            Workbook wb = Workbook.getWorkbook(is);
//
//            // Workbook is not null
//            if (wb != null) {
//                Sheet sheet = wb.getSheet(0);
//                // sheet is not null
//                if (sheet != null) {
//                    int colTotal = sheet.getColumns();
//                    int rowIndexStart = 0;
//                    int rowTotal = sheet.getColumn(colTotal - 1).length;
//
//                    for (int row = rowIndexStart; row < rowTotal; row++) {
//                        String category = sheet.getCell(2, row).getContents();
//
//                        switch (category) {
//                            case "기타" :
//                                String name = sheet.getCell(0, row).getContents();
//                                item.put("name", name);
//                                String location = sheet.getCell(1, row).getContents();
//                                item.put("location", location);
//                                list.add(item);
//
//                                System.out.println(item);
//
//                                item = new HashMap<>();
//                        }
//                    }
//                }
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }catch (BiffException e) {
//            e.printStackTrace();
//        }
//    }
    public void restaurant_list() {
        try {
            // File read
            InputStream is = getBaseContext().getResources().getAssets().open("Gaya_Test.xls");
            // Excel file
            Workbook wb = Workbook.getWorkbook(is);

            // Workbook is not null
            if (wb != null) {
                Sheet sheet = wb.getSheet(0);
                // sheet is not null
                if (sheet != null) {
                    int colTotal = sheet.getColumns();
                    int rowIndexStart = 0;
                    int rowTotal = sheet.getColumn(colTotal - 1).length;

                    for (int row = rowIndexStart; row < rowTotal; row++) {
                        String category = sheet.getCell(2, row).getContents();

                        switch (category) {
                            case "음식점" :
                                String name = sheet.getCell(0, row).getContents();
                                item.put("name", name);
                                String location = sheet.getCell(1, row).getContents();
                                item.put("location", location);
                                list.add(item);

                                System.out.println(item);

                                item = new HashMap<>();
                        }
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }catch (BiffException e) {
            e.printStackTrace();
        }
    }


//        public void readExcel() {
//        try {
//            // File read
//            InputStream is = getBaseContext().getResources().getAssets().open("Gaya_Test.xls");
//            // Excel file
//            Workbook wb = Workbook.getWorkbook(is);
//
//            // Workbook is not null
//            if (wb != null) {
//                Sheet sheet = wb.getSheet(0);
//                // sheet is not null
//                if (sheet != null) {
//                    int colTotal = sheet.getColumns();
//                    int rowIndexStart = 0;
//                    int rowTotal = sheet.getColumn(colTotal - 1).length;
//                    StringBuilder sb;
//                    for (int row = rowIndexStart; row < rowTotal; row++) {
//                        sb = new StringBuilder();
//                        for (int col = 0; col < 1; col++) {
//                            String name = sheet.getCell(0, row).getContents();
//                            item.put("name", name);
//                            String location = sheet.getCell(1, row).getContents();
//                            item.put("location", location);
//                            list.add(item);
//
//                            item = new HashMap<>();
//                        }
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (BiffException e) {
//            e.printStackTrace();
//        }
//    }
}

