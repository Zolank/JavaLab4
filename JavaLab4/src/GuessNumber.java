import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            int numberToGuess = 1 + random.nextInt(1000);
            int guess = 0;

            System.out.println("Угадайте число от 1 до 1000:");

            while (guess != numberToGuess) {
                System.out.print("Введите число: ");
                guess = input.nextInt();

                if (guess > numberToGuess) {
                    System.out.println("Слишком большое. Попробуйте снова.");
                } else if (guess < numberToGuess) {
                    System.out.println("Слишком маленькое. Попробуйте снова.");
                } else {
                    System.out.println("Поздравляем! Вы угадали число!");
                }
            }

            System.out.print("Хотите сыграть снова? (да/нет): ");
            String answer = input.next().toLowerCase();
            playAgain = answer.equals("да");
        } while (playAgain);

        System.out.println("Спасибо за игру!");
    }
}
