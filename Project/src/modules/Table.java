package modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Table {
    private List<Column> columnList=new ArrayList<>();
    private String name;
    private String fileName;


    public Table(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public int lastFreeIndex(){
        return columnList.size();
    }



    public void addColumn(String columnName,DataType dataType){
        columnList.add(new Column(columnName,lastFreeIndex(),dataType));
    }

    public void addRows(){
        System.out.println("Enter row value: ");
        Scanner scanner =new Scanner(System.in);

        for(Column column: columnList){
        }
    }

    public boolean columnNameExists(String columnName){
        for(Column tableColumn:columnList){
            if(tableColumn.getColumnName()==columnName){
                return true;
            }
        }
        return false;
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Table \'").append(name).append("\' ");

        for(Column column:columnList){
            stringBuilder.append(column.toString());
        }


        return stringBuilder.toString();
    }



}
