package operations;

import contracts.Executable;
import modules.catalogue.CatalogueData;

public class Save implements Executable {
    @Override
    public void execute() {
        CatalogueData.getInstance().write();
        System.out.println("Successfully saved the catalogue into the current file");
    }
}
