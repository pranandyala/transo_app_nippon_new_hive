package com.transo.nippon.customer.vendor.nein.user.utils;//package com.ezyloads.transo.nippon.shipper.utils;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class JsonParseTest {
//
//    private static List<String> header = new ArrayList<String>();
//    private static List<Row> rows = new ArrayList<Row>();
//    private static Row row = new Row();
//    private static int rowsSize;
//
//    public static List<String> getHeader() {
//        return header;
//    }
//
//    public static List<Row> getRows() {
//        return rows;
//    }
//
//    public static void main(String[] args) {
//
//        try {
//            // 1.read the json file
//            JSONObject jsonObject = readJson();
//
//            //2.iterate json file
//            for (Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext(); ) {
//                String header = (String) iterator.next();
//                short type = getType(jsonObject, header);
//
//                if (type == (short) 0) {
//                    iterateJsonObject(jsonObject, header);
//                } else if (type == (short) 1) {
//                    iteratorJsonArray((JSONArray) jsonObject.get(header), header);
//                    row = getRows().get(rowsSize);
//                } else if (type == (short) 2) {
//                    createHeader(header);
//                    addFieldToRow(String.valueOf(jsonObject.get(header)), header);
//                }
//            }
//
//            createExcelFile();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public static void iterateJsonObject(JSONObject jsonObject, String header) {
//
//        for (Iterator outerIterate = jsonObject.keySet().iterator(); outerIterate.hasNext(); ) {
//
//            String key = (String) outerIterate.next();
//            short type = getType(jsonObject, key);
//            String newHeader = header + "__" + key;
//            if (type == (short) 0) {
//                iterateJsonObject((JSONObject) jsonObject.get(key), newHeader);
//
//            } else if (type == (short) 1) {
//                iteratorJsonArray((JSONArray) jsonObject.get(key), newHeader);
//                if (getRows().size() != 0) {
//                    row = getRows().get(rowsSize);
//                }
//            } else if (type == (short) 2) {
//                createHeader(newHeader);
//                addFieldToRow(String.valueOf(jsonObject.get(key)), key);
//            }
//
//        }
//    }
//
//    public static void iteratorJsonArray(JSONArray jsonArray, String header) {
//        if (jsonArray != null) {
//            int index = 0;
//            for (Iterator iterator = jsonArray.iterator(); iterator.hasNext(); ) {
//
//                List<String> beforeItrFields = new ArrayList<String>();
//                for (String field : row.getField()) {
//                    beforeItrFields.add("");
//                }
//                if (index == 0) {
//                    rowsSize = getRows().size();
//                }
//
//                JSONObject jsonObject = (JSONObject) iterator.next();
//                iterateJsonObject(jsonObject, header);
//
//                if (!getRows().contains(row)) {
//                    getRows().add(row);
//                }
//                reInitializeObj(row);
//                row.setField(beforeItrFields);
//
//                index++;
//            }
//
//        }
//
//    }
//
//    public static void reInitializeObj(Object o) {
//        if (o instanceof Row) {
//            row = null;
//            row = new Row();
//        }
//    }
//
//    //0:jsonObject,1:jsonArray ,2:key/value
//    public static Short getType(JSONObject jsonObject, String key) {
//
//        if (jsonObject.get(key) instanceof JSONObject)
//            return (short) 0;
//        else if (jsonObject.get(key) instanceof JSONArray)
//            return (short) 1;
//        else
//            return (short) 2;
//    }
//
//    public static void createHeader(String key) {
//        if (!getHeader().contains(key))
//            getHeader().add(key);
//    }
//
//    public static void addFieldToRow(String value, String key) {
//        row.addField(value);
//    }
//
//    public static JSONObject readJson() throws IOException, ParseException {
//        String filePath = "E:\\1.json";
//        FileReader reader = new FileReader(filePath);
//
//        JSONParser jsonParser = new JSONParser();
//        return (JSONObject) jsonParser.parse(reader);
//    }
//
//    public static void createExcelFile() throws IOException, IllegalAccessException, InstantiationException {
//        FileOutputStream fileOut = new FileOutputStream("Jira.xls");
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet worksheet = workbook.createSheet("work log");
//        HSSFRow row1 = worksheet.createRow((short) 0);
//        short index = 0;
//
//        //create header
//        for (String header : getHeader()) {
//            HSSFCell cellA1 = row1.createCell(index);
//            cellA1.setCellValue(header);
//            HSSFCellStyle cellStyle = workbook.createCellStyle();
//            cellStyle.setFillForegroundColor(HSSFColor.GOLD.index);
//            cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//            cellA1.setCellStyle(cellStyle);
//            index++;
//        }
//
//        //create rows
//        index = 1;
//        for (Row row : getRows()) {
//            HSSFRow excelRow = worksheet.createRow(index);
//            short flag = 0;
//            for (String field : row.getField()) {
//                HSSFCell cellA1 = excelRow.createCell(flag);
//                cellA1.setCellValue(field);
//                flag++;
//            }
//            index++;
//        }
//
//        workbook.write(fileOut);
//        fileOut.flush();
//        fileOut.close();
//    }
//}