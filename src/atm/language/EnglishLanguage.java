package atm.language;

public class EnglishLanguage implements Language {

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
        System.out.println("Welcome to the bank\n*******JAVATM*******");
        System.out.println("Выберите язык интерфейса:\nSelect interface language:");
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
        System.out.println("1. Sign in to an existing account.");
        System.out.println("2. Create an account.");
    }

    @Override
    public void textIncorrectChoose() {
        System.err.println("Choose the correct value.");
    }

    @Override
    public void textCheckUser() {
        System.out.println("Enter your card number and pin code:");
    }
    @Override
    public void textDataEnteredIncorrect() {
        System.err.println("Invalid data entered!");
    }

    @Override
    public void textWelcomeUser() {
        System.out.print("Welcome ");
    }

    @Override
    public void textWithdrawMoney() {
        System.out.println("Enter the amount to withdraw.");
    }
    public void textActualBalance() {
        System.out.print("Your balance: ");
    }

    @Override
    public void textEnterNumberAccount() {
        System.out.println("Enter your account number:");
    }

    @Override
    public void textEnterPinCodeAccount() {
        System.out.println("Enter your account pin:");
    }

    @Override
    public void textEnterNameAccount() {
        System.out.println("Enter your name:");
    }

    @Override
    public void textEnterMailAccount() {
        System.out.println("Enter email:");
    }

    @Override
    public void textAccountCreate() {
        System.out.println("Your account has been successfully created.");
    }

    @Override
    public void textWithdrawLimit(int num, String text) {
        System.out.println(String.format("Withdrawal limit exceeded in %s %s", num, text));
    }

    @Override
    public void textNotEnoughMoney() {
        System.err.println("Insufficient funds.");
    }

    @Override
    public void textMenu() {
        System.out.println("Select an operation:");
        System.out.println("1. Check balance.");
        System.out.println("2. Withdraw cash.");
        System.out.println("3. Top up balance.");
        System.out.println("4. Transfer to another account.");
        System.out.println("5. Transaction report.");
        System.out.println("6. My profile.");
        System.out.println("7. Exit");
    }

    @Override
    public void textReplenishmentAmount() {
        System.out.println("Enter the amount to replenish the account.");
    }

    @Override
    public void textIncorrectSum() {
        System.err.println("Incorrect amount.");
    }

    @Override
    public void textLimitAddMoney(int num) {
        System.out.println(String.format("Exceeded the limit of the amount deposited in %s.", num));
    }

    @Override
    public void textEnterAccountNumber() {
        System.out.println("Enter the account number to replenish the balance:");
    }

    @Override
    public void textEnterTransferSum() {
        System.out.println("Enter transfer amount:");
    }

    @Override
    public void textLimitTransfer(int num, String text) {
        System.out.println(String.format("Transfer limit exceeded in %s %s", num, text));
    }

    @Override
    public void textIncorrectTransfer() {
        System.err.println("Incorrect amount to transfer.");
    }

    @Override
    public void textUserProfile() {
        System.out.println("* * * My profile * * *");
    }

    @Override
    public void textName() {
        System.out.print("Name: ");
    }

    @Override
    public void textMail() {
        System.out.print("Mail: ");
    }

    @Override
    public void textEditProfile() {
        System.out.println("1. Edit profile.");
        System.out.println("2. Return to menu.");
    }

    @Override
    public void textEditUser() {
        System.out.println("Edit:");
        System.out.println("1. Name.");
        System.out.println("2. Mail.");
        System.out.println("3. Return.");
    }

    @Override
    public void textYourName() {
        System.out.print("Your name: ");
    }

    @Override
    public void textNewName() {
        System.out.println("Enter a new name: ");
    }

    @Override
    public void textYourMail() {
        System.out.print("Your mail: ");
    }

    @Override
    public void textNewMail() {
        System.out.println("Enter new mail:");
    }

    @Override
    public void textGoodDay() {
        System.out.print("Have a good day ");
    }

    @Override
    public void textTrueNewName() {
        System.out.print("Your name has been successfully changed to: ");
    }

    @Override
    public void textTrueNewMail() {
        System.out.print("Your email has been successfully changed to: ");
    }

    @Override
    public String textWithdrawnFromAccount() {
        return "\nWithdrawn from account: ";
    }

    @Override
    public String textAccountReplenishedWith() {
        return "\nAccount replenished with: ";
    }

    @Override
    public String textTransactionSum() {
        return "\nTransfer for the amount: ";
    }

    @Override
    public String textThisUser() {
        return "\nOn account: ";
    }

    @Override
    public String textCredited() {
        return "\nCredited: ";
    }

    @Override
    public void textCurrencySelection() {
        System.out.println("Select currency:");
        System.out.println("1. RUB");
        System.out.println("2. USD");
        System.out.println("3. EUR");
    }

    @Override
    public void textCardService(int num, String text) {
        System.err.println(String.format("Top up your balance to pay for the card service\nfor the amount: %s%s", num, text));
    }

    @Override
    public void textLowBalance() {
        System.err.println("Critically low balance!");
    }

    @Override
    public void textActionSelection() {
        System.out.println("Do you want to continue working?");
        System.out.println("1. Yes.");
        System.out.println("2. No.");
    }

    @Override
    public void textBlockCard() {
        System.err.println("The card is blocked, contact the bank branch.");
    }

    @Override
    public void textCardNotService() {
        System.err.println("The card is not serviced.");
    }

    @Override
    public void loginAttemptsLeft(int num) {
        System.err.println(String.format("Login attempts left: %s", num));
    }
}
