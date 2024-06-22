package modules;

import contracts.Executable;
import operations.*;

import java.util.List;
import java.util.Map;

public class CommandFactory {
    public Executable getCommand(Command command, List<String> argument){
        return switch (command){
            case OPEN-> new Open(argument);
            case CLOSE -> new Close();
            case EXIT -> new Exit();
            case EXPORT_TABLE -> new ExportTable(argument);         //new
            case HELP -> new Help();
            case SAVE -> new Save();
            case SAVE_AS -> new SaveAs(argument);

            case ADD_COLUMN -> new AddColumn(argument);             //new
            case DESCRIBE_TABLE -> new DescribeTable(argument);     //new
            case IMPORT_TABLE -> new ImportTable(argument);         //new
            case INSERT_ROW -> new InsertRow(argument);             //new
            case SHOW_TABLES -> new ShowTables();                   //new


            //print,select,update,delete,       ,renameEZ,countEZ,     aggregate,innerjoin
        };
    }

}
