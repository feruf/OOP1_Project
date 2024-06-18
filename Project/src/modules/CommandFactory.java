package modules;

import contracts.Executable;
import operations.*;

import java.util.Map;

public class CommandFactory {
    public Executable getCommand(Command command, String argument){
        return switch (command){
            case OPEN-> new Open(argument);
            case CLOSE -> new Close();
            case EXIT -> new Exit();
            case EXPORT_TABLE -> null;
            case HELP -> new Help();
            case SAVE -> new Save();
            case SAVE_AS -> new SaveAs(argument);
        };
    }

}
