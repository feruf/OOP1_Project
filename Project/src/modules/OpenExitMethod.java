package modules;

import operations.Exit;
import operations.Help;
import operations.Save;

import java.io.IOException;

public class OpenExitMethod {
    private static OpenExitMethod openExitMethodInstance=new OpenExitMethod();

    private OpenExitMethod(){}

    public static OpenExitMethod getInstance(){
        return openExitMethodInstance;
    }

    public boolean callMethod(String method) throws IOException {
        switch(method){
            case "exit":
                Exit.terminate();
                break;
            default:
                break;
        }
        return true;
    }
}
