package modules;

public class Column {
    private int columnID;
    private DataType dataType;
    private String columnName;

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
}