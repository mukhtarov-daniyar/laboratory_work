package com.example.labwork;

import java.util.Random;

public class MainMemory {
    private Color[][] memory;
    private int N;
    private int M;

    public MainMemory(int N, int M) {
        this.N = N;
        this.M = M;
        memory = new Color[N][M];
        initializeMemory();
    }

    private void initializeMemory() {
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int c = random.nextInt(256); // Генерация случайных значений от 0 до 255 для каждого цвета
                int m = random.nextInt(256);
                int y = random.nextInt(256);
                int k = random.nextInt(256);
                memory[i][j] = new Color(c, m, y, k);
            }
        }
    }

    public void setColor(int i, int j, Color color) {
        memory[i][j] = color;
    }

    public Color getColor(int i, int j) {
        return memory[i][j];
    }

    public int getN() {
        return N;
    }

    public int getM() {
        return M;
    }
}
