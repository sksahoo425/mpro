package Gen.com.mpro.math;

import java.util.Scanner;

public class Palendrum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to check palendrum");
		int num = sc.nextInt();
		int temp , r=0 ,sum;
		temp=num;
		
		while(temp!= 0) {
			r=r*10;
		//	System.out.println("r="+r);
			r=r+(temp%10);
		//	System.out.println("now r="+r);
			temp=temp/10;
		//	System.out.println("temp"+temp);
		}
		if(num==r) {
			System.out.println("This number is palendrum no ");
		}else {
			System.out.println("not a palendrum no");
		}
		
		
		
		

	}

}
