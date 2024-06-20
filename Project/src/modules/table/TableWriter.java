package modules.table;

import contracts.Writable;
import modules.DataType;
import modules.catalogue.Catalogue;
import operations.Command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class TableWriter implements Writable {
    private final Table table;

    public TableWriter(Table table) {
        this.table = table;
    }

    @Override
    public void write(File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);

            fileWriter.append("tableName:")
                    .append(table.getName())
                    .append('\n');

            for (Column column:table.getColumnList()) {
                fileWriter.append("columnName:")
                        .append(column.getColumnName())
                        .append("\ncolumn:")
                        .append(String.valueOf(column.getColumnID())) //???
                        .append("\ndataType:")
                        .append(column.getDataType().getType())
                        .append('\n');


                for (Map.Entry<TableRow, DataType> row:column.getTableRowMap().entrySet()) {
                    fileWriter.append("row:")
                            .append(String.valueOf(row.getKey().getRowID()))
                            .append("\nrowData:")
                            .append(row.getKey().getData())
                            .append("\n");
                }

                fileWriter.append("=\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
