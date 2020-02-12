package Gen.com.mpro.math;

import java.util.Scanner;

public class Palendrum_string {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to check palendrum");
		String word = sc.next();
		String reverse ="";
			
		for(int i = word.length()-1; i>=0; i --) {
			reverse=reverse+word.charAt(i);
		}
		
		if (word.equals(reverse)) 
			System.out.println("This One Is String Palendrum");
		else
			System.out.println("not palendrum");

	}

}
