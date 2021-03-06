package by.gsu.epamlab;

public class PriceDiscountPurchase extends AbstractPurchase {
    private Byn discount;

    public PriceDiscountPurchase(Commodity commodity, int number, int discount) {
        super(commodity, number);
        this.discount = new Byn(discount);
    }

    @Override
    protected Byn countFinalCost(Byn cost) {
        return cost.sub(discount.mul(getNumber()));
    }

    @Override
    protected String fieldsToString() {
        return String.format("%s;%s", super.fieldsToString(), discount);
    }
}
