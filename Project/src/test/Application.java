package test;

import exceptions.ArrOutOfBoundsException;
import modules.*;
import operations.CommandInvoker;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException, ArrOutOfBoundsException {
//        Table table=new Table("Who");
//        Catalogue catalogue = Catalogue.getInstance();
//        catalogue.addTable(table);
//
//        table.addColumn("purva kolona", DataType._INT);
//        catalogue.export("Who");

        //Scanner scanner=new Scanner(System.in);
        //String a=scanner.nextLine();
        //System.out.println("user input: "+a);



//        boolean check=true;
//        Scanner scanner=new Scanner(System.in);
//        BooleanWrapper flag=new BooleanWrapper(true);
//        while(true){
//            System.out.println("Enter an operation to be called: ");
//            String method = scanner.nextLine();
//            String[] arr  = method.split(" ");
//
//            if(arr.length>1){
//                MethodCaller.getInstance().callMethod(arr[0],arr[1],flag);
//            }
//            MethodCaller.getInstance().callMethod(arr[0],null,flag);
//        }

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

        System.out.println("Feru's OOP1 database project (c) ALL RIGHTS RESERVED\n");
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("-->");
            String input = scanner.nextLine();
            CommandInvoker.getInstance().run(input);
        } while (true);
    }
}
