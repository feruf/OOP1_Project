package modules;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Catalogue {
    private List<Table> list=new ArrayList<>();


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

    public void export(String tableName,String fileName) throws IOException {
        if(tableNameExists(tableName)){
            FileWriter fileWriter=new FileWriter("C:\\Users\\feray\\OneDrive\\Documents\\GitHub\\OOP1_Project\\Project\\src\\files\\"+fileName+".txt");
            for(Table table:list){
                if(table.getName()==tableName){
                    fileWriter.write(table.toString());
                }
            }
            fileWriter.close();
        }
    }
}
