package operations;

import contracts.Executable;
import modules.Data;
import modules.DataType;
import modules.catalogue.Catalogue;
import modules.catalogue.CatalogueData;
import modules.table.Column;
import modules.table.Table;
import modules.table.TableRow;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Count implements Executable {
    private final List<String> arguments;

    public Count(List<String> arguments) {
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        if (Objects.isNull(CatalogueData.getInstance().getFile())) {
            throw new RuntimeException("nqma fail");
        }

        if (arguments.size() != 3) {
            throw new RuntimeException("syntax error: count <table name> <search column n> <search value>");
        }

        Column columnToSearch = Catalogue.getInstance().getTableByName(arguments.get(0)).getColumnById(Integer.parseInt(arguments.get(1)));

        if (!columnToSearch.getDataType().equals(DataType.parse(arguments.get(2)))) {
            throw new RuntimeException("incompatible data types");
        }

        int count = 0;
        for (Map.Entry<TableRow, DataType> entry : columnToSearch.getTableRowMap().entrySet()) {
            if (entry.getKey().getData().equals(arguments.get(2))) {
                count++;
            }
        }

        System.out.println("The number of rows in column " + arguments.get(1) + " with value " + arguments.get(2) + " is " + count);
    }
}
