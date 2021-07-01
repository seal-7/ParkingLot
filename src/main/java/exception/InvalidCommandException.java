package exception;

public class InvalidCommandException extends ParkingLotException {
    public InvalidCommandException(String errorMessage) {
        super(errorMessage);
    }
}
