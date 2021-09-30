package amount;

public class RegularMovieAmount implements IAmount, IBonus {

    private static final int REGULAR_MOVIE_AMOUNT = 2;
    private static final double DISCOUNT = 1.5;
    private static final int BONUS = 1;

    @Override
    public double getAmount(int day) {
        if (day > 2) {
            return (day - 2) * DISCOUNT + REGULAR_MOVIE_AMOUNT;
        }
        return REGULAR_MOVIE_AMOUNT;
    }

    @Override
    public int bonus(int day) {
        return BONUS;
    }
}