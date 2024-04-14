package operations;

import exceptions.ArrOutOfBoundsException;
import modules.Catalogue;

public class Open {
    public static boolean open(String filePath)throws ArrOutOfBoundsException {
        Catalogue.getInstance().openNewFile(filePath);
        return true;
    }
}
