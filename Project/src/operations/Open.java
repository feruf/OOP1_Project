package operations;

import contracts.Executable;
import modules.catalogue.Catalogue;
import modules.catalogue.CatalogueData;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Open implements Executable {
    private final List<String> arguments;

    public Open(List<String> arguments) {
        this.arguments = arguments;
    }


    @Override
    public void execute() {
        File temp = new File(arguments.get(0));

        if(temp.exists()){
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
