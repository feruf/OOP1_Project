package modules.catalogue;

import contracts.Readable;
import modules.table.TableReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogueReader extends CatalogueFile implements Readable {
    TableReader tableReader = new TableReader();

    public CatalogueReader(File file) {
        super(file);
    }

    @Override
    public void read(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            Catalogue.getInstance().setList(new ArrayList<>());
            while ((line = reader.readLine()) != null) {
                List<String> args = Arrays.stream(line.split("=")).toList();

                File tableFile = new File(args.get(1));
                try {
                    tableReader.read(tableFile);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
