package hw3;

import java.util.Scanner;

public class Homework3 {

	public static void main(String[] args) {
		
		
//		請設計一隻程式,使用者輸入三個數字後,輸出結果會為正三角形、等腰三角形、其它三角形或不是三角形
//		printTriangle();
		
//		請設計一隻程式,會亂數產生一個0~9的數字,然後可以玩猜數字遊戲,猜錯會顯示錯誤訊息,猜對則顯示正確訊息
//		guess0To9();
		
//		(進階功能:產生0~100亂數,每次猜就會提示你是大於還是小於正確答案)
		guess0To100();
		
	}
	
	
	
	
	private static void printTriangle() {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入三個整數:");
		int side1 = sc.nextInt();
		int side2 = sc.nextInt();
		int side3 = sc.nextInt();
		if(side1 <= 0 || side2 <= 0 || side3 <= 0) {
			System.out.println("不是三角形");
		} else if(side1 == side2 && side2 == side3) {
			System.out.println("正三角形");
		} else if(side1 == side2 || side2 == side3 || side1 == side3) {
			System.out.println("等腰三角形");
		} else if(Math.pow(side1, 2)+Math.pow(side2, 2) == Math.pow(side3, 2)
				|| Math.pow(side1, 2)+Math.pow(side3, 2) == Math.pow(side2, 2)
				|| Math.pow(side2, 2)+Math.pow(side3, 2) == Math.pow(side1, 2)) {
			System.out.println("直角三角形");
		} else {
			System.out.println("其它三角形");
		}
	}
	
	private static void guess0To9() {
		int number = (int)(Math.random()*10);
		int guess = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("開始猜數字吧!");
		guess = sc.nextInt();		
		while(guess != number){
			System.out.println("猜錯囉");
			guess = sc.nextInt();		
		}
		System.out.println("答對了!答案就是" + number);
	}
	
	private static void guess0To100() {
		int number = (int)(Math.random()*101);
		int guess = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("開始猜數字吧!");
		guess = sc.nextInt();		
		while(guess != number){
			if(guess>number)
				System.out.println("太大了");
			else if(guess<number)
				System.out.println("太小了");
			guess = sc.nextInt();		
		}
		System.out.println("答對了!答案就是" + number);
	}

}

