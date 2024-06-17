package modules.catalogue;

import contracts.Readable;

import java.io.File;

public class CatalogueReader extends CatalogueFile implements Readable {

    public CatalogueReader(File file) {
        super(file);
    }

    @Override
    public void read(File file) {
    }
}
