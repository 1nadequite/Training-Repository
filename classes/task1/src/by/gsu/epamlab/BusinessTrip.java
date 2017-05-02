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
        System.out.printf("rate = %s%naccount = %s%ntransport = %s%ndays = %d%ntotal = %s%n%n",
                toString(RATE), account, toString(transport), days, toString(getTotal()));
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s", account, toString(transport), toString(getTotal()));
    }

    public static String toString(int value) {
        return String.format("%d.%d%d", value / 100, value / 10 % 10, value % 10);
    }
}
