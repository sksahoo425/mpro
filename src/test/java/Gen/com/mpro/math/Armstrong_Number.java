package Gen.com.mpro.math;

import java.util.Scanner;

public class Armstrong_Number {
	static int num, temp, r, sum = 0;

	public static void main(String[] args) {
		// 371 is an Armstrong number since 3**3 + 7**3 + 1**3 = 371.
		System.out.println("Enter a number to check Armstrong Number or not");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		temp = num;
		while (num != 0) {
			r = num % 10;
			int Qbe = r * r * r;
			sum = sum + Qbe;
			num = num / 10;
		}
		if (sum == temp) {
			System.out.println("Armstrong_Number");
		} else {
			System.out.println("not Armstrong_Number");
		}

	}

}
