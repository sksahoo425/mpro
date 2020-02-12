package Gen.com.mpro.math;

public class Accaurance {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 10, 10, 10,20,80,11,11,6,3,6 };

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1)
				continue;
			int count = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					arr[j] = -1;
					count++;
				}
			}
			System.out.println("count of:" + arr[i] + " is " + count + " times");
		}
		
		
		
		
		
		

	}

}
