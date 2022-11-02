package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_06_Switch_Case_Exercise {
    Scanner scanner = new Scanner(System.in);

    @Test
    public void TC_01() {
        int month = scanner.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng này có 31 ngày");
                break;
            case 2:
                System.out.println("Tháng này có 28 ngày");
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng này có 30 ngày");
                break;
            default:
                System.out.println("Vui lòng nhập tháng trong khoảng 1 - 12");
                break;
        }
    }

    @Test
    public void TC_02() {
        int number = scanner.nextInt();

        switch (number) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            default:
                System.out.println("Vui lòng nhập số trong khoảng 1 - 7");
                break;
        }
    }
}
