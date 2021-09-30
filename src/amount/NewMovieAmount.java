package amount;

public class NewMovieAmount implements IAmount, IBonus {

    private static final int NEW_MOVIE_AMOUNT = 3;
    private static final int EXTRA_BONUS = 2;
    private static final int BONUS = 1;

    @Override
    public double getAmount(int day) {
        return day * NEW_MOVIE_AMOUNT;
    }

    @Override
    public int bonus(int day) {
        if (day > 2) {
            return EXTRA_BONUS;
        }
        return BONUS;
    }
}
