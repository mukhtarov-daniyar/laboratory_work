import java.util.Scanner; // Импорт класса Scanner для ввода данных пользователя

import com.example.labwork.CacheEfficiencyCalculator; // Импорт класса CacheEfficiencyCalculator из пакета com.example.labwork

// Главный класс приложения
public class App {
    public static void main(String[] args) {
        int N = 4; // Значения по умолчанию для размеров основной памяти
        int M = 4;
        int cacheSize = 8; // Значение по умолчанию для размера кэша

        if (args.length >= 3) {
            // Попытка прочитать значения из аргументов командной строки
            try {
                N = Integer.parseInt(args[0]); // Чтение размера N из аргумента командной строки
                M = Integer.parseInt(args[1]); // Чтение размера M из аргумента командной строки
                cacheSize = Integer.parseInt(args[2]); // Чтение размера кэша из аргумента командной строки
            } catch (NumberFormatException e) {
                System.out.println("Invalid input from command line arguments. Using default values.");
            }
        } else {
            // Запрос значений у пользователя через консоль
            Scanner scanner = new Scanner(System.in); // Создание объекта Scanner для считывания ввода пользователя
            System.out.print("Enter N (size of the main memory, must be a power of 2): ");
            N = scanner.nextInt(); // Чтение размера N от пользователя
            System.out.print("Enter M (size of the main memory, must be a power of 2): ");
            M = scanner.nextInt(); // Чтение размера M от пользователя
            System.out.print("Enter cache size (must be <= N*M/4 and a power of 2): ");
            cacheSize = scanner.nextInt(); // Чтение размера кэша от пользователя
        }

        // Создаем и запускаем калькулятор эффективности кэша с введенными параметрами
        CacheEfficiencyCalculator calculator = new CacheEfficiencyCalculator(N, M, cacheSize);

        // Выводим сообщения о запуске каждого алгоритма
        System.out.println("Running Algorithm 1");
        calculator.runAlgorithm(1); // Запуск алгоритма 1
        System.out.println("\nRunning Algorithm 2");
        calculator.runAlgorithm(2); // Запуск алгоритма 2
        System.out.println("\nRunning Algorithm 3");
        calculator.runAlgorithm(3); // Запуск алгоритма 3
    }
}
