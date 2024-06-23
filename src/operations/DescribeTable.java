package operations;

import contracts.Executable;
import modules.catalogue.Catalogue;
import modules.catalogue.CatalogueData;
import modules.table.Column;
import modules.table.Table;

import java.util.List;
import java.util.Objects;

public class DescribeTable implements Executable {
    private final List<String> arguments;

    public DescribeTable(List<String> arguments) {
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        if (Objects.isNull(CatalogueData.getInstance().getFile())) {
            throw new RuntimeException("nqma fail");
        }

        if (arguments.size() != 1) {
            throw new RuntimeException("syntax error: describe <table name>");
        }

        if (!Catalogue.getInstance().tableNameExists(arguments.get(0))) {
            throw new RuntimeException("tablicata q nqma");
        }

        StringBuilder tableInfo = new StringBuilder();
        Table foundTable = Catalogue.getInstance().getTableByName(arguments.get(0));
        tableInfo.append("Showing information about all data types in a specific table\n");
        for (Column column : foundTable.getColumnList()) {
            tableInfo.append("Column ")
                    .append(column.getColumnID())
                    .append("\t\tDataType: ")
                    .append(column.getDataType().getType())
                    .append('\n');
        }

        System.out.println(tableInfo);
    }
}
