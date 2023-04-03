package it.unicam.cs.pa.chessboardgamespa.api.checkers;

/**
 * @author Tommaso Seresi.
 */
public class IllegalMovementException extends Throwable {
    public IllegalMovementException() {
    }

    public IllegalMovementException(String message) {
        super(message);
    }
}
