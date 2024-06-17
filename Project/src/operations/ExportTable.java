package operations;

import modules.catalogue.Catalogue;
import modules.Table;

import java.io.FileWriter;
import java.io.IOException;

public class ExportTable {
    public static void export(String tableName,String fileName) throws IOException {
        FileWriter fileWriter=new FileWriter(Catalogue.getInstance().getFilePath()+fileName);
        for(Table table:Catalogue.getInstance().getList()){
            if(table.getName().equals(tableName)){
                fileWriter.write(table.toString());
                fileWriter.write("\n");
            }
        }
        fileWriter.close();
    }
}
