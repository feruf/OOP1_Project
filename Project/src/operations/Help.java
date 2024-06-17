package operations;

import contracts.Executable;

public class Help implements Executable {
    @Override
    public void execute() {
        System.out.println(Command.OPEN.getSyntax()+" "+Command.OPEN.getDescription());
    }
}
