package Gen.com.mpro.math;

import java.util.Scanner;

public class Amstrung_no {

	public static void main(String[] args) {
		//no=153
		//(1*1*1)+(5*5*5)+(3*3*3)=153
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to check Amstrung_no");
		int num = sc.nextInt();
		int temp , r=0 ,sum=0;
		temp=num;
		
		while(temp!= 0) {
			r=temp%10;
			sum=sum+(r*r*r);
			temp=temp/10;
	
		}
		if(num==sum) {
			System.out.println("This number is Amstrung_no  ");
		}else {
			System.out.println("not a Amstrung_no ");
		}
		

	}

}
