package atm;

import java.util.ArrayList;

public class Account {
    private int numberAccount;
    private int pinCode;
    private int balance;
    private String name;
    private String mail;
    private int counter;
    private ArrayList<Transaction> list;

    {
        list = new ArrayList<>();
        counter = 3; //счет неверных пинов
    }

    public void showList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    public void addList(String date, String typeOfTransaction, int sum, String currency) {
        list.add(new Transaction(date, typeOfTransaction, sum, currency));
    }
    public void addListTransaction(String date, String typeOfTransaction, int sum, String currency, String text, int numUser) {
        list.add(new Transaction(date, typeOfTransaction, sum, currency, text, numUser));
    }

    public Account(int numberAccount, int pinCode, int balance, String name, String mail) {
        this.numberAccount = numberAccount;
        this.pinCode = pinCode;
        this.balance = balance;
        this.name = name;
        this.mail = mail;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
