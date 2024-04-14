package test;

import exceptions.ArrOutOfBoundsException;
import modules.*;
import operations.Open;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException, ArrOutOfBoundsException {
        Table table=new Table("Who");
        Catalogue catalogue = Catalogue.getInstance();
        catalogue.addTable(table);

        table.addColumn("purva kolona", DataType._INT);
        catalogue.export("Who");

        //Scanner scanner=new Scanner(System.in);
        //String a=scanner.nextLine();
        //System.out.println("user input: "+a);



        boolean check=true;
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("Enter an operation to be called: ");
            String method=scanner.nextLine();
            String[] arr =method.split(" ");

            if(arr[0].equals("open")){
                Open.open(arr[1]);
            }else
                MethodCaller.getInstance().callMethod(arr[0]);
        }

        /*check=true;
        while(check){
            String method=scanner.nextLine();
            String[] arr =method.split(" ");

            if(arr[0]=="open"){
                StringBuilder stringBuilder=new StringBuilder();
                for(int i=1;i<arr.length;i++){
                    stringBuilder.append(arr[i]);
                }
                String path=stringBuilder.toString();
                Open.open(path);
            }


            check= OpenExitMethod.getInstance().callMethod(arr[0]);
        }
        System.out.println("GG");

            */

    }
}
