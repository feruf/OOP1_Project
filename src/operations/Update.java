package operations;

import contracts.Executable;
import jdk.swing.interop.SwingInterOpUtils;
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

public class Update implements Executable {
    private final List<String> arguments;

    public Update(List<String> arguments) {
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        if (Objects.isNull(CatalogueData.getInstance().getFile())) {
            throw new RuntimeException("nqma fail");
        }

        if (arguments.size() != 4) {
            throw new RuntimeException("syntax error: update <table name> <search column n> <search value> <target column n> <target value>");
        }

        Table tableToUpdate = Catalogue.getInstance().getTableByName(arguments.get(0));
        List<Integer> rowsId = tableToUpdate.getRowsByCriteria(Integer.parseInt(arguments.get(1)), arguments.get(2));
        Column columnToUpdate = tableToUpdate.getColumnById(Integer.parseInt(arguments.get(3)));

        if (!columnToUpdate.getDataType().equals(DataType.parse(arguments.get(4)))) {
            throw new RuntimeException("The given type is not the same as the row type!");
        }

        for (int row : rowsId) {
            for (Map.Entry<TableRow, DataType> entry : columnToUpdate.getTableRowMap().entrySet()) {
                if (entry.getKey().getRowID() == row) {
                    entry.getKey().setData(arguments.get(4));
                }
            }
        }

        System.out.println("Successfully updated the table!");
    }
}
