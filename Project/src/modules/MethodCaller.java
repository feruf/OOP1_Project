package modules;

import operations.Exit;
import operations.Help;
import operations.Save;

import java.io.IOException;

public class MethodCaller {
    private static MethodCaller methodCallerInstance=new MethodCaller();
    private String method;

    private MethodCaller(){}

    public static MethodCaller getInstance(){
        return methodCallerInstance;
    }

    public boolean callMethod(String method) throws IOException {
        switch(method){
            case "exit":
                Exit.terminate();
                break;

            case "help":
                Help.help();
                break;

            case "save":
                Save.save();
                break;

            case "close":
                return false;

            default:
                break;
        }
        return true;
    }
}
