package com.example.labwork;

public class MainMemory {
    private Color[][] memory;

    public MainMemory(int N, int M) {
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
}
