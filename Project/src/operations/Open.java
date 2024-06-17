package operations;

import contracts.Executable;
import modules.catalogue.Catalogue;
import modules.catalogue.CatalogueData;

import java.io.File;
import java.io.IOException;

public class Open implements Executable {
    private String argument;

    public Open(String argument) {
        this.argument = argument;
    }


    @Override
    public void execute() {
        File temp=new File(argument);

        if(temp.exists()){
            CatalogueData.getInstance().read(temp);
        }
        else {
            try {
                temp.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Successfully opened file "+temp.getName());
    }

}
