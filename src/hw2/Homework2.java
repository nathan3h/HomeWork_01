package hw2;

public class Homework2 {

	public static void main(String[] args) {
		
//		• 請設計一隻Java程式,計算1~1000的偶數和 (2+4+6+8+...+1000)
		addEven1To1000();
		
//		• 請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用for迴圈)
		multiply1to10ForLoop();
		
//		• 請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用while迴圈)
		multiply1to10WhileLoop();
		
//		• 請設計一隻Java程式,輸出結果為以下:
//		1 4 9 16 25 36 49 64 81 100
		printSumOdd();
		
//		• 阿文很熱衷大樂透 (1 ~ 49),但他不喜歡有4的數字,不論是個位數或是十位數。請設計一隻程式,
//		輸出結果為阿文可以選擇的數字有哪些?總共有幾個?
		lotteryNumbers();
		
//		• 請設計一隻Java程式,輸出結果為以下:
//		1 2 3 4 5 6 7 8 9 10
//		1 2 3 4 5 6 7 8 9
//		1 2 3 4 5 6 7 8
//		1 2 3 4 5 6 7
//		1 2 3 4 5 6
//		1 2 3 4 5
//		1 2 3 4
//		1 2 3
//		1 2
//		1
		printNumberTriangle();
		
//		• 請設計一隻Java程式,輸出結果為以下:
//			A
//			BB
//			CCC
//			DDDD
//			EEEEE
//			FFFFFF
		printAlphabetTriangle();		
	}
	
	private static void addEven1To1000() {
		int sum = 0;
		for(int i = 0; i <= 1000; i+=2) {
			sum+=i;
		}
		System.out.println("1~1000的偶數和是 " + sum);
	}
	
	private static void multiply1to10ForLoop() {
		int product = 1;
		for(int i = 1; i <= 10; i++) {
			product *= i;
		}
		System.out.println("1~10的連乘積是 " + product);
	}
	
	private static void multiply1to10WhileLoop() {
		int product = 1;
		int i = 1;
		while(i<=10) {
			product *= i;
			i++;
		}
		System.out.println("1~10的連乘積是 " + product);
	}
	
	private static void printSumOdd() {
		final int MAX = 100;
		int sum = 0;
		for(int i = 1; sum < MAX; i+=2) {
			sum += i;
			System.out.print(sum + " ");
		}
	}
	
	private static void lotteryNumbers() {
		int count = 0;
		System.out.print("\n阿文可以選擇的數字有: ");
		for(int i = 1; i <= 49; i++) {
			if(i % 10 == 4 || i >= 40) continue;
			System.out.print(i + " ");
			count++;
		}
		System.out.println("\n總共有 " + count + " 個數字");
	}
	
	private static void printNumberTriangle() {
		for(int i = 10; i >= 1; i--) {
			for(int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	private static void printAlphabetTriangle() {
		char letter = '\u0041';
		for(int i = 1; i <= 6; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(letter);
			}
			letter++;
			System.out.println();
		}
	}
	
}
