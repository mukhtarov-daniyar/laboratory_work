package com.example.labwork;

import java.util.Random;

public class MainMemory {
    private Color[][] memory; // Двумерный массив для хранения цветов в памяти
    private int N; // Размерность по оси N
    private int M; // Размерность по оси M

    /**
     * Конструктор класса MainMemory.
     * @param N Размерность по оси N (должна быть степенью двойки)
     * @param M Размерность по оси M (должна быть степенью двойки)
     */
    public MainMemory(int N, int M) {
        this.N = N;
        this.M = M;
        memory = new Color[N][M];
        initializeMemory(); // Инициализация памяти случайными значениями
    }

    /**
     * Метод для инициализации памяти случайными значениями CMYK.
     */
    private void initializeMemory() {
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int c = random.nextInt(256); // Генерация случайных значений от 0 до 255 для каждого цвета
                int m = random.nextInt(256);
                int y = random.nextInt(256);
                int k = random.nextInt(256);
                memory[i][j] = new Color(c, m, y, k); // Создание объекта Color и добавление в память
            }
        }
    }

    /**
     * Метод для установки цвета в заданную ячейку памяти.
     * @param i Индекс строки
     * @param j Индекс столбца
     * @param color Цвет для установки
     */
    public void setColor(int i, int j, Color color) {
        memory[i][j] = color;
    }

    /**
     * Метод для получения цвета из заданной ячейки памяти.
     * @param i Индекс строки
     * @param j Индекс столбца
     * @return Цвет из указанной ячейки памяти
     */
    public Color getColor(int i, int j) {
        return memory[i][j];
    }

    /**
     * Метод для получения размерности по оси N.
     * @return Размерность по оси N
     */
    public int getN() {
        return N;
    }

    /**
     * Метод для получения размерности по оси M.
     * @return Размерность по оси M
     */
    public int getM() {
        return M;
    }
}
