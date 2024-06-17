package operations;

public enum Command {
    OPEN("open","Opens a new file"),
    CLOSE("close",),
    EXIT,
    EXPORT_TABLE,
    HELP,
    SAVE,
    SAVE_AS;

    private String syntax;
    private String description;

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
