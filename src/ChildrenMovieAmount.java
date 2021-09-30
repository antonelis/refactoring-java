public class ChildrenMovieAmount implements IAmount, IBonus {
    @Override
    public double getAmount(int day) {
        if (day > 3) {
            return (day - 3) * 1.5 + 1.5;
        }
        return 1.5;
    }

    @Override
    public int bonus(int day) {
        return 1;
    }
}
