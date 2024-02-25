package com.example.labwork;

public class CacheEfficiencyCalculator {
    // Предположим, что методы для алгоритмов уже определены
    public void runAlgorithm(int algorithmNumber, MainMemory memory, Cache cache) {
        int N = memory.getN(); // Получаем размер N
        int M = memory.getM(); // Получаем размер M
        switch (algorithmNumber) {
            case 1:
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        Color color = new Color(0, 0, 1, 0);
                        int address = i * M + j;
                        memory.setColor(i, j, color); // Установка в основную память
                        cache.accessCache(address, color); // Попытка доступа к кэшу
                    }
                }
                break;
            // Дополните с алгоритмами 2 и 3
        }

        System.out.println("Hits: " + cache.getHits());
        System.out.println("Misses: " + cache.getMisses());
    }
}
