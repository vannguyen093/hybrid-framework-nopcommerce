package javaBasic;


public class Topic_09_While_DoWhile {

    public static void main(String[] args) {
        int i = 0;
        for (i = 0; i < 5; i++) {
            System.out.println("For: " + i);
            if (i == 3) {
                break;
            }
        }

        while (i < 5) {
            System.out.println("While: " + i);
            i++;
            if (i == 3) {
                break;
            }
        }

        do {
            System.out.println("For: " + i);
            i++;
        } while (i < 5);
    }
}

