package exception;

public abstract class ParkingLotException extends Exception {
    private final String errorMessage;

    protected ParkingLotException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
