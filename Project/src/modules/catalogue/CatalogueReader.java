package modules.catalogue;

import contracts.Readable;
import modules.table.TableReader;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CatalogueReader extends CatalogueFile implements Readable {
    TableReader tableReader = new TableReader();

    public CatalogueReader(File file) {
        super(file);
    }

    @Override
    public void read(File file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                List<String> args = Arrays.stream(line.split(":")).toList();

                File tableFile = new File(args.get(1));

                try {
                    tableReader.read(tableFile);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
