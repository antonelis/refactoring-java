package exception;

public class AssertionErrorException extends AssertionError {

    public AssertionErrorException(String expected, String result){
        super("Expected: " + System.lineSeparator()
                + expected + System.lineSeparator()
                + System.lineSeparator() + "Got: " + System.lineSeparator() + result);
    }
}