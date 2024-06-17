package modules.catalogue;

import java.io.File;

public abstract class CatalogueFile {
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public CatalogueFile(File file) {
        this.file = file;
    }
}
