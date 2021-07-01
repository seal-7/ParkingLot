package commands;

import model.Command;
import service.ParkingLotService;

public abstract class CommandExecutor {

    private final ParkingLotService parkingLotService;

    public CommandExecutor(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    protected abstract boolean validate(final Command command);

    public abstract void execute(final Command command);
}
