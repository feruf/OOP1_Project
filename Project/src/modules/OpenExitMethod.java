package modules;

import operations.Exit;
import operations.Help;
import operations.Save;

import java.io.IOException;

public class OpenExitMethod {
    public boolean callMethod(String method) throws IOException {
        switch(method){
            case "exit":
                Exit.terminate();
                break;
            case "open":

                break;


            default:
                break;
        }
        return true;
    }
}
