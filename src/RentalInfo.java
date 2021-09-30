import java.util.HashMap;

public class RentalInfo {

  public static HashMap<String, Movie> generateMovies() {

    HashMap<String, Movie> movies = new HashMap<>();
    movies.put("F001", new Movie("You've Got Mail", MovieCategory.REGULAR));
    movies.put("F002", new Movie("Matrix", MovieCategory.REGULAR));
    movies.put("F003", new Movie("Cars", MovieCategory.CHILDRENS));
    movies.put("F004", new Movie("Fast & Furious X", MovieCategory.NEW));

    return movies;
  }

  public static HashMap<MovieCategory, IAmount> movieCategoryAmount() {
    HashMap<MovieCategory, IAmount> amountHashMap = new HashMap<>();
    amountHashMap.put(MovieCategory.REGULAR, new RegularMovieAmount());
    amountHashMap.put(MovieCategory.CHILDRENS, new ChildrenMovieAmount());
    amountHashMap.put(MovieCategory.NEW, new NewMovieAmount());

    return amountHashMap;
  }

  public static HashMap<MovieCategory, IBonus> movieCategoryBonus() {
    HashMap<MovieCategory, IBonus> bonusesHashMap = new HashMap<>();
    bonusesHashMap.put(MovieCategory.REGULAR, new RegularMovieAmount());
    bonusesHashMap.put(MovieCategory.CHILDRENS, new ChildrenMovieAmount());
    bonusesHashMap.put(MovieCategory.NEW, new NewMovieAmount());

    return bonusesHashMap;
  }

  public String statement(Customer customer) {

    double totalAmount = 0;
    int frequentEnterPoints = 0;
    String result = "Rental Record for " + customer.getName() + "\n";

    for (MovieRental rental : customer.getRentals()) {

      double thisAmount = movieCategoryAmount().get(generateMovies().get(rental.getMovieId()).getCategory()).getAmount(rental.getDays());

      //add frequent bonus points
      frequentEnterPoints += movieCategoryBonus().get(generateMovies().get(rental.getMovieId()).getCategory()).bonus(rental.getDays());

      //print figures for this rental
      result += "\t" + generateMovies().get(rental.getMovieId()).getTitle() + "\t" + thisAmount + "\n";
      totalAmount = totalAmount + thisAmount;
    }
    // add footer lines
    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentEnterPoints + " frequent points\n";

    return result;
  }
}
