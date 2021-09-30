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
        StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");

        for (MovieRental rental : customer.getRentals()) {
            try {
                double thisAmount = movieCategoryAmount().get(generateMovies().get(rental.getMovieId()).getCategory()).getAmount(rental.getDays());

                //add frequent bonus points
                frequentEnterPoints += movieCategoryBonus().get(generateMovies().get(rental.getMovieId()).getCategory()).bonus(rental.getDays());

                //print figures for this rental
                result.append("\t").append(generateMovies().get(rental.getMovieId()).getTitle()).append("\t").append(thisAmount).append("\n");
                totalAmount = totalAmount + thisAmount;
            } catch (NullPointerException ex) {
                System.out.println("This movie does not exist");
                ex.printStackTrace();
            }
        }
        // add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentEnterPoints).append(" frequent points\n");

        return result.toString();
    }
}
