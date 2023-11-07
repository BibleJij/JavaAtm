package atm.language;

public class RussianLanguage implements Language {
    @Override
    public void textVoid() {
        System.out.println("* * * * * * * * * *");
    }

    @Override
    public void textDot() {
        System.out.println(".");
    }

    @Override
    public void textExclamationMark() {
        System.out.println("!");
    }

    @Override
    public void textStart() {
        System.out.println("Вас приветствует банк\n*******JAVATM*******");
        System.out.println("Выберите язык интерфейса:\nChoose interface atm.language:");
        System.out.println("1. Русский.");
        System.out.println("2. English.");
    }

    @Override
    public void textIncorrectChooseLanguage() {
        System.err.println("Выберите из предложенных вариантов:\nChoose from the options:");
        System.out.println("1. Русский.");
        System.out.println("2. English.");
    }

    @Override
    public void textMenuCheckAccount() {
        System.out.println("1. Войти в существующий аккаунт.");
        System.out.println("2. Создать аккаунт.");
    }

    @Override
    public void textIncorrectChoose() {
        System.err.println("Выберите корректное значение.");
    }

    @Override
    public void textCheckUser() {
        System.out.println("Введите номер карты и пин-код:");
    }
    @Override
    public void textDataEnteredIncorrect() {
        System.err.println("Неверно введены данные!");
    }

    @Override
    public void textWelcomeUser() {
        System.out.print("Добро пожаловать ");
    }

    @Override
    public void textWithdrawMoney() {
        System.out.println("Введите сумму для снятия.");
    }
    public void textActualBalance() {
        System.out.print("Ваш баланс: ");
    }

    @Override
    public void textEnterNumberAccount() {
        System.out.println("Введите номер аккаунта.");
    }

    @Override
    public void textEnterPinCodeAccount() {
        System.out.println("Введите пин-код аккаунта");
    }

    @Override
    public void textEnterNameAccount() {
        System.out.println("Введите ваше имя:");
    }

    @Override
    public void textEnterMailAccount() {
        System.out.println("Введите почту:");
    }

    @Override
    public void textAccountCreate() {
        System.out.println("Ваш аккаунт успешно был создан.");
    }

    @Override
    public void textWithdrawLimit(int num, String text) {
        System.err.print("Превышен лимит суммы для снятия в " + num + text);
    }

    @Override
    public void textNotEnoughMoney() {
        System.err.println("Недостаточно средств.");
    }

    @Override
    public void textMenu() {
        System.out.println("Выберите операцию:");
        System.out.println("1. Проверить баланс.");
        System.out.println("2. Снять наличные.");
        System.out.println("3. Пополнить баланс.");
        System.out.println("4. Перевести на другой счет.");
        System.out.println("5. Отчет о транзакциях.");
        System.out.println("6. Мой профиль.");
        System.out.println("7. Выйти");
    }

    @Override
    public void textReplenishmentAmount() {
        System.out.println("Введите сумму для пополнения счета.");
    }

    @Override
    public void textIncorrectSum() {
        System.err.println("Некорректная сумма.");
    }

    @Override
    public void textLimitAddMoney(int num) {
        System.out.print("Превышен лимит внесенной суммы в " + num + ".");
    }

    @Override
    public void textEnterAccountNumber() {
        System.out.println("Введите номер аккаунта для пополнения баланса:");
    }

    @Override
    public void textEnterTransferSum() {
        System.out.println("Введите сумму перевода:");
    }

    @Override
    public void textLimitTransfer(int num, String text) {
        System.out.println("Превышен лимит перевода в " + num + text);
    }

    @Override
    public void textIncorrectTransfer() {
        System.err.println("Некорректная сумма для перевода.");
    }

    @Override
    public void textUserProfile() {
        System.out.println("* * * Мой профиль * * *");
    }

    @Override
    public void textName() {
        System.out.print("Имя: ");
    }

    @Override
    public void textMail() {
        System.out.print("Почта: ");
    }

    @Override
    public void textEditProfile() {
        System.out.println("1. Редактировать профиль.");
        System.out.println("2. Вернуться в меню.");
    }

    @Override
    public void textEditUser() {
        System.out.println("Редактировать:");
        System.out.println("1. Имя.");
        System.out.println("2. Почту.");
        System.out.println("3. Вернуться.");
    }

    @Override
    public void textYourName() {
        System.out.print("Ваше имя: ");
    }

    @Override
    public void textNewName() {
        System.out.println("Введите новое имя: ");
    }

    @Override
    public void textYourMail() {
        System.out.print("Ваша почта: ");
    }

    @Override
    public void textNewMail() {
        System.out.println("Введите новую почту:");
    }

    @Override
    public void textGoodDay() {
        System.out.print("Хорошего дня ");
    }

    @Override
    public void textTrueNewName() {
        System.out.print("Ваше имя было успешно изменено на: ");
    }

    @Override
    public void textTrueNewMail() {
        System.out.print("Ваша почта была успешно изменена на: ");
    }

    @Override
    public String textWithdrawnFromAccount() {
        return "\nСнято со счета: ";
    }

    @Override
    public String textAccountReplenishedWith() {
        return "\nСчет пополнен на: ";
    }

    @Override
    public String textTransactionSum() {
        return "\nПеревод на сумму: ";
    }

    @Override
    public String textThisUser() {
        return "\nНа счет: ";
    }

    @Override
    public String textCredited() {
        return "\nЗачислено: ";
    }

    @Override
    public void textCurrencySelection() {
        System.out.println("Выберите валюту:");
        System.out.println("1. RUB");
        System.out.println("2. USD");
        System.out.println("3. EUR");
    }

    @Override
    public void textCardService(int num, String text) {
        System.err.println("Пополните баланс для оплаты сервиса карты\nна сумму: " + num + text);
    }

    @Override
    public void textLowBalance() {
        System.err.println("Критически низкий баланс!");
    }

    @Override
    public void textActionSelection() {
        System.out.println("Хотите продолжить работу?");
        System.out.println("1. Да.");
        System.out.println("2. Нет.");
    }

    @Override
    public void textBlockCard() {
        System.err.println("Карта заблокирована, обратитесь в отделение банка.");
    }

    @Override
    public void textCardNotService() {
        System.err.println("Карта не обслуживается.");
    }

    @Override
    public void loginAttemptsLeft(int num) {
        System.err.println(String.format("Попыток входа осталось: %s", num));
    }
}
