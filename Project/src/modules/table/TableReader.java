package modules.table;

import contracts.Readable;
import modules.DataType;
import modules.catalogue.Catalogue;

import java.io.*;
import java.util.*;

public class TableReader implements Readable {
    @Override
    public void read(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line, columnName = "";
            int row = -1, column = -1;
            Map<Integer, List<String>> tableMap = new HashMap<>();
            List<String> rowData = new ArrayList<>();
            DataType dataType;
            Table table = null;

            while ((line = reader.readLine()) != null) {
                List<String> args = Arrays.stream(line.split(":")).toList();

                switch (args.get(0)) {
                    case "tableName" -> {
                        if (Catalogue.getInstance().tableNameExists(args.get(1))) {
                            throw new RuntimeException("nevaliden ime tam neshto da");
                        }
                        table = new Table(args.get(1), file);
                    }
                    case "columnName" -> {
                        columnName = args.get(1);
                    }
                    case "column" -> {
                        column = Integer.parseInt(args.get(1));
                    }
                    case "dataType" -> {
                        dataType = DataType.valueOf("_".concat(args.get(1).toUpperCase()));
                        table.addColumn(columnName, dataType);
                    }
                    case "row" -> {
                        row = Integer.parseInt(args.get(1));
                    }
                    case "rowData" -> {
                        rowData.add(args.get(1));
                    }
                    case "=" -> {
                        tableMap.put(column, rowData);
                    }
                }

                for (Map.Entry<Integer, List<String>> entry : tableMap.entrySet()) {
                    table.addRow(entry.getValue());
                }

                Catalogue.getInstance().addTable(table);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("???");
        }
    }
}
