package sprint4.bank;

public class TransactionValidator {
    public final static double MIN_AMOUNT = 1.0;
    public final static double MAX_AMOUNT = 5000.0;

    public static boolean isValidAmount(double amount) {
        if (amount < MIN_AMOUNT) {
            System.out.println("Минимальная сумма перевода: " + MIN_AMOUNT+" р. Попробуйте ещё раз!");
            return false;
        }
        if (amount > MAX_AMOUNT) {
            System.out.println("Максимальная сумма перевода: " + MAX_AMOUNT + " р. Попробуйте ещё раз!");
            return false;
        }
        return true;
    }
}