package operations;

import contracts.Executable;
import modules.catalogue.Catalogue;
import modules.catalogue.CatalogueData;
import modules.table.Table;

import java.util.Objects;

public class ShowTables implements Executable {
    @Override
    public void execute() {
        if (Objects.isNull(CatalogueData.getInstance().getFile())) {
            throw new RuntimeException("nqma fail");
        }

        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Showing all table names loaded in the catalogue: \n");
        for(Table table: Catalogue.getInstance().getList()){
            stringBuilder.append(table.getName())
                         .append('\n');
        }
        System.out.println(stringBuilder.toString());
    }
}
