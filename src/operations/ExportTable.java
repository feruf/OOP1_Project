package operations;

import contracts.Executable;
import modules.catalogue.Catalogue;
import modules.catalogue.CatalogueData;
import modules.table.Table;
import modules.table.TableWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ExportTable implements Executable {
    private final List<String> arguments;

    public ExportTable(List<String> arguments) {
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        if (Objects.isNull(CatalogueData.getInstance().getFile())) {
            throw new RuntimeException("nqma fail");
        }

        if (arguments.size() != 2) {
            throw new RuntimeException("syntax error: export <table name> <file>");
        }

        TableWriter tableWriter = new TableWriter(Catalogue.getInstance().getTableByName(arguments.get(0)));
        tableWriter.write(new File(arguments.get(1)));
    }


//    public static void export(String tableName,String fileName) throws IOException {
//        FileWriter fileWriter=new FileWriter(Catalogue.getInstance().getFilePath()+fileName);
//        for(Table table:Catalogue.getInstance().getList()){
//            if(table.getName().equals(tableName)){
//                fileWriter.write(table.toString());
//                fileWriter.write("\n");
//            }
//        }
//        fileWriter.close();
//    }


}
