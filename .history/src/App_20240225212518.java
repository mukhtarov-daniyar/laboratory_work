package com.example.labwork;

import com.example.labwork.CacheEfficiencyCalculator;

public class App {
    public static void main(String[] args) throws Exception {
        // Замените эти значения на те, которые вы хотите использовать для тестирования
        int N = 4; // Пример размера, должен быть задан в зависимости от требований
        int M = 4; // Пример размера
        int cacheSize = 8; // Пример размера кэша

        // Создаем экземпляр калькулятора эффективности кэша
        CacheEfficiencyCalculator calculator = new CacheEfficiencyCalculator(N, M, cacheSize);

        // Запускаем алгоритмы и выводим результаты
        System.out.println("Running Algorithm 1");
        calculator.runAlgorithm(1);
        System.out.println("\nRunning Algorithm 2");
        calculator.runAlgorithm(2);
        System.out.println("\nRunning Algorithm 3");
        calculator.runAlgorithm(3);
    }
}
