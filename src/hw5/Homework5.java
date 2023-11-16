package hw5;

import java.util.*;

public class Homework5 {

	public static void main(String[] args) {
//		請設計一個方法為starSquare(int width, int height),當使用者鍵盤輸入寬與高時,即會印出對應的*長方形,如
//		圖:
		Homework5 hw5 = new Homework5();
		hw5.inputStarSquare();

//		利用Overloading,設計兩個方法int maxElement(int x[][])與double maxElement(double x[][]),
//		可以找出二維陣列的最大值並回傳,如圖:		

		int[][] intArray = { { 1, 6, 3 }, { 9, 5, 2 } };
		double[][] doubleArray = { { 1.5, 3.5, 2.2 }, { 7.4, 2.1, 8.2 } };

		System.out.println(hw5.maxElement(intArray));
		System.out.println(hw5.maxElement(doubleArray));

//		身為程式設計師的你,收到一個任務,要幫系統的註冊新增驗證碼的功能,請設計一個方法
//		genAuthCode(),當呼叫此方法時,會回傳一個8位數的驗證碼,此驗證碼內容包含了英文大小寫
//		與數字的亂數組合,如圖:		

		hw5.genAuthCode();

//		hw5.genAuthCode2();
//		
//		hw5.genAuthCode3();
	}

	private void inputStarSquare() {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入寬與高(整數):");
		int width = sc.nextInt();
		int height = sc.nextInt();
		starSquare(width, height);
	}

	private void starSquare(int width, int height) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	int maxElement(int x[][]) {
		int maxElement = x[0][0];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				if (x[i][j] > maxElement)
					maxElement = x[i][j];
			}
		}
		return maxElement;
	}

	double maxElement(double x[][]) {
		double maxElement = x[0][0];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				if (x[i][j] > maxElement)
					maxElement = x[i][j];
			}
		}
		return maxElement;
	}

	// 48 ~ 57 (0~9), 65 ~ 90 (A~Z), 97 ~ 122 (a~z)
	private void genAuthCode() {
		System.out.print("本次隨機產生驗證碼為:\t");
		char[] unicodes = new char[62];
		int index = 0;
		for (int i = 48; i <= 122; i++) {
			if (i > 57 && i < 65 || i > 90 && i < 97)
				continue;
			unicodes[index] = (char) i;
			index++;
		}
		for (int i = 0; i < 8; i++) {
			int randomNum = (int) (Math.random() * 62);
			System.out.print(unicodes[randomNum]);
		}
	}

	// 48 ~ 57 (0~9), 65 ~ 90 (A~Z), 97 ~ 122 (a~z)
	private void genAuthCode2() {
		System.out.print("\n本次隨機產生驗證碼為:\t");
		List<Character> unicodes = new ArrayList<Character>();
		while (unicodes.size() < 8) {
			int randomNum = (int) (Math.random() * (122 - 48 + 1)) + 48;
			if (randomNum > 57 && randomNum < 65 || randomNum > 90 && randomNum < 97)
				continue;
			unicodes.add((char) randomNum);
			System.out.print((char) randomNum);
		}
	}

	// 48 ~ 57 (0~9), 65 ~ 90 (A~Z), 97 ~ 122 (a~z)
	private void genAuthCode3() {
		System.out.print("\n本次隨機產生驗證碼為:\t");
		int count = 0;
		while (count < 8) {
			int randomNum = (int) (Math.random() * (122 - 48 + 1)) + 48;
			if (randomNum > 57 && randomNum < 65 || randomNum > 90 && randomNum < 97)
				continue;
			count++;
			System.out.print((char) randomNum);
		}
	}
}
