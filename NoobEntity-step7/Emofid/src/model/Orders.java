package model;

public class Orders {

    private String Symbol,Date;
    private int Id;
    private long Amount;
    public Orders(String symbol, int id, String date, long amount) {
        Symbol = symbol;
        Id = id;
        Date = date;
        Amount = amount;
    }

    public String getSymbol() {
        return Symbol;
    }

    public int getId() {
        return Id;
    }

    public String getDate() {
        return Date;
    }

    public long getAmount() {
        return Amount;
    }
}
