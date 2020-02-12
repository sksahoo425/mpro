package Gen.com.mpro.math;

import java.util.Scanner;

public class Prime_number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to check Prime_number");
		int num = sc.nextInt();
		
		boolean flag = false;
		for(int i=2;i<(num/2);i++) {
			if(num%i==0) {
				flag=true;
				break;
			}	
		}
		
		if(!flag)
			System.out.println("prime");
		else
			System.out.println("not a prime");
		
		
		
	}

}
