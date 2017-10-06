package ru.nsu.hci.dolmatov.javalabs;

import java.util.Scanner;

class Comp {
    int nums[];

    Comp(int n[]) {
        nums = n;
    }

    void Analyze () {
        Inner inOb = new Inner();

        System.out.println("Минимум: " + inOb.min());
        System.out.println("Максимум: " + inOb.max());
        System.out.println("Среднее арифметическое: " + inOb.avg());
        System.out.println("Среднее геоиетрическое: " + inOb.geomn());
        System.out.println("Медиана: " + inOb.median());
    }

    class Inner {

        int min() {
            int m = nums[0];

            for(int i = 1; i < nums.length; i++)
                if(nums[i] < m) m = nums[i];

            return m;
        }

        int max() {
            int m = nums[0];

            for(int i = 1; i < nums.length; i++)
                if(nums[i] > m) m = nums[i];

            return m;
        }

        int avg() {
            int a = 0;

            for(int i = 0; i < nums.length; i++)
                a += nums[i];

            return a / nums.length;
        }

        double median() {
            int m = 0;

            if(nums.length % 2 != 0)
                m = nums[nums.length / 2];
            else
                m = (nums[nums.length / 2] + nums[(nums.length / 2) - 1]) / 2;

            return m;
        }

        double geomn() {
            double g = 1;

            for(int i = 0; i < nums.length; i++)
                g *= nums[i];

            return Math.pow(g, 1.0 / nums.length);
        }
    }
}

class Quicksort {

    static void qsort(int items[]) {
        qs(items, 0, items.length - 1);
    }

    private static void qs(int items[], int left, int right) {
        int i, j;
        int x, y;

        i = left; j = right;
        x = items[(left + right) / 2];

        do {
            while((items[i] < x) && (i < right)) i++;
            while((x < items[j]) && (j > left)) j--;

            if(i <= j) {
                y = items[i];
                items[i] = items[j];
                items[j] = y;
                i++; j--;
            }
        } while(i <= j);

        if(left < j) qs(items, left, j);
        if(i < right) qs(items, i, right);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Введите рамер массива: ");
        int size = s.nextInt();
        int[] ar = new int [size];

        for(int i = 0; i < size; i++) { // заполнение массива
            System.out.print("Введите элемент " + i + ":");
            ar[i] = s.nextInt();
            System.out.println();
        }

        Quicksort.qsort(ar);

        Comp compOb = new Comp(ar);

        compOb.Analyze();
    }
}