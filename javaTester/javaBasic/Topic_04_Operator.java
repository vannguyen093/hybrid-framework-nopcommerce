package javaBasic;

public class Topic_04_Operator {

	public static void main(String[] args) {
		int number = 10;
		
		number += 5;
		System.out.println(number);
		
		//In number ra trước: 10
		//++ = tăng number lên 1 = 11
		System.out.println(number++);
		
		//++ trước: tăng number lên 1 = 12
		//In number ra sau: 12
		System.out.println(++number);
		
		for (int i = 0; i < 3; i++) {
			System.out.println(i);
		}
		
	}

}
