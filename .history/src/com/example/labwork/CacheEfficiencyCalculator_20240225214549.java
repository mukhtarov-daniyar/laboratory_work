package com.example.labwork;

public class CacheEfficiencyCalculator {

    private MainMemory memory;
    private Cache cache;

    public CacheEfficiencyCalculator(int N, int M, int cacheSize) {
        memory = new MainMemory(N, M);
        cache = new Cache(cacheSize);
    }

    public void runAlgorithm(int algorithmNumber) {
        switch (algorithmNumber) {
            case 1:
                algorithm1();
                break;
            case 2:
                algorithm2();
                break;
            case 3:
                algorithm3();
                break;
            default:
                System.out.println("Unknown algorithm number: " + algorithmNumber);
                return;
        }

        // Вывод статистики после выполнения алгоритма
        System.out.println("Algorithm " + algorithmNumber + " statistics:");
        System.out.println("Hits: " + cache.getHits());
        System.out.println("Misses: " + cache.getMisses());
        System.out.println("Total Accesses: " + cache.getTotalAccesses());
    }

    private void algorithm1() {
        int N = memory.getN();
        int M = memory.getM();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Color color = new Color(0, 0, 1, 0); // Специфические значения для алгоритма
                int address = i * M + j;
                memory.setColor(i, j, color);
                cache.accessCache(address, color, true); // Здесь предполагается запись
            }
        }
    }

    private void algorithm2() {
        int N = memory.getN();
        int M = memory.getM();
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                Color color = new Color(0, 0, 1, 0); // Аналогичные значения для алгоритма
                int address = j * N + i; // Изменен порядок индексации
                memory.setColor(i, j, color); // Обратите внимание на измененный порядок индексов
                cache.accessCache(address, color, true); // Запись
            }
        }
    }

    private void algorithm3() {
        int N = memory.getN();
        int M = memory.getM();
        // Первый проход: установка Y
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Color color = memory.getColor(i, j);
                color.y = 1; // Модификация существующего цвета
                int address = i * M + j;
                cache.accessCache(address, color, true); // Обновление Y в кэше
            }
        }
        // Второй проход: установка C, M, K
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Color color = memory.getColor(i, j);
                color.c = 0;
                color.m = 0;
                color.k = 0; // Дополнительная модификация
                int address = i * M + j;
                cache.accessCache(address, color, true); // Запись модифицированного цвета
            }
        }
    }

    public static void main(String[] args) {
        int N = 4; // Пример размера, должен быть задан пользователем или через аргументы командной строки
        int M = 4; // Пример размера
        int cacheSize = 8; // Пример размера кэша
        CacheEfficiencyCalculator calculator = new CacheEfficiencyCalculator(N, M, cacheSize);

        calculator.runAlgorithm(1); // Запуск алгоритма 1
        calculator.runAlgorithm(2); // Запуск алгоритма 2
        calculator.runAlgorithm(3); // Запуск алгоритма 3
    }
}
