package atm;


import atm.language.Language;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class Service {
    private static Account actualAccount;
    private static Account transferAccount;
    private static Date date;

    public static int login(Language language, int num, int pin) {
        for (int i = 0; i < DataBase.getAccounts().size(); i++) {
            if (num == DataBase.getAccounts().get(i).getNumberAccount()) {
                if (pin == DataBase.getAccounts().get(i).getPinCode()) {
                    if (DataBase.getAccounts().get(i).getCounter() == 1) {
                        return 3;
                    } else {
                        actualAccount = DataBase.getAccounts().get(i);
                        DataBase.getAccounts().get(i).setCounter(3); //обновление счетчика
                        return 1;
                    }
                } else {
                    if (DataBase.getAccounts().get(i).getCounter() == 1) {
                        return 3;
                    } else {
                        DataBase.getAccounts().get(i).setCounter(DataBase.getAccounts().get(i).getCounter() - 1);
                        language.loginAttemptsLeft(DataBase.getAccounts().get(i).getCounter());
                        return 2;
                    }
                }
            }
        }
       return 4;
    }

    public static Account recipientAccount(int num) throws AccountNotFoundException{
        for (int i = 0; i < DataBase.getAccounts().size(); i++) {
            if (num == DataBase.getAccounts().get(i).getNumberAccount()) {
                transferAccount = DataBase.getAccounts().get(i);
                return transferAccount;
            }
        }
        throw new AccountNotFoundException(String.format("Аккакунт с номером %s не найден", num));
    }

    public static void withdrawMoney(Language language, Currency currency, int sum) {
        date = new Date();
        int limit = 20000;
        if (Exchange.checkExchange(currency, sum) <= actualAccount.getBalance() && Exchange.checkExchange(currency, sum) <= limit) {
            actualAccount.setBalance(actualAccount.getBalance() - Exchange.checkExchange(currency, sum));
            actualAccount.addList(date.toString(), language.textWithdrawnFromAccount(), sum, Exchange.currencyDisplayString(currency));
        } else if (Exchange.checkExchange(currency, sum) > limit){
            language.textWithdrawLimit(Exchange.exchangeRates(currency, sum), Exchange.currencyDisplayString(currency));
        } else if (actualAccount.getBalance() - Exchange.checkExchange(currency, sum) < 200) {
            language.textLowBalance();
        } else {
            language.textNotEnoughMoney();
        }
    }

    public static void addMoney(Language language, Currency currency, int sum) {
        date = new Date();
        int limit = 30000;
        if (sum > 0 && Exchange.checkExchange(currency, sum) <= limit) {
            actualAccount.setBalance(actualAccount.getBalance() + Exchange.checkExchange(currency, sum));
            actualAccount.addList(date.toString(), language.textAccountReplenishedWith(), sum, Exchange.currencyDisplayString(currency));
        } else if (Exchange.checkExchange(currency, sum) > limit){
            language.textLimitAddMoney(limit);
        } else {
            language.textIncorrectSum();
        }
    }

    public static void transferMoney(Language language, Currency currency) {
        Scanner scanner = new Scanner(System.in);
        date = new Date();
        int limit = 30000;
        language.textEnterAccountNumber();
        try {
            recipientAccount(scanner.nextInt());
        } catch (AccountNotFoundException e) {
            throw new RuntimeException(e);
        }
        language.textEnterTransferSum();
        int sum = scanner.nextInt();
        if (sum > 0 && Exchange.checkExchange(currency, sum) <= limit) {
            actualAccount.setBalance(actualAccount.getBalance() - Exchange.checkExchange(currency, sum));
            transferAccount.setBalance(transferAccount.getBalance() + Exchange.checkExchange(currency, sum));
            actualAccount.addListTransaction(date.toString(), language.textTransactionSum(), sum, Exchange.currencyDisplayString(currency), language.textThisUser(), transferAccount.getNumberAccount());
            transferAccount.addList(date.toString(), language.textCredited(), sum, Exchange.currencyDisplayString(currency));
        } else if (Exchange.checkExchange(currency, sum) > limit) {
            language.textLimitTransfer(Exchange.exchangeRates(currency, limit), Exchange.currencyDisplayString(currency));
        } else if (actualAccount.getBalance() - sum < 200) {
            language.textLowBalance();
        } else {
            language.textIncorrectTransfer();
        }
    }

    public static void transactionReport() {
        actualAccount.showList();
    }

    public static void profile(Language language) {
        language.textUserProfile();
        language.textName();
        System.out.println(actualAccount.getName());
        language.textMail();
        System.out.println(actualAccount.getMail());
    }

    public static String name() {
        return new String(actualAccount.getName());
    }

    public static String mail() {
        return new String(actualAccount.getMail());
    }

    public static void rename(String name) {
        actualAccount.setName(name);
    }
    public static void reMail(String mail) {
        actualAccount.setMail(mail);
    }
    public static Account getActualAccount() {
        return actualAccount;
    }

    public static void setActualAccount(Account actualAccount) {
        Service.actualAccount = actualAccount;
    }
}
