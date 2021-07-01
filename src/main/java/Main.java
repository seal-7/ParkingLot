import exception.ParkingLotException;
import factory.CommandExecutorFactory;
import mode.FileMode;
import mode.InteractiveMode;
import service.ParkingLotService;

public class Main {

    public static void main(String[] args) {
        final ParkingLotService parkingLotService = new ParkingLotService();
        try {
            if (args.length == 0) {
                    new InteractiveMode(new CommandExecutorFactory(parkingLotService)).process();
            } else {
                new FileMode(new CommandExecutorFactory(parkingLotService), args[0]).process();
            }
        } catch (ParkingLotException e) {
            handleParkingLotException(e);
        }
    }

    private static void handleParkingLotException(final ParkingLotException e) {
        System.out.println(e.getErrorMessage());
    }
}
