package modules.catalogue;

import modules.DataType;
import modules.table.Table;

import java.util.*;

public class Catalogue {
    private static Catalogue catalogueInstance=new Catalogue();
    private List<Table> list=new ArrayList<>();

    private Catalogue(){
    }

    public static Catalogue getInstance(){
            return catalogueInstance;
    }


    public List<Table> getList() {
        return new ArrayList<>(list);
    }


    public void addTable(Table table){
        list.add(table);
    }

    public void setList(List<Table> list1){
        this.list=list1;
    }


//    public void saveCatalogue() throws IOException {
//        FileWriter fileWriter=new FileWriter(filePath+fileName);
//        for(Table table:list){
//                fileWriter.write(table.toString());
//                fileWriter.write("\n");
//            }
//        fileWriter.close();
//    }

    public boolean tableNameExists(String name){
        for(Table table:list){
            if(table.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean addColumn(String tableName, String columnName, DataType dataType) {
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




//    public void export(String tableName) throws IOException {       //zapisva tablicata v kataloga
//
//        FileWriter fileWriter=new FileWriter(filePath+tableName+".txt");
//            for(Table table:list){
//                if(table.getName().equals(tableName)){
//                    fileWriter.write(table.toString());
//                    fileWriter.write("\n");
//                }
//            }
//            fileWriter.close();
//    }


}
