package by.gsu.epamlab;

public class BusinessTrip {
    private final static int RATE = 700;
    private String account;
    private int transport;
    private int days;

    public BusinessTrip() {}

    public BusinessTrip(String account, int transport, int days) {
        this.account = account;
        this.transport = transport;
        this.days = days;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getTransport() {
        return transport;
    }

    public void setTransport(int transport) {
        this.transport = transport;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    // calculating total business trip expenses
    public int getTotal() {
        return transport + RATE * days;
    }

    // printing all fields
    public void show() {
        System.out.printf("rate = %.2f%n" +
                           "account = %s%n" +
                           "transport = %.2f%n" +
                           "days = %d%n" +
                           "total = %.2f%n%n",
                           (double) RATE / 100, account, (double) transport / 100, days, (double) getTotal() / 100);
    }

    @Override
    public String toString() {
        return String.format("%s;%.2f;%d;%.2f", account, (double) transport / 100, days, (double) getTotal() / 100);
    }
}
