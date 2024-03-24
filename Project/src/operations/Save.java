package operations;

import modules.Catalogue;

import java.io.IOException;

public class Save {
    public static void save() throws IOException {
        Catalogue.getInstance().saveCatalogue();
    }
}
