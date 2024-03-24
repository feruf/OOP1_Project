package modules;

import java.util.ArrayList;
import java.util.List;

public class Column {
    private int columnID;
    private DataType dataType;
    private String columnName;

    private List<TableRow> tableRowList=new ArrayList<>();

    private String parentTableName;

    public Column(String columnName, int columnID, DataType dataType) {
        this.columnName=columnName;
        this.columnID = columnID;
        this.dataType = dataType;
    }

    private Data data;

    public Data getData() {
        return data;
    }

    public int getColumnID() {
        return columnID;
    }

    public String getColumnName() {
        return columnName;
    }

    @Override
    public String toString() {
        return "CollumnNumber = " + columnID + " "+dataType.toString();
    }
}