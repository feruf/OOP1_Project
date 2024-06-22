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

        Catalogue.getInstance().getTableByName(arguments.get(0)).addRow(arguments.subList(1, arguments.size()));
    }

}
