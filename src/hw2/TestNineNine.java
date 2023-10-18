package hw2;

public class TestNineNine {
	
	public static void main(String[] args) {
		System.out.println("===============一:使用for迴圈 + while迴圈=========================================================\n");
//		一:使用for迴圈 + while迴圈
		forWhilePrint99();
		System.out.println("===============二:使用for迴圈 + do while迴圈=========================================================\n");
//		二:使用for迴圈 + do while迴圈
		forDoWhilePrint99();
		System.out.println("===============三:使用while迴圈 + do while迴圈=========================================================\n");
//		三:使用while迴圈 + do while迴圈
		whileDoWhilePrint99();
	}
	
	//	一:使用for迴圈 + while迴圈
	private static void forWhilePrint99() {
		for(int i = 1; i <= 9; i++) {
			int j = 1;
			while(j<=9) {
				System.out.print(i + "*" + j + "=" + i*j + "\t");
				j++;
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//	二:使用for迴圈 + do while迴圈
	private static void forDoWhilePrint99() {
		for(int i = 1; i <= 9; i++) {
			int j = 1;
			do{
				System.out.print(i + "*" + j + "=" + i*j + "\t");
				j++;
			}	
			while(j<=9);
			System.out.println();
		}
		System.out.println();
	}
	
	//	三:使用while迴圈 + do while迴圈
	private static void whileDoWhilePrint99() {
		int i = 1;
		while(i <= 9) {
			int j = 1;
			do{
				System.out.print(i + "*" + j + "=" + i*j + "\t");
				j++;
			}	
			while(j<=9);
			System.out.println();
			i++;
		}
		System.out.println();
	}
}
