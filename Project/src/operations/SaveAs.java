package operations;

import contracts.Executable;
import modules.catalogue.CatalogueData;

import java.io.File;
import java.util.List;

public class SaveAs implements Executable {
    private final List<String> arguments;

    public SaveAs(List<String> arguments) {
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        File temp=new File(arguments.get(0));
        CatalogueData.getInstance().write(temp);
        System.out.println("Successfully saved the catalogue in file " + temp.getName());
    }
}
