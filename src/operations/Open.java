package operations;

import contracts.Executable;
import modules.catalogue.Catalogue;
import modules.catalogue.CatalogueData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Open implements Executable {
    private final List<String> arguments;
    private final String DEFAULT_PATH = ".\\src\\files\\";

    public Open(List<String> arguments) {
        this.arguments = arguments;
    }


    @Override
    public void execute() {
        if (Objects.nonNull(CatalogueData.getInstance().getFile())) {
            throw new RuntimeException("A file is already opened!");
        }

        String filePath = (arguments.get(0).contains(File.separator)) ? arguments.get(0) : DEFAULT_PATH.concat(arguments.get(0));
        File temp = new File(filePath);

        if (temp.exists()) {
            CatalogueData.getInstance().read(temp);
        }
        else {
            try {
                temp.createNewFile();
                CatalogueData.getInstance().setFile(temp);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Successfully opened file "+temp.getName());
    }

}
