package atm;

public class Exchange {

    //курс валют
    public static int exchangeRates(Currency currency, int sum) {
        int sumExchange = 0;
        switch (currency) {
            case RUB:
                sumExchange = sum;
                break;
            case USD:
                sumExchange = sum / 95;
                break;
            case EUR:
                sumExchange = sum / 105;
                break;
        }
        return sumExchange;
    }

    public static int checkExchange(Currency currency, int num) {
        int trueBalance = 0;
        switch (currency) {
            case RUB:
                trueBalance = num;
                break;
            case USD:
                trueBalance = num * 95;
                break;
            case EUR:
                trueBalance = num * 105;
                break;
        }
    return trueBalance;
    }

    //называет текущую валюту
    public static void currencyDisplay(Currency currency) {
        switch (currency) {
            case RUB:
                System.out.println(" RUB.");
                break;
            case USD:
                System.out.println(" USD.");
                break;
            case EUR:
                System.out.println(" EUR.");
                break;
        }
    }

    //называет валюту в строке
    public static String currencyDisplayString(Currency currency) {
        String text = "";
        switch (currency) {
            case RUB:
                text = " RUB.";
                break;
            case USD:
                text = " USD.";
                break;
            case EUR:
                text = " EUR.";
                break;
        }
        return text;
    }
}
