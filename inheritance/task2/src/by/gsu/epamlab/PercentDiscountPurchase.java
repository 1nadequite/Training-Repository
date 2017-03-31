package by.gsu.epamlab;

public class PercentDiscountPurchase extends AbstractPurchase {
    private final static int NUMBER_FOR_DISCOUNT = 5;
    private double percent;

    public PercentDiscountPurchase(Commodity commodity, int number, double percent) {
        super(commodity, number);
        this.percent = percent;
    }

    @Override
    protected Byn countFinalCost(Byn cost) {
        if (getNumber() > NUMBER_FOR_DISCOUNT) {
            cost.mul(1 - percent / 100, RoundingType.ROUND);
        }
        return cost;
    }

    @Override
    protected String fieldsToString() {
        return String.format("%s;%.3f", super.fieldsToString(), percent);
    }
}
