package operations;

import contracts.Executable;

public class Help implements Executable {
    @Override
    public void execute() {
        for (Command command : Command.values()) {
            System.out.printf("%-20s%s\n", command.getSyntax().toUpperCase(), command.getDescription());
        }
    }
}
