package operations;

import contracts.Executable;
import modules.catalogue.CatalogueData;

import java.util.Objects;

public class Save implements Executable {
    @Override
    public void execute() {
        if (Objects.isNull(CatalogueData.getInstance().getFile())) {
            throw new RuntimeException("no file opened");
        }

        CatalogueData.getInstance().write();
        System.out.println("Successfully saved the catalogue into the current file");
    }
}
