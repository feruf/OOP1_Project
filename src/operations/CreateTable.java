package operations;

import contracts.Executable;
import modules.catalogue.Catalogue;
import modules.catalogue.CatalogueData;
import modules.table.Table;
import modules.table.TableWriter;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class CreateTable implements Executable {
    private final List<String> arguments;
    private final String DEFAULT_PATH = ".\\src\\files\\";

    public CreateTable(List<String> arguments) {
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        if (Objects.isNull(CatalogueData.getInstance().getFile())) {
            throw new RuntimeException("no file opened");
        }

        if (arguments.size() != 2) {
            throw new RuntimeException("syntax error: createtable <table name> <file name>");
        }

        if (Catalogue.getInstance().tableNameExists(arguments.get(0))) {
            throw new RuntimeException("table already exists");
        }

        String fileName = (arguments.get(1).contains(File.separator)) ? arguments.get(1) : DEFAULT_PATH.concat(arguments.get(1));
        File tableFile = new File(fileName);
        Table newTable = new Table(arguments.get(0), tableFile);
        TableWriter writer = new TableWriter(newTable);
        writer.write(tableFile);
        Catalogue.getInstance().addTable(newTable);
    }
}
