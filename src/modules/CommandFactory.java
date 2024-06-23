package modules;

import contracts.Executable;
import operations.*;

import java.util.List;
import java.util.Map;

public class CommandFactory {
    public Executable getCommand(Command command, List<String> arguments){
        return switch (command){
            case OPEN-> new Open(arguments);
            case CLOSE -> new Close();
            case EXIT -> new Exit();
            case EXPORT_TABLE -> new ExportTable(arguments);         //new
            case HELP -> new Help();
            case SAVE -> new Save();
            case SAVE_AS -> new SaveAs(arguments);

            case ADD_COLUMN -> new AddColumn(arguments);             //new
            case DESCRIBE_TABLE -> new DescribeTable(arguments);     //new
            case IMPORT_TABLE -> new ImportTable(arguments);         //new
            case INSERT_ROW -> new InsertRow(arguments);             //new
            case SHOW_TABLES -> new ShowTables();                   //new

            case DELETE -> new Delete(arguments);
            case UPDATE -> new Update(arguments);

            case RENAME -> new Rename(arguments);
            case COUNT -> new Count(arguments);
            case CREATETABLE -> new CreateTable(arguments);


            //print,select
            //
            // aggregate,innerjoin
        };
    }

}
