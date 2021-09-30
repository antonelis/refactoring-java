public class AssertionErrorException extends AssertionError {

    public AssertionErrorException(String expected, String result){
        super("Expected: " + System.lineSeparator()
                + String.format(expected) + System.lineSeparator()
                + System.lineSeparator() + "Got: " + System.lineSeparator() + result);
    }
}