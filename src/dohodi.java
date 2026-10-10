import java.util.Scanner;

public class dohodi {
    public static int simplifiedTaxationSystem(int earnings) {
        int tax = earnings * 6 / 100;
        return tax;
    }

    public static int simplifiedTaxationSystemMinus(int earnings, int spendings) {
        int taxMinus = (earnings - spendings) * 15 / 100;
        if (taxMinus >= 0) {
            return taxMinus;
        } else {
            return 0;
        }
    }

    public static int saving(int earnings, int spendings) {
        int tax1 = simplifiedTaxationSystem(earnings);
        int tax2 = simplifiedTaxationSystemMinus(earnings, spendings);
        int economyG;
        if (tax1 < tax2) {
            economyG = tax2 - tax1;
        } else {
            economyG = tax1 - tax2;
        }
        return economyG;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы
        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            String firstInput = scanner.nextLine();
            if ("1".equals(firstInput)) {
                System.out.println("Введите сумму дохода:");
                earnings += scanner.nextInt();
                scanner.nextLine();
            } else if ("2".equals(firstInput)) {
                System.out.println("Введите сумму расхода:");
                spendings += scanner.nextInt();
                ;
                scanner.nextLine();
            } else if ("3".equals(firstInput)) {
                int tax1 = simplifiedTaxationSystem(earnings);
                int tax2 = simplifiedTaxationSystemMinus(earnings, spendings);

                if (tax1 < tax2) {
                    System.out.println("Мы советуем вам УСН доходы");
                    System.out.println("Ваш налог составит:" + tax1 + " рублей");
                    System.out.println("Налог на другой системе:" + tax2 + " рублей");
                    System.out.println("Экономия:" + saving(earnings, spendings) + " рублей");
                } else if (tax1 > tax2) {
                    System.out.println("Вам подойдет УСН доходы минус расходы");
                    System.out.println("Ваш налог составит:" + tax2 + " рублей");
                    System.out.println("Налог на другой системе:" + tax1 + " рублей");
                    System.out.println("Экономия:" + saving(earnings, spendings) + " рублей");
                } else {
                    System.out.println("Можете выбрать любую систему налогообложения");

                }
            }


            if ("end".equals(firstInput)) {
                break;
            }
        }
        System.out.println("Программа завершена");
    }
}
