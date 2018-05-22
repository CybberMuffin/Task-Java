package ua.kpi.tef.controller.exceptions;

public class InvalidRangeException extends Exception {
    private static String INVALID_RANGE = "Invalid range: ";
    private static String DASH = " – ";
    public InvalidRangeException(Integer lower, Integer upper){
        super(INVALID_RANGE + lower + DASH + upper);
    }
}
