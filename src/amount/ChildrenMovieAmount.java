package amount;

public class ChildrenMovieAmount implements IAmount, IBonus {

    private static final double CHILDREN_MOVIE_AMOUNT = 1.5;
    private static final double DISCOUNT = 1.5;
    private static final int BONUS = 1;

    @Override
    public double getAmount(int day) {
        if (day > 3) {
            return (day - 3) * DISCOUNT + CHILDREN_MOVIE_AMOUNT;
        }
        return CHILDREN_MOVIE_AMOUNT;
    }

    @Override
    public int bonus(int day) {
        return BONUS;
    }
}
