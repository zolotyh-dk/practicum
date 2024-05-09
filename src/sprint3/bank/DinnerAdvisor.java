package sprint3.bank;

public class DinnerAdvisor {

    void getAdvice(double moneyBeforeSalary, int daysBeforeSalary) {
        if (moneyBeforeSalary < 3000) {
            System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
        } else if (moneyBeforeSalary < 10000) {
            if (daysBeforeSalary < 10) {
                System.out.println("Можно заказать пиццу!");
            } else {
                System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
            }
        } else if (moneyBeforeSalary < 30000) {
            if (daysBeforeSalary < 10) {
                System.out.println("Неплохо! Сегодня можно поужинать в кафе.");
            } else {
                System.out.println("Можно заказать пиццу!");
            }
        } else {
            if (daysBeforeSalary < 10) {
                System.out.println("Отлично! Можно сходить в ресторан.");
            } else {
                System.out.println("Неплохо! Сегодня можно поужинать в кафе.");
            }
        }
    }
}