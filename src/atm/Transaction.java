package atm;

public class Transaction {
    private String date;
    private String typeOfTransaction;
    private int sum;
    private String text;
    private int numberUser;
    private String currency;

    public Transaction(String date, String typeOfTransaction, int sum, String currency, String text, int numberUser) {
        this.date = date;
        this.typeOfTransaction = typeOfTransaction;
        this.sum = sum;
        this.currency = currency;
        this.text = text;
        this.numberUser = numberUser;
    }

    public Transaction(String date, String typeOfTransaction, int sum, String currency) {
        this.date = date;
        this.typeOfTransaction = typeOfTransaction;
        this.sum = sum;
        this.currency = currency;
    }

    @Override
    public String toString() {
        if(text == null) {
            return date + typeOfTransaction + sum + currency +"\n";
        } else {
            return date + typeOfTransaction + sum + currency + text + numberUser + "\n";
        }

    }
}
