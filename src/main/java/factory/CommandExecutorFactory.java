package factory;

import commands.CommandExecutor;
import commands.CreateParkingLotCommandExecutor;
import service.ParkingLotService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandExecutorFactory {
    final Map<String, CommandExecutor> commandExecutorMap;

    public CommandExecutorFactory(final ParkingLotService parkingLotService) {
        this.commandExecutorMap = new HashMap<>();
        commandExecutorMap.put(CreateParkingLotCommandExecutor.COMMAND_NAME,
                new CreateParkingLotCommandExecutor(parkingLotService));
    }

    public Optional<CommandExecutor> getCommandExecutor(final String commandName) {
        return Optional.ofNullable(commandExecutorMap.get(commandName));
    }
}
