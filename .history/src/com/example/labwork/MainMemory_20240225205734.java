package com.example.labwork;

public class MainMemory {
    private Color[][] memory;
    private int N; // Добавляем поле для хранения размера N
    private int M; // Добавляем поле для хранения размера M

    public MainMemory(int N, int M) {
        this.N = N; // Сохраняем значение N
        this.M = M; // Сохраняем значение M
        memory = new Color[N][M];
        // Инициализация памяти нулевыми значениями CMYK
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                memory[i][j] = new Color(0, 0, 0, 0);
            }
        }
    }

    public void setColor(int i, int j, Color color) {
        memory[i][j] = color;
    }

    public Color getColor(int i, int j) {
        return memory[i][j];
    }

    // Метод для получения размера N
    public int getN() {
        return N;
    }

    // Метод для получения размера M
    public int getM() {
        return M;
    }
}
