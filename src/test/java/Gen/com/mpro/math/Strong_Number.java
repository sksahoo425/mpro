package Gen.com.mpro.math;

import java.util.Scanner;

public class Strong_Number {
	static int temp, r, sum;

	public static void main(String[] args) {
		// 145= 1!+4!+5! = 1+24+120 =145
		System.out.println("Enter a number to check Stromg number or not");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		temp = num;

		while (temp != 0) {
			r = temp % 10;
			int f = 1;
			for (int i = 1; i <= r; i++) {
				f = f * i;
			}
			sum = sum + f;
			temp = temp / 10;
		}
		if (sum == num) {
			System.out.println(num + ": is a strong number");
		} else {
			System.out.println(num + ": is not a strong number");
		}
	}

}
