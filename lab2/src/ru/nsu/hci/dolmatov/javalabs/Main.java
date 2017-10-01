package ru.nsu.hci.dolmatov.javalabs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int min, max, temp;
        double average = 0, mltplctn = 1;
        Scanner s = new Scanner(System.in);

        System.out.println("Введите рамер массива: ");
        int size = s.nextInt();
        int[] ar = new int [size];

        for(int i = 0; i < size; i++) { // заполнение массива
            System.out.print("Введите элемент " + i + ":");
            ar[i] = s.nextInt();
            System.out.println();

            average += ar[i];
            mltplctn *= ar[i];
        }

        System.out.println();

        System.out.print("Вывод массива:"); //вывод массива
        for(int i = 0; i < size; i++)
            System.out.print(" " +  ar[i]);

        System.out.println();

        for(int a = 1; a < size; a++) { //пузырьковая сортировка массива
            for(int b = size - 1; b >= a; b--) {
                if(ar[b-1] > ar[b]) {
                    temp = ar[b - 1];
                    ar[b - 1] = ar[b];
                    ar[b] = temp;
                }
            }
        }

        System.out.println("Минимальный элемент: " + ar[0]);
        System.out.println("Максимальный эелемент: " + ar[size - 1]);
        System.out.println("Среднее арифметическое: " + (average / size));
        if (size % 2 != 0) {
            int median = ar[size / 2];
            System.out.println("Медиана: " + median);
        }
        else {
            float median = (ar[size / 2] + ar[(size / 2) - 1]) / 2;
            System.out.println("Медиана: " + median);
        }

        double geomean = Math.pow(mltplctn, 1.0 / size); //вычисление среднего геометрического
        System.out.println("Среднее геометричесокое: " + geomean);
    }
}