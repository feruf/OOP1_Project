package operations;

import contracts.Executable;

public class Exit implements Executable {
    @Override
    public void execute(){
        System.out.println("Exiting the program...\n");
        System.exit(0);
    }
}
