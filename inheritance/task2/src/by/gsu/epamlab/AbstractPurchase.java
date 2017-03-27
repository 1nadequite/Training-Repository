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

    public Byn getCost() {
        Byn cost =  new Byn(commodity.getPrice());
        return cost.mul(number);
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
