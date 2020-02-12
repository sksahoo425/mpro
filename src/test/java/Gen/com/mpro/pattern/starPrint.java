package Gen.com.mpro.pattern;

import org.testng.annotations.Test;

public class starPrint {
	
	
	@Test(enabled=false)
	static void FindLargeer() {
		 int a = 20;
		 int b = 20;
		
		if (a>b) {
			System.out.println(a+"A is grater than B"+b);
		}else if (a<b) {
			System.out.println(b+"b is grater than a"+a);
			
		}else {
			System.out.println("Both are Same");
		}
		
		
	}
	
	
	@Test(enabled=false)
	static void alternet() {
		 int a = 20;
		 int b = 50;
		 int c ;
		 
		 c=b;
		 b=a;
		 a=c;
		  System.out.println("A is : "+a);
		  System.out.println("B is : "+b);
		
	}
	
	@Test(enabled=false)
	static void alternet1() {
		 int a = 20;
		 int b = 50; 
		 a =a+b;
		 b= a-b;
		 a=a-b;
		  System.out.println("A is : "+a);
		  System.out.println("B is : "+b);
	}
	
	@Test(enabled=true)
	static void PrimeNumber() {
		 int a = 7;
		 
		 
		 
		 
		 
		
		for (int i = 2; i < a; i++) {
			int count= 0 ; 
			if ((a%i)==0) {
				System.out.println(a+"is not prime");
				count=count+1;
				break;
			}
			if (count>0) {
				System.out.println(i+"is not prime");
				
			}else if(count==0) {
				System.out.println("is prime");
				break;
			}
			
		}
		 
		
		
		
		  
	}
	
	
	

}
