package commands;

import model.Command;
import service.ParkingLotService;

public class ExitParkingLotCommandExecutor extends CommandExecutor {

    public static final String COMMAND_NAME = "exit_parking_lot";

    public ExitParkingLotCommandExecutor(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public boolean validate(Command command) {
        return false;
    }

    @Override
    public void execute(Command command) {

    }
}
