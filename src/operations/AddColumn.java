package operations;

import contracts.Executable;
import modules.DataType;
import modules.catalogue.Catalogue;
import modules.catalogue.CatalogueData;
import modules.table.Table;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class AddColumn implements Executable {
    private final List<String> arguments;

    public AddColumn(List<String> arguments) {
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        if (Objects.isNull(CatalogueData.getInstance().getFile())) {
            throw new RuntimeException("nqma fail");
        }

        if (!Catalogue.getInstance().tableNameExists(arguments.get(0))) {
            throw new RuntimeException("ne e namerena tablica");
        }

        if (arguments.size() != 3) {
            throw new RuntimeException("syntax error: addcolumn <table name> <column name> <column type>");
        }

        DataType type = DataType.getDataType(arguments.get(2));

        Catalogue.getInstance()
                .getTableByName(arguments.get(0))
                .addColumn(arguments.get(1), type);
    }
}
