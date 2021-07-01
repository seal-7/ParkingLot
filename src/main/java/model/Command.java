package model;

import exception.InvalidCommandException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {
    private final String commandName;
    private final List<String> params;

    public Command(final String input) throws InvalidCommandException {
        final List<String> tokensList = Arrays.stream(input.trim().split(" "))
                .map(String::trim).filter(token -> (token.length() > 0)).collect(Collectors.toList());

        if (tokensList.size() == 0) {
            throw new InvalidCommandException("Invalid command");
        }

        commandName = tokensList.get(0);
        tokensList.remove(0);
        params = tokensList;
    }

    public String getCommandName() {
        return commandName;
    }

    public List<String> getParams() {
        return params;
    }
}
