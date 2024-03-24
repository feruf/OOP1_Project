package modules;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Catalogue {
    private static Catalogue catalogueInstance=new Catalogue("CatalogueFile");

    private String fileName;

    private Catalogue(String fileName){
        this.fileName=fileName;
    }

    public static Catalogue getInstance(){
            return catalogueInstance;
    }

    private List<Table> list=new ArrayList<>();


    public void openNewFile(String fileName){
        catalogueInstance=new Catalogue(fileName);
    }


    public void saveCatalogue() throws IOException {
        FileWriter fileWriter=new FileWriter("C:\\Users\\feray\\OneDrive\\Documents\\GitHub\\OOP1_Project\\Project\\src\\files\\"+fileName+".txt");
        for(Table table:list){
                fileWriter.write(table.toString());
                fileWriter.write("\n");
            }
        fileWriter.close();
    }


    public void addTable(Table table){
        list.add(table);
    }


    private boolean tableNameExists(String name){
        for(Table table:list){
            if(table.getName()==name){
                return true;
            }
        }
        return false;
    }

    public boolean insertRow(String tableName){
        if(tableNameExists(tableName)){
            return false;
        }else{
            for(Table table:list){
                if(table.getName().equals(tableName)){
                    table.addRows();
                }
            }
        }


        return true;
    }

    public boolean addColumn(String tableName, String columnName,DataType dataType) {
        if (!tableNameExists(tableName)) {
            return false;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName() == tableName) {
                    if(!list.get(i).columnNameExists(columnName)){
                        list.get(i).addColumn(columnName, dataType);
                    }
                }
            }
        }
        return true;
    }

    public void export(String tableName) throws IOException {           //zapisva tablicata v kataloga
        if(tableNameExists(tableName)){
            FileWriter fileWriter=new FileWriter("C:\\Users\\feray\\OneDrive\\Documents\\GitHub\\OOP1_Project\\Project\\src\\files\\"+fileName+".txt");
            for(Table table:list){
                if(table.getName()==tableName){
                    fileWriter.write(table.toString());
                    fileWriter.write("\n");
                }
            }
            fileWriter.close();
        }
    }
}
