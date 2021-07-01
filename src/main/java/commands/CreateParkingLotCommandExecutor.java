package commands;

import model.Command;
import service.ParkingLotService;

public class CreateParkingLotCommandExecutor extends CommandExecutor {

    public static String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(final ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    protected boolean validate(final Command command) {
        return false;
    }

    @Override
    public void execute(final Command command) {
        validate(command);
    }
}
