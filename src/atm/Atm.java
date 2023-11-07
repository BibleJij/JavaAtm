package atm;

import atm.language.EnglishLanguage;
import atm.language.Language;
import atm.language.RussianLanguage;

import java.util.Scanner;

public class Atm {
    private Scanner scanner;
    private Language language;
    private Currency currency;

    public Atm(Language language, Currency currency) {
        this.language = language;
        this.currency = currency;
        scanner = new Scanner(System.in);
    }

    //ввод числа
    private int choose() {
        return scanner.nextInt();
    }

    //ввод строки
    private String chooseString() {
        return scanner.next();
    }

    public void start() {
        language.textStart();
        checkLanguage(choose());
    }

    //таймер
//    public void timeOutTask() {
//        if (timer != null) {
//            timer.cancel();
//        }
//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            int i = 5000;
//            @Override
//            public void run() {
//                i--;
//                if (i < 0) {
//                    timer.cancel();
//                    scanner.close();
//                    scanner = new Scanner(System.in);
//                    start();
//                }
//            }
//        }, 0, 1000);
//    }

    //меняет текущую валюту В АТМ
    public void currencySelection() {
        Scanner scanner = new Scanner(System.in);
        language.textCurrencySelection();
        switch (scanner.nextInt()) {
            case 1:
                currency = Currency.RUB;
                break;
            case 2:
                currency = Currency.USD;
                break;
            case 3:
                currency = Currency.EUR;
                break;
            default:
                language.textIncorrectChoose();
                currencySelection();
        }
    }

    private void checkLanguage(int num) {
        switch (num) {
            case 1:
                language = new RussianLanguage();
                currency = Currency.RUB;
                checkAccount();
                break;
            case 2:
                language = new EnglishLanguage();
                currency = Currency.USD;
                checkAccount();
                break;
            default:
                language.textIncorrectChooseLanguage();
                checkLanguage(choose());
        }
    }

    private void checkAccount() {
        language.textMenuCheckAccount();
        switch (choose()) {
            case 1:
                checkUser();
                break;
            case 2:
                DataBase.createAccount(language);
                checkAccount();
                break;
            default:
                language.textIncorrectChoose();
                checkAccount();
        }
    }

    private void checkUser() {
        language.textCheckUser();
        switch (Service.login(language, choose(), choose())) {
            case 1:
                language.textWelcomeUser(); //данные введен верно
                System.out.print(Service.name());
                language.textExclamationMark();
                menu();
                break;
            case 2:
                language.textDataEnteredIncorrect(); //неверно введен pin
                checkUser();
                break;
            case 3:
                language.textBlockCard(); //исчерпан лимит попыток
                start();
                break;
            case 4:
                language.textCardNotService(); //неверно введены данные
                checkUser();
                break;
        }
    }

    private void menu() {
        if(Service.getActualAccount().getBalance() < 300) {
            language.textCardService(Exchange.exchangeRates(currency, 300), Exchange.currencyDisplayString(currency));
        }
        language.textMenu();
        chooseMenu(choose());
    }

    private void chooseMenu(int num) {
        switch (num) {
            case 1:
                currencySelection();
                language.textActualBalance();
                System.out.print(Exchange.exchangeRates(currency, Service.getActualAccount().getBalance()));
                Exchange.currencyDisplay(currency);
                actionSelection(language);
                break;
            case 2:
                currencySelection();
                language.textWithdrawMoney();
                Service.withdrawMoney(language, currency, choose());
                language.textActualBalance();
                System.out.print(Exchange.exchangeRates(currency, Service.getActualAccount().getBalance()));
                Exchange.currencyDisplay(currency);
                actionSelection(language);
                break;
            case 3:
                currencySelection();
                language.textReplenishmentAmount();
                Service.addMoney(language, currency, choose());
                language.textActualBalance();
                System.out.print(Exchange.exchangeRates(currency, Service.getActualAccount().getBalance()));
                Exchange.currencyDisplay(currency);
                actionSelection(language);
                break;
            case 4:
                currencySelection();
                Service.transferMoney(language, currency);
                actionSelection(language);
                break;
            case 5:
                Service.transactionReport();
                break;
            case 6:
                Service.profile(language);
                language.textEditProfile();
                int x = choose();
                switch (x) {
                    case 1:
                        editProfile();
                    case 2:
                        menu();
                    default:
                        language.textIncorrectChoose();
                }
                break;
            case 7:
                language.textGoodDay();
                System.out.print(Service.name());
                language.textExclamationMark();
                language.textVoid();
                Service.setActualAccount(null);
                start();
                break;
            default:
                language.textIncorrectChoose();
        }
        menu();
    }

    private void editProfile() {
        language.textEditUser();
        int number = choose();
        switch (number) {
            case 1:
                language.textYourName();
                System.out.println(Service.name());
                language.textNewName();
                Service.rename(chooseString());
                language.textTrueNewName();
                System.out.println(Service.name());
                language.textVoid();
                break;
            case 2:
                language.textYourMail();
                System.out.println(Service.mail());
                language.textNewMail();
                Service.reMail(chooseString());
                language.textTrueNewMail();
                System.out.println(Service.mail());
                language.textVoid();
            case 3:
                menu();
            default:
                language.textIncorrectChoose();
                editProfile();
        }
    }
    private void actionSelection(Language language) {
        language.textActionSelection();
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                menu();
                break;
            case 2:
                start();
                break;
        }
    }
}
