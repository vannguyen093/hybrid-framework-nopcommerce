package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_05_Condition_Statement_Exercise {
	Scanner scanner = new Scanner(System.in);

//	@Test
	public void TC_01() {
		int number = scanner.nextInt();

		if (number % 2 == 0) {
			System.out.println("Day la so chan");
		} else {
			System.out.println("Day la so le");
		}
	}

//	@Test
	public void TC_02() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		if (a >= b) {
			System.out.println(a + " lon hon hoac bang " + b);
		} else {
			System.out.println(a + " nho hon " + b);
		}

	}

//	@Test
	public void TC_03() {
		String nameA = scanner.nextLine();
		String nameB = scanner.nextLine();

		if (nameA.equals(nameB)) {
			System.out.println("Hai nguoi giong ten nhau");
		} else {
			System.out.println("Hai nguoi khac ten nhau");
		}
	}

//	@Test
	public void TC_04() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int numberC = scanner.nextInt();

		if (numberA > numberB && numberA > numberC) {
			System.out.println(numberA + " la so lon nhat");
		} else if (numberB > numberC) {
			System.out.println(numberB + " la so lon nhat");
		} else {
			System.out.println(numberC + " la so lon nhat");
		}
	}

//	@Test
	public void TC_05() {
		int numberA = scanner.nextInt();

		if (10 < numberA && numberA < 100) {
			System.out.println(numberA + " nằm trong khoảng từ 10 đến 100");
		} else {
			System.out.println(numberA + " không nằm trong khỏag từ 10 đến 100");
		}
	}

	@Test
	public void TC_06() {
		float mark = scanner.nextFloat();

		if (0 < mark && mark < 5) {
			System.out.println("Diem D");
		} else if (5 < mark && mark < 7.5) {
			System.out.println("Diem C");
		} else if (7.5 < mark && mark < 8.5) {
			System.out.println("Diem B");
		} else if (8.5 < mark && mark < 10) {
			System.out.println("Diem A");
		} else {
			System.out.println("Vui lòng nhập lại");
		}
	}
}
