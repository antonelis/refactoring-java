package amount;

import amount.IAmount;
import amount.IBonus;

public class RegularMovieAmount implements IAmount, IBonus {

    @Override
    public double getAmount(int day) {
        if (day > 2) {
            return (day - 2) * 1.5 + 2;
        }
        return 2;
    }

    @Override
    public int bonus(int day) {
        return 1;
    }
}