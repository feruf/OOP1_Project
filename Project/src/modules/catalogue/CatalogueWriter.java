package modules.catalogue;

import contracts.Writable;

import java.io.File;

public class CatalogueWriter extends CatalogueFile implements Writable {

    public CatalogueWriter(File file) {
        super(file);
    }

    @Override
    public void write(File file) {

    }
}
