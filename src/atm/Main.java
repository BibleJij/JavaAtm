package atm;

import atm.language.RussianLanguage;

public class Main {
     public static void main(String[] args) {
        // num = 100 + i, pin = 10 + i
        Atm atm = new Atm(new RussianLanguage(), Currency.RUB);
        atm.start();


    }
}
