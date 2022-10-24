package javaBasic;

import org.testng.annotations.Test;


public class Topic_10_Array_Exercise {
    int number[] = {1, 2, 3, -5, -10, 4, 5, 6, 7, 10, 24, 45};

    @Test
    public void TC_01() {
        int x = 0;
        for (int i = 0; i < number.length; i++) {
            if (x < number[i]) {
                x = number[i];
            }
        }
        System.out.println(x);
    }

    @Test
    public void TC_02() {
        int x = 0;
        x = number[0] + number[number.length - 1];
        System.out.println(x);
    }

    @Test
    public void TC_03() {
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 == 0) {
                System.out.println(number[i]);
            }
        }
    }

    @Test
    public void TC_04() {
        int x = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] > 0 && number[i] % 2 != 0) {
                x += number[i];
            }
        }
        System.out.println("Tổng các số lẻ lớn hơn 0: " + x);
    }

    @Test
    public void TC_05() {
        int sumnumber = 0;
        float avgnumber = 0;
        for (int i = 0; i < number.length; i++) {
            sumnumber += number[i];
            avgnumber = sumnumber / number.length;
        }
        System.out.println("Tổng các số:" + sumnumber);
        System.out.println("Trung bình cộng:" + avgnumber);
    }
}
