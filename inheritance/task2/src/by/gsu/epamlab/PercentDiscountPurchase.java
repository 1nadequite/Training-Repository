package by.gsu.epamlab;

public class PercentDiscountPurchase extends AbstractPurchase {
    public final static int NUMBER_FOR_DISCOUNT = 10;
    private double percent;

    public PercentDiscountPurchase(Commodity commodity, int number, double percent) {
        super(commodity, number);
        this.percent = percent;
    }

    @Override
    public Byn getCost() {
        Byn cost = super.getCost();
        if (getNumber() > NUMBER_FOR_DISCOUNT) {
            cost.mul(1 - percent / 100);
        }
        return cost;
    }

    @Override
    protected String fieldsToString() {
        return String.format("%s;%.3f", super.fieldsToString(), percent);
    }
}
