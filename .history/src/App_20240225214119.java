

import java.util.Scanner;

import com.example.labwork.CacheEfficiencyCalculator;

public class App {
    public static void main(String[] args) {
        int N = 4; // Значения по умолчанию
        int M = 4;
        int cacheSize = 8;

        if (args.length >= 3) {
            // Попытка прочитать значения из аргументов командной строки
            try {
                N = Integer.parseInt(args[0]);
                M = Integer.parseInt(args[1]);
                cacheSize = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input from command line arguments. Using default values.");
            }
        } else {
            // Запрос значений у пользователя через консоль
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter N (size of the main memory, must be a power of 2): ");
            N = scanner.nextInt();
            System.out.print("Enter M (size of the main memory, must be a power of 2): ");
            M = scanner.nextInt();
            System.out.print("Enter cache size (must be <= N*M/4 and a power of 2): ");
            cacheSize = scanner.nextInt();
        }

        // Создаем и запускаем калькулятор эффективности кэша с введенными параметрами
        CacheEfficiencyCalculator calculator = new CacheEfficiencyCalculator(N, M, cacheSize);

        System.out.println("Running Algorithm 1");
        calculator.runAlgorithm(1); // Запуск алгоритма 1
        System.out.println("\nRunning Algorithm 2");
        calculator.runAlgorithm(2); // Запуск алгоритма 2
        System.out.println("\nRunning Algorithm 3");
        calculator.runAlgorithm(3); // Запуск алгоритма 3
    }
}
