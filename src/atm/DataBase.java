package atm;

import atm.language.Language;

import java.util.ArrayList;
import java.util.Scanner;

public class DataBase {
    private static final ArrayList<Account> accounts; //массив аккаунтов
    private static Scanner scanner;
    private Currency currency;

    static {
        scanner = new Scanner(System.in);
        accounts = new ArrayList<>(); // инициализация
        addAccount();
    }

    private static void addAccount() { // БД аккаунтов
        for (int i = 0; i < 20; i++) {
            accounts.add(new Account(100 + i,  10 + i, (int)(Math.random() * 100000), "User" + i, "java" + 5 * (i + 2) +"@mail.ja"));
        }
    }

    public static void createAccount(Language language) { // создание аккаунтов
        language.textEnterNumberAccount();
        int number = scanner.nextInt();
        language.textEnterPinCodeAccount();
        int pin = scanner.nextInt();
        language.textEnterNameAccount();
        String name = scanner.next();
        language.textEnterMailAccount();
        String mail = scanner.next();
        accounts.add(new Account(number, pin, 0, name, mail));
        language.textAccountCreate();

    }
    public static ArrayList<Account> getAccounts() {
        return accounts;
    }
}
