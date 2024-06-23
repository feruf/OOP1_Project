package operations;

import contracts.Executable;
import exceptions.ArrOutOfBoundsException;
import modules.catalogue.Catalogue;
import modules.catalogue.CatalogueData;

import java.util.ArrayList;

public class Close implements Executable {

    @Override
    public void execute() {
        Catalogue.getInstance().setList(null);
        System.out.println("Successfully closed file "+CatalogueData.getInstance().getFile().getName());
        CatalogueData.getInstance().setFile(null);
    }
}

