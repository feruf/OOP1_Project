package test;

import modules.Catalogue;
import modules.DataType;
import modules.Table;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        Table table=new Table("Who");
        Catalogue catalogue = Catalogue.getInstance();
        catalogue.addTable(table);

        table.addColumn("purva kolona", DataType._INT);
        catalogue.export("Who");

        //Scanner scanner=new Scanner(System.in);
        //String a=scanner.nextLine();
        //System.out.println("user input: "+a);

    }
}
