package modules;

import exceptions.ArrOutOfBoundsException;
import operations.*;

import java.io.IOException;

public class MethodCaller {
    private static MethodCaller methodCallerInstance=new MethodCaller();
    private String method;

    private MethodCaller(){}

    public static MethodCaller getInstance(){
        return methodCallerInstance;
    }

    public boolean callMethod(String method) throws IOException, ArrOutOfBoundsException {
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
                Close.close();
                return false;


            default:
                Invalid.invalidOperation();
                break;
        }
        return true;
    }
}
