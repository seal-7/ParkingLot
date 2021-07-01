package mode;

import commands.ExitParkingLotCommandExecutor;
import exception.InvalidCommandException;
import factory.CommandExecutorFactory;
import model.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode {

    public InteractiveMode(CommandExecutorFactory commandExecutorFactory) {
        super(commandExecutorFactory);
    }

    @Override
    public void process() throws InvalidCommandException {
        final BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while(true) {
            final String input;
            try {
                input = reader.readLine();
            } catch (IOException e) {
                throw new InvalidCommandException("Error reading input command.");
            }
            final Command command = new Command(input);
            processCommand(command);
            if (ExitParkingLotCommandExecutor.COMMAND_NAME.equals(command.getCommandName())) {
                break;
            }
        }
    }
}
