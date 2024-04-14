package operations;

import exceptions.ArrOutOfBoundsException;

import java.util.Scanner;

public class Close {
    public static void close() throws ArrOutOfBoundsException {
        String fName;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose either open or exit: ");
        String method = scanner.nextLine();
        String[] arr = method.split(" ");
        switch(arr[0]){
            case "exit":
                Exit.terminate();
                break;

            case "open":
                Open.open(arr[1]);
                break;

            default : {
                Invalid.invalidOperation();
                break;
            }
        }
    }
}
