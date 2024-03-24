package operations;

import modules.Catalogue;

public class Open {
    public static boolean open(String filePath){
        Catalogue.getInstance().openNewFile(filePath);
        return true;
    }
}
