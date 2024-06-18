package operations;

public enum Command {
    OPEN("open","Opens a new file"),
    CLOSE("close","Closes the current file"),
    EXIT("exit","Terminates the application"),
    EXPORT_TABLE("export","Exports a table into a file"),
    HELP("help","Gives a brief description of all the commands available"),
    SAVE("save","Saves the catalogue into the currently opened file"),
    SAVE_AS("saveas","Saves the catalogue into a specified file");

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
}
