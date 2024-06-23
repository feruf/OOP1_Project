package modules.catalogue;

import contracts.Writable;
import modules.table.Column;
import modules.table.Table;
import modules.table.TableWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CatalogueWriter extends CatalogueFile implements Writable {

    public CatalogueWriter(File file) {
        super(file);
    }

    @Override
    public void write(File file) {
        try {
            for (Table table : Catalogue.getInstance().getList()) {
                TableWriter writer = new TableWriter(table);
                writer.write(table.getTableFile());
            }
            FileWriter fileWriter=new FileWriter(file);
            for(Table table:Catalogue.getInstance().getList()){
                fileWriter.append("tableFile=")
                          .append(table.getTableFile().getPath())
                          .append('\n');
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
