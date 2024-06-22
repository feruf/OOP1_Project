package operations;

import contracts.Executable;
import modules.catalogue.Catalogue;
import modules.catalogue.CatalogueData;
import modules.table.TableReader;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ImportTable implements Executable {
    private final List<String> arguments;

    public ImportTable(List<String> arguments) {
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        if (Objects.isNull(CatalogueData.getInstance().getFile())) {
            throw new RuntimeException("nqma fail");
        }

        if (arguments.size() != 1) {
            throw new RuntimeException("wrong syntax: import <file>");
        }

        File temp = new File(arguments.get(0));
        try {
            BufferedReader reader = new BufferedReader(new FileReader(temp));

            if (!temp.exists()) {
                throw new RuntimeException("File doesn't exist");
            }

            String line = reader.readLine();

            List<String> args = Arrays.stream(line.split(":")).toList();

            if (Catalogue.getInstance().tableNameExists(args.get(1))) {
                throw new RuntimeException("Table name already exists");
            }

            TableReader tableReader = new TableReader();
            tableReader.read(temp);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
