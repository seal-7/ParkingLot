package mode;

import commands.CommandExecutor;
import exception.InvalidCommandException;
import exception.ParkingLotException;
import factory.CommandExecutorFactory;
import model.Command;

import java.io.IOException;
import java.util.Optional;

public abstract class Mode {
        private final CommandExecutorFactory commandExecutorFactory;

    protected Mode(CommandExecutorFactory commandExecutorFactory) {
        this.commandExecutorFactory = commandExecutorFactory;
    }

    public abstract void process() throws ParkingLotException;

    protected void processCommand(final Command command) throws InvalidCommandException {
        final Optional<CommandExecutor> optionalCommandExecutor = commandExecutorFactory.getCommandExecutor(command.getCommandName());
        if (optionalCommandExecutor.isEmpty()) {
            throw new InvalidCommandException("No such command present");
        }
        optionalCommandExecutor.get().execute(command);
    }
}
