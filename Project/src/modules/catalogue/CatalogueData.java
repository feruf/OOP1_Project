package modules.catalogue;

import java.io.File;

public class CatalogueData {
    private File file=new File(".\\src\\files\\CatalogueFile.txt");
    private CatalogueReader reader=new CatalogueReader(file);
    private CatalogueWriter writer=new CatalogueWriter(file);

    private static CatalogueData instance =new CatalogueData();

    private CatalogueData(){
    }

    public static CatalogueData getInstance(){
        return instance;
    }



    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void read(File file1){
        this.file=file1;
        this.reader=new CatalogueReader(file);
        this.writer=new CatalogueWriter(file);
        reader.read(file);
    }

    public void read(){
        if(this.file==null){
            throw new RuntimeException("No file loaded!");
        }

        reader.read(file);
    }

    public void write() {
        if(file==null){
            throw new RuntimeException("No file loaded");
        }
        writer.write(this.file);
    }

    public void write(File file1) {
        if(file1==null){
            throw new RuntimeException("No file loaded");
        }
        writer.write(file1);
    }


}
