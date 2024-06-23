package operations;

import contracts.Executable;
import modules.catalogue.Catalogue;
import modules.catalogue.CatalogueData;

import java.util.List;
import java.util.Objects;

public class Rename implements Executable {
    private final List<String> arguments;

    public Rename(List<String> arguments) {
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        if (Objects.isNull(CatalogueData.getInstance().getFile())) {
            throw new RuntimeException("nqma fail");
        }

        if (arguments.size() != 2) {
            throw new RuntimeException("syntax error: rename <old name> <new name>");
        }

        if (Catalogue.getInstance().tableNameExists(arguments.get(1))) {
            throw new RuntimeException("new table name already exists in catalogue!");
        }

        Catalogue.getInstance().getTableByName(arguments.get(0)).setName(arguments.get(1));
        System.out.println("Successfully changed the name!");
    }
}
