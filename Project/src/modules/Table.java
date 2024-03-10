package modules;

import java.util.ArrayList;
import java.util.List;


public class Table {
    private List<Column> list=new ArrayList<>();

    public int getLastIndex(){
        return list.getLast().getColumnID();
    }

    public void addColumn(String columnName,DataType dataType){
        list.add(new Column(columnName,getLastIndex()+1,dataType));
    }

    public Table(String name) {
        this.name = name;
    }

    private TableRow tableRow;
    private String name;
    private String fileName;

    public String getName() {
        return name;
    }

    public boolean columnNameExists(String columnName){
        for(Column tableColumn:list){
            if(tableColumn.getColumnName()==columnName){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                '}';
    }
}
