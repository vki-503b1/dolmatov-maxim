// Простое число
package ru.nsu.hci.dolmatov.javalabs;

import java.util.Scanner;

public class findprimes {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Введите число: ");

        int choice = s.nextInt();
        boolean count = false;

        for (int i = 2; i < choice; i++) {
            if (choice % i == 0) {
                count = true;
                break;
            }
        }

        if(count)
            System.out.println("Число не простое");
        else
            System.out.println("Число простое");

    }

}
