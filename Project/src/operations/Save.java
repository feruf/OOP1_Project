package operations;

import contracts.Executable;
import modules.catalogue.Catalogue;
import modules.Table;
import modules.catalogue.CatalogueData;

import java.io.FileWriter;
import java.io.IOException;

public class Save implements Executable {
    @Override
    public void execute() {
        CatalogueData.getInstance().write();
        System.out.println("Successfully saved the catalogue into the current file");
    }
}
