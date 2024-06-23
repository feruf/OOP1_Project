package modules.table;

import modules.DataType;
import modules.catalogue.Catalogue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//NEDEI
//DA
//ZABRAVQSH
public class Table {
    private List<Column> columnList=new ArrayList<>();
    private String name;
    private File tableFile;


    public Table(String name,File file) {
        this.name = name;
        this.tableFile=file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getTableFile() {
        return tableFile;
    }

    public int lastFreeColumnIndex(){
        return columnList.size();
    }

    public int lastFreeRowIndex() {
        return columnList.get(0).getTableRowMap().size();
    }

    public String getDefaultData(DataType type) {
        return switch(type){
            case _STRING -> "";
            case _DOUBLE -> "0.0";
            case _INT -> "0";
            case _NULL -> "null";
        };
    }

    public void addColumn(String columnName, DataType dataType){
        columnList.add(new Column(columnName,lastFreeColumnIndex(),dataType));
        for (int i = 0; i < lastFreeRowIndex(); i++) {
            columnList.getLast().getTableRowMap().put(new TableRow(i, getDefaultData(dataType)), dataType);
        }
//        for(Map.Entry<TableRow,DataType> tableRow:columnList.getLast().getTableRowMap().entrySet()){
//            switch(tableRow.getValue()){
//                case _STRING -> tableRow.getKey().setData("");
//                case _DOUBLE -> tableRow.getKey().setData("0.0");
//                case _INT -> tableRow.getKey().setData("0");
//                case _NULL -> tableRow.getKey().setData("null");
//            }
//        }
    }

    public void fillColumn(Integer columnId, List<String> data) {
        Column column = columnList.get(columnId);
        int row = 0;
        for (String currentData : data) {
            column.getTableRowMap().put(new TableRow(row++, currentData), column.getDataType());
        }
    }

    public void addRow(List<String> data) {
        if (columnList.size() != data.size()) {
            throw new RuntimeException("Invalid parameters!");
        }

        int lastRow = lastFreeRowIndex();
        for (int i = 0; i < columnList.size(); i++) {
            Column currentColumn = columnList.get(i);
            String currentData = data.get(i);
            switch (currentColumn.getDataType()) {
                case _INT -> {
                    try {
                        Integer temp = Integer.parseInt(currentData);
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid parameters!");
                        return;
                    }
                }
                case _DOUBLE -> {
                    try {
                        Double temp = Double.parseDouble(currentData);
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid parameters!");
                        return;
                    }
                }
                case _STRING -> {
                    if (!currentData.startsWith("\"") && !currentData.endsWith("\"")) {
                        throw new RuntimeException("Invalid parameter format");
                    }
                }
                case _NULL -> {
                    if (!currentData.equalsIgnoreCase("null")) {
                        throw new RuntimeException("Invalid parameters!");
                    }
                }
            }
            currentColumn.getTableRowMap().put(new TableRow(lastRow, currentData), currentColumn.getDataType());
        }
    }


    public boolean columnNameExists(String columnName) {
        for (Column tableColumn : columnList) {
            if (tableColumn.getColumnName().equals(columnName)) {
                return true;
            }
        }
        return false;
    }

    public List<Column> getColumnList() {
        return new ArrayList<>(columnList);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Table \'").append(name).append("\' ");

        for(Column column:columnList){
            stringBuilder.append(column.toString());
        }


        return stringBuilder.toString();
    }

    public Column getColumnById(int columnID){
        for(Column column:columnList){
            if(column.getColumnID()==columnID){
                return column;
            }
        }
        throw new RuntimeException("Column doesn't exist");
    }

    public List<Integer> getRowsByCriteria(int columnId, String value) {
        List<Integer> rowsId = new ArrayList<>();

        for (Column column : columnList) {
            if (column.getColumnID() == columnId) {
                for (Map.Entry<TableRow, DataType> rows : column.getTableRowMap().entrySet()) {
                    if (rows.getKey().getData().equals(value)) {
                        rowsId.add(rows.getKey().getRowID());
                    }
                }
                break;
            }
        }

        return rowsId;
    }
}
