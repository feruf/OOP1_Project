package operations;

import modules.CommandFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommandInvoker {
    private static CommandInvoker instance = null;
    private CommandFactory factory = new CommandFactory();
    private List<String> args = new ArrayList<>();

    private CommandInvoker() {

    }

    public static CommandInvoker getInstance() {
        if (instance == null) {
            instance = new CommandInvoker();
        }
        return instance;
    }

    public void run(String input) {
        if (input.isBlank() || Objects.isNull(input)) {
            return;
        }
        processInput(input);

        Command command = Command.getCommand(args.get(0));
        args = args.subList(1, args.size());
        factory.getCommand(command, args).execute();
    }

    private void processInput(String input) {
        StringBuilder argsBuilder = new StringBuilder();
        Boolean inQuotes = false;

        args.clear();

        for (Character currentCharacter : input.toCharArray()) {
            if (currentCharacter.equals('\'')) {
                inQuotes = !inQuotes;
                continue;
            }

            if ((currentCharacter.equals(' ') && !inQuotes) && !argsBuilder.isEmpty()) {
                args.add(argsBuilder.toString());
                argsBuilder.setLength(0);
                continue;
            }

            argsBuilder.append(currentCharacter);
        }

        if (argsBuilder.length() != 0) {
            args.add(argsBuilder.toString());
        }
    }
}
