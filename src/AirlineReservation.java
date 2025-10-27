import java.util.Scanner;

public class AirlineReservation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean[] seats = new boolean[10]; // false = свободно
        int choice;

        while (true) {
            System.out.println("\nПожалуйста, введите 1 для бизнес-класса");
            System.out.println("Пожалуйста, введите 2 для эконом-класса");
            System.out.print("Ваш выбор: ");
            choice = input.nextInt();

            if (choice == 1) {
                if (assignSeat(seats, 0, 5)) {
                    System.out.println("Ваше место в бизнес-классе.");
                } else if (hasFreeSeats(seats, 5, 10)) {
                    System.out.print("Бизнес-класс заполнен. Желаете место в эконом-классе? (да/нет): ");
                    if (input.next().equalsIgnoreCase("да")) {
                        assignSeat(seats, 5, 10);
                        System.out.println("Ваше место в эконом-классе.");
                    } else {
                        System.out.println("Следующий рейс отправляется через 3 часа.");
                    }
                } else {
                    System.out.println("Все места заняты. Следующий рейс через 3 часа.");
                }
            } else if (choice == 2) {
                if (assignSeat(seats, 5, 10)) {
                    System.out.println("Ваше место в эконом-классе.");
                } else if (hasFreeSeats(seats, 0, 5)) {
                    System.out.print("Эконом-класс заполнен. Желаете место в бизнес-классе? (да/нет): ");
                    if (input.next().equalsIgnoreCase("да")) {
                        assignSeat(seats, 0, 5);
                        System.out.println("Ваше место в бизнес-классе.");
                    } else {
                        System.out.println("Следующий рейс отправляется через 3 часа.");
                    }
                } else {
                    System.out.println("Все места заняты. Следующий рейс через 3 часа.");
                }
            } else {
                System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
    }

    // Назначение первого свободного места в указанном диапазоне
    private static boolean assignSeat(boolean[] seats, int start, int end) {
        for (int i = start; i < end; i++) {
            if (!seats[i]) {
                seats[i] = true;
                System.out.println("Назначено место № " + (i + 1));
                return true;
            }
        }
        return false;
    }

    // Проверка наличия свободных мест
    private static boolean hasFreeSeats(boolean[] seats, int start, int end) {
        for (int i = start; i < end; i++) {
            if (!seats[i]) return true;
        }
        return false;
    }
}
