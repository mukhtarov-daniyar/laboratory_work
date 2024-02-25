package com.example.labwork;

public class CacheEfficiencyCalculator {

    private MainMemory memory; // Объект для представления основной памяти
    private Cache cache; // Объект для представления кэша

    // Конструктор класса, принимающий размеры основной памяти и кэша
    public CacheEfficiencyCalculator(int N, int M, int cacheSize) {
        memory = new MainMemory(N, M); // Создание объекта основной памяти
        cache = new Cache(cacheSize); // Создание объекта кэша
    }

    // Метод для запуска алгоритма на основе его номера
    public void runAlgorithm(int algorithmNumber) {
        switch (algorithmNumber) {
            case 1:
                algorithm1(); // Выполнение алгоритма 1
                break;
            case 2:
                algorithm2(); // Выполнение алгоритма 2
                break;
            case 3:
                algorithm3(); // Выполнение алгоритма 3
                break;
            default:
                System.out.println("Unknown algorithm number: " + algorithmNumber); // Вывод сообщения об ошибке, если номер алгоритма некорректен
                return;
        }

        // Вывод статистики после выполнения алгоритма
        System.out.println("Algorithm " + algorithmNumber + " statistics:");
        System.out.println("Hits: " + cache.getHits());
        System.out.println("Misses: " + cache.getMisses());
        System.out.println("Total Accesses: " + cache.getTotalAccesses());
    }

    // Алгоритм 1
    private void algorithm1() {
        int N = memory.getN();
        int M = memory.getM();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Color color = new Color(0, 0, 1, 0); // Создание объекта цвета с заданными значениями
                int address = i * M + j; // Вычисление адреса в основной памяти
                memory.setColor(i, j, color); // Установка цвета в основной памяти
                cache.accessCache(address, color, true); // Доступ к кэшу (запись)
            }
        }
    }

    // Алгоритм 2
    private void algorithm2() {
        int N = memory.getN();
        int M = memory.getM();
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                Color color = new Color(0, 0, 1, 0); // Создание объекта цвета с заданными значениями
                int address = j * N + i; // Вычисление адреса в основной памяти (изменен порядок индексации)
                memory.setColor(i, j, color); // Установка цвета в основной памяти
                cache.accessCache(address, color, true); // Доступ к кэшу (запись)
            }
        }
    }

    // Алгоритм 3
    private void algorithm3() {
        int N = memory.getN();
        int M = memory.getM();
        // Первый проход: установка Y
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Color color = memory.getColor(i, j); // Получение цвета из основной памяти
                color.y = 1; // Модификация существующего цвета
                int address = i * M + j; // Вычисление адреса в основной памяти
                cache.accessCache(address, color, true); // Доступ к кэшу (запись)
            }
        }
        // Второй проход: установка C, M, K
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Color color = memory.getColor(i, j); // Получение цвета из основной памяти
                color.c = 0;
                color.m = 0;
                color.k = 0; // Дополнительная модификация цвета
                int address = i * M + j; // Вычисление адреса в основной памяти
                cache.accessCache(address, color, true); // Доступ к кэшу (запись)
            }
        }
    }

    // Метод main для тестирования
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
