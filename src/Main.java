import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
      String expected = expectedString();

      String result = resultString();

      if (!result.equals(expected)) {
            throw new AssertionErrorException(expected, result);
        }

        System.out.println("Success");
    }

  private static String resultString() {
    return new RentalInfo().statement(
                new Customer("C. U. Stomer", Arrays.asList(
                        new MovieRental("F001", 3),
                        new MovieRental("F002", 1))));
  }

  private static String expectedString() {
    return "Rental Record for C. U. Stomer\n\t"
                + "You've Got Mail\t3.5\n\tMatrix\t2.0\n"
                + "Amount owed is 5.5\nYou earned 2 frequent points\n";
  }
}
