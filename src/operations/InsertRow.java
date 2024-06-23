package operations;

import contracts.Executable;
import modules.catalogue.Catalogue;
import modules.catalogue.CatalogueData;
import modules.table.Table;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class InsertRow implements Executable {
    private final List<String> arguments;

    public InsertRow(List<String> arguments) {
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        if (Objects.isNull(CatalogueData.getInstance().getFile())) {
            throw new RuntimeException("nqma fail");
        }

        if (arguments.isEmpty()) {
            throw new RuntimeException("syntax error: <table name> <column 1 value> <column 2 value> ... <column n value>");
        }

        if (!Catalogue.getInstance().tableNameExists(arguments.get(0))) {
            throw new RuntimeException("table doesnt exist");
        }

        if (Catalogue.getInstance().getTableByName(arguments.get(0)).getColumnList().isEmpty()) {
            throw new RuntimeException("can't add row to an empty table");
        }

        if (arguments.size() != Catalogue.getInstance().getTableByName(arguments.get(0)).getColumnList().size() + 1) {
            throw new RuntimeException("syntax error: <table name> <column 1 value> <column 2 value> ... <column n value>");
        }

        Catalogue.getInstance().getTableByName(arguments.get(0)).addRow(arguments.subList(1, arguments.size()));
    }

}
