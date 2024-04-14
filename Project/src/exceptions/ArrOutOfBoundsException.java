package exceptions;

public class ArrOutOfBoundsException extends Exception{
    public ArrOutOfBoundsException(String message) {
        super("Invalid file path! \nClosing the program...");
    }
}
