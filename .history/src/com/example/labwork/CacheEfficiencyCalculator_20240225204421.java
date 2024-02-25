package com.example.labwork;

public class CacheEfficiencyCalculator {
    private MainMemory memory;
    private Cache cache;
    private int totalAccesses;
    private int cacheHits;
    private int cacheMisses;

    public CacheEfficiencyCalculator(int N, int M) {
        memory = new MainMemory(N, M);
        cache = new Cache();
    }

    public void runAlgorithm(int algorithmNumber) {
        // Инициализация счетчиков
        totalAccesses = 0;
        cacheHits = 0;
        cacheMisses = 0;

        switch (algorithmNumber) {
            case 1:
                // Алгоритм 1
                // Здесь реализация алгоритма, обновление счетчиков
                break;
            case 2:
                // Алгоритм 2
                // Аналогично
                break;
            case 3:
                // Алгоритм 3
                // Аналогично
                break;
        }

        // После выполнения алгоритма
        System.out.println("Total accesses: " + totalAccesses);
        System.out.println("Cache hits: " + cacheHits);
        System.out.println("Cache misses: " + cacheMisses);
        System.out.println("Hit rate: " + ((double)cacheHits / totalAccesses));
        System.out.println("Miss rate: " + ((double)cacheMisses / totalAccesses));
    }
}
