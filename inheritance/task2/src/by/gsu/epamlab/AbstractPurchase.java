package by.gsu.epamlab;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private Commodity commodity;
    private int number;

    public AbstractPurchase() {}

    public AbstractPurchase(Commodity commodity, int number) {
        this.commodity = commodity;
        this.number = number;
    }

    public Commodity getCommodity() { return commodity; }

    public void setCommodity(Commodity commodity) { this.commodity = commodity; }

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    abstract Byn countFinalCost(Byn cost);

    public Byn getCost() {
        Byn cost = new Byn(commodity.getPrice()).mul(getNumber());
        // counting cost and rounding it down to 1.00 BYN
        return countFinalCost(cost).rounding(100, RoundingType.FLOOR);
    }

    protected String fieldsToString() {
        return String.format("%s;%d", commodity, number);
    }

    @Override
    public String toString() {
        return String.format("%s;%s", fieldsToString(), getCost());
    }

    @Override
    public int compareTo(AbstractPurchase purchase) {
        return purchase.getCost().compareTo(getCost());
    }
}
