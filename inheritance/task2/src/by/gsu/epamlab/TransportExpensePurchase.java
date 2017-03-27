package by.gsu.epamlab;

public class TransportExpensePurchase extends AbstractPurchase {
    private Byn transport;

    public TransportExpensePurchase(Commodity commodity, int number, int transport) {
        super(commodity, number);
        this.transport = new Byn(transport);
    }

    @Override
    public Byn getCost() {
        Byn cost = super.getCost();
        return cost.sub(transport);
    }

    @Override
    protected String fieldsToString() {
        return String.format("%s;%s", super.fieldsToString(), transport);
    }
}
