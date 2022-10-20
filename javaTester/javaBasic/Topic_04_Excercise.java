package javaBasic;

import org.testng.annotations.Test;

public class Topic_04_Excercise {

	@Test
	public void swapNumber() {
		int a = 5;
		int b = 6;

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println(a);
		System.out.println(b);
	}
	
	@Test
	public void afterAge() {
		int beforeAge = 30;
		
		int afterAge = beforeAge + 15;
		System.out.println("Sau 15 nam thi bay gio la " + afterAge + " tuoi");
	}
	
	@Test
	public void trueFalse() {
		int a = 5;
		int b = 4;
		
		boolean c = (a > b) ? true : false;
		System.out.println(c);
	}

}
