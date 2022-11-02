package javaBasic;

import org.testng.annotations.Test;

public class Topic_11_String_Exercise {
    String courseName = "Automation Testing Advanced 2022";
    @Test
    public void TC_01() {
       char courseNameArr[] = courseName.toCharArray();
       int countUpper = 0;
       int countLower = 0;
       int countNumber = 0;
       for (char str : courseNameArr) {
           if (str >= 'A' && str <= 'Z') {
               countUpper++;
           }

           if (str >= 'a' && str <= 'z') {
               countLower++;
           }

           if (str >= '0' && str <= '9') {
               countNumber++;
           }
       }
       System.out.println("Sum of uppercase = " + countUpper);
       System.out.println("Sum of lowercase = " + countLower);
       System.out.println("Sum of number = " + countNumber);
    }

    @Test
    public void TC_02() {
        char courseNameArr[] = courseName.toCharArray();
        int count = 0;

        for(char c : courseNameArr) {
            if(c == 'a'){
                count++;
            }
        }
        System.out.println(count);
    }
}
