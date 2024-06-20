package modules.table;

import java.util.Objects;

public class TableRow {
    private int rowID;
    private String data;

    public TableRow(int rowID, String data) {
        this.rowID = rowID;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableRow tableRow = (TableRow) o;
        return rowID == tableRow.rowID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowID);
    }

    public int getRowID() {
        return rowID;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
