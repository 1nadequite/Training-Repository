package by.gsu.epamlab.beans;

public class PricePurchase extends Purchase {
    private Byn discount;

    public PricePurchase(String name, int price, int number, int discount) {
        this(name, price == 0 ? null : new Byn(price), number, new Byn(discount));
    }

    public PricePurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public Byn getDiscount() { return discount; }

    public void setDiscount(Byn discount) { this.discount = discount; }

    @Override
    public Byn getCost() {
        return super.getCost().sub(new Byn(discount).mul(getNumber()));
    }

    @Override
    protected String fieldsToString() {
        return String.format("%s;%s", super.fieldsToString(), discount);
    }
}