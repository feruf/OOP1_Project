package operations;

import contracts.Executable;
import modules.catalogue.CatalogueData;

import java.io.File;

public class SaveAs implements Executable {
    private String argument;

    public SaveAs(String argument) {
        this.argument = argument;
    }

    @Override
    public void execute() {
        File temp=new File(argument);
        CatalogueData.getInstance().write(temp);
        System.out.println("Successfully saved the catalogue in file "+CatalogueData.getInstance().getFile().getName());
    }
}
