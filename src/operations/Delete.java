package operations;

import contracts.Executable;
import modules.DataType;
import modules.catalogue.Catalogue;
import modules.catalogue.CatalogueData;
import modules.table.Column;
import modules.table.Table;
import modules.table.TableRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Delete implements Executable {
    private final List<String> arguments;

    public Delete(List<String> arguments) {
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        if (Objects.isNull(CatalogueData.getInstance().getFile())) {
            throw new RuntimeException("nqma fail");
        }

        if (arguments.size() != 3) {
            throw new RuntimeException("syntax error: delete <table name> <search column n> <search value>");
        }

        List<Integer> rowsId = Catalogue.getInstance()
                .getTableByName(arguments.get(0))
                .getRowsByCriteria(Integer.parseInt(arguments.get(1)), arguments.get(2));

        deleteRows(rowsId);
        setNewRowIds();
    }

    private void setNewRowIds() {
        int count = 0;
        for (Column column : Catalogue.getInstance().getTableByName(arguments.get(0)).getColumnList()) {
            for (Map.Entry<TableRow, DataType> rows : column.getTableRowMap().entrySet()) {
                rows.getKey().setRowID(count++);
            }
            count = 0;
        }
    }

    private void deleteRows(List<Integer> rowsId) {
        for (Column column : Catalogue.getInstance().getTableByName(arguments.get(0)).getColumnList()) {
            for (Map.Entry<TableRow, DataType> rows : column.getTableRowMap().entrySet()) {
                for (int row : rowsId) {
                    column.removeRow(column.getTableRowById(row));
                }
            }
        }
    }
}
