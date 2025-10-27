import java.util.Random;

public class DiceSimulation {
    public static void main(String[] args) {
        Random random = new Random();
        int[] sums = new int[13]; // Индексы 2..12 будут использоваться

        int rolls = 36_000_000;

        for (int i = 0; i < rolls; i++) {
            int dice1 = 1 + random.nextInt(6);
            int dice2 = 1 + random.nextInt(6);
            int sum = dice1 + dice2;
            sums[sum]++;
        }

        System.out.println("Сумма\tКоличество\tВероятность (%)");
        for (int i = 2; i <= 12; i++) {
            double percent = (100.0 * sums[i]) / rolls;
            System.out.printf("%d\t%d\t\t%.2f%%%n", i, sums[i], percent);
        }
    }
}
