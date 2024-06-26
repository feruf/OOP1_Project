package modules.table;

import modules.Data;
import modules.DataType;


import java.util.*;

public class Column {
    private final int columnID;
    private final DataType dataType;
    private final String columnName;

    private Map<TableRow,DataType> tableRowMap=new HashMap<>();

    private String parentTableName;

    public Column(String columnName, int columnID, DataType dataType) {
        this.columnName=columnName;
        this.columnID = columnID;
        this.dataType = dataType;
    }

    public DataType getDataType() {
        return dataType;
    }

    public int getColumnID() {
        return columnID;
    }

    public String getColumnName() {
        return columnName;
    }

    @Override
    public String toString() {
        return "ColumnNumber = " + columnID + " "+dataType.toString();
    }

    public Map<TableRow, DataType> getTableRowMap() {
        return tableRowMap;
    }

    public void removeRow(TableRow tableRow){
        tableRowMap.remove(tableRow);
    }

    public TableRow getTableRowById(int rowId) {
        for (Map.Entry<TableRow,DataType> rows : tableRowMap.entrySet()) {
            if (rows.getKey().getRowID()==rowId) {
                return rows.getKey();
            }
        }
        throw new RuntimeException("Table row doesn't exist!");
    }
}