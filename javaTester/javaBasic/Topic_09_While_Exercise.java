package javaBasic;


import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_09_While_Exercise {
    Scanner scanner = new Scanner(System.in);

    @Test
    public void TC_01() {
        int number = scanner.nextInt();

        for (int i = number; i < 100; number++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    @Test
    public void TC_02() {
        int number = scanner.nextInt();

        while (number < 100) {
            if (number % 2 == 0) {
                System.out.println(number);
                number++;
            }
        }
    }

    @Test
    public void TC_03() {
        int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();

        while (numberA < numberB) {
            if (numberA % 3 == 0 && numberA % 5 == 0) {
                System.out.println(numberA);
                numberA++;
            }
        }
    }

    @Test
    public void TC_04() {
        int number = scanner.nextInt();
        int i = 0;

        while (number > 0) {
            if (number % 2 != 0) {
                System.out.println(number);
                i += number;
            }
            number--;
        }
        System.out.println(number);
    }
}
