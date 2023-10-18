package hw2;

public class Test4Numbers {

	public static void main(String[] args) {
		printMultiplesOfFour();
	}
		
	private static void printMultiplesOfFour() {
		for(int i = 0; i <= 100; i+=4) {
			if(i%4==0)
			System.out.print(i + " ");
		}
	}
	
}
