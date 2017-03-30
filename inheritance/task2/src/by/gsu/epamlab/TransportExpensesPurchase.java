package by.gsu.epamlab;

public class TransportExpensesPurchase extends AbstractPurchase {
    private Byn transport;

    public TransportExpensesPurchase(Commodity commodity, int number, int transport) {
        super(commodity, number);
        this.transport = new Byn(transport);
    }

    @Override
    public Byn countFinalCost(Byn cost) {
        return cost.add(transport);
    }

    @Override
    protected String fieldsToString() {
        return String.format("%s;%s", super.fieldsToString(), transport);
    }
}
