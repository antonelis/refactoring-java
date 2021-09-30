package amount;

import amount.IAmount;
import amount.IBonus;

public class NewMovieAmount implements IAmount, IBonus {
    @Override
    public double getAmount(int day) {
        return day * 3;
    }

    @Override
    public int bonus(int day) {
        if (day > 2) {
            return 2;
        }
        return 1;
    }
}
