package test;

import modules.Catalogue;
import modules.Table;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Table table=new Table("Who");
        Catalogue catalogue=new Catalogue();
        catalogue.addTable(table);

        catalogue.export("Who","Koi");
    }
}
