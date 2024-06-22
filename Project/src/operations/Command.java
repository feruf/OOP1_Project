package operations;

public enum Command {
    OPEN("open","Opens a new file"),
    CLOSE("close","Closes the current file"),
    EXIT("exit","Terminates the application"),
    EXPORT_TABLE("export","Exports a table into a file"),
    HELP("help","Gives a brief description of all the commands available"),
    SAVE("save","Saves the catalogue into the currently opened file"),
    SAVE_AS("saveas","Saves the catalogue into a specified file"),
    ADD_COLUMN("addcolumn","Adds a column to a specified table"),
    DESCRIBE_TABLE("describe","Gives information about the types of columns in a table"),
    IMPORT_TABLE("import","Imports a table from a file"),
    INSERT_ROW("insert","Inserts a row into a specified table"),
    SHOW_TABLES("showtables","Prints a list with all table names");


    private final String syntax;
    private final String description;

    Command(String syntax, String description) {
        this.syntax = syntax;
        this.description = description;
    }

    public String getSyntax() {
        return syntax;
    }

    public String getDescription() {
        return description;
    }

    public static Command getCommand(String syntax) {
        for (Command command : Command.values()) {
            if (command.syntax.equalsIgnoreCase(syntax)) {
                return command;
            }
        }
        throw new RuntimeException("Invalid command!");
    }
}
