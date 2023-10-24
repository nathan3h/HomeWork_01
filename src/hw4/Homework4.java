package hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Homework4 {

	public static void main(String[] args) {
//	有個一維陣列如下:
//	{29, 100, 39, 41, 50, 8, 66, 77, 95, 15}
//	請寫出一隻程式能輸出此陣列所有元素的平均值與大於平均值的元素
		int[] numbers = { 29, 100, 39, 41, 50, 8, 66, 77, 95, 15 };
		printAvg(numbers);
		
		System.out.println("==================================================");

//	請建立一個字串,經過程式執行後,輸入結果是反過來的
//	例如String s = “Hello World”,執行結果即為dlroW olleH
		String s = "Hello World";
		reverseString(s);
		
		System.out.println("==================================================");

//	有個字串陣列如下 (八大行星):
//	{“mercury”, “venus”, “earth”, “mars”, “jupiter”, “saturn”, “uranus”, “neptune”}
//	請用程式計算出這陣列裡面共有多少個母音(a, e, i, o, u)

		String[] words = { "mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune" };
		countVowels(words);

		System.out.println("==================================================");
//	阿文上班時忘了帶錢包,想要向同事借錢,和他交情比較好的同事共有 5 個,其員工編號與身上現金列
//	表如下:
//
//	請設計一個程式,可以讓小華輸入欲借的金額後,便會顯示哪些員工編號的同事
//	有錢可借他;並且統計有錢可借的總人數:例如輸入 1000 就顯示「有錢可借的
//	員工編號: 25 19 27 共 3 人!」	

		int[][] coWorkers = { { 25, 2500 }, { 32, 800 }, { 8, 500 }, { 19, 1000 }, { 27, 1200 } };
		lendMoney(coWorkers);
		
		System.out.println("==================================================");

//	請設計由鍵盤輸入三個整數,分別代表西元yyyy年,mm月,dd日,執行後會顯示是該年的第幾天
//	例:輸入 1984 9 8 三個號碼後,程式會顯示「輸入的日期為該年第252天」	

		dayOfYear();
		
		System.out.println("==================================================");
	
//	班上有8位同學,他們進行了6次考試結果如下:
//	請算出每位同學考最高分的次數		

		Integer[][] scores = {{10,35,40,100,90,85,75,70},
				{37,75,77,89,64,75,70,95},
				{100,70,79,90,75,70,79,90},
				{77,95,70,89,60,75,85,89},
				{98,70,89,90,75,90,89,90},
				{90,80,100,75,50,20,99,75}};
		
		numMaxScores(scores);		
	}

	private static void printAvg(int[] numbers) {
		double sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		double avg = sum / numbers.length;
		System.out.println("平均值" + " = " + avg);
		System.out.print("大於平均值的元素:\t");
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > avg)
				System.out.print(numbers[i] + "\t");
		}
		System.out.println();
	}

	private static void reverseString(String str) {
		char[] chars = str.toCharArray();
		char[] reverseChars = new char[chars.length];
		for (int i = 0; i < chars.length; i++) {
			reverseChars[i] = chars[chars.length - i - 1];
		}
		String reverseString = String.valueOf(reverseChars);
		System.out.println("\nReversed string" + " = " + reverseString);
	}

	private static void countVowels(String[] words) {
		int count = 0;
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		Arrays.sort(vowels);
		for (int i = 0; i < words.length; i++) {
			char[] word = words[i].toCharArray();
			for (int j = 0; j < word.length; j++) {
				if (Arrays.binarySearch(vowels, word[j]) >= 0)
					count++;
			}
		}
		System.out.println("陣列裡面共有 " + count + " 個母音");
	}

	private static void lendMoney(int[][] coWorkers) {
		Scanner sc = new Scanner(System.in);
		System.out.println("小華要借: ");
		int amount = sc.nextInt();
		int numPeople = 0;
		System.out.print("有錢可借的員工編號: ");
		for (int i = 0; i < coWorkers.length; i++) {
			if (amount <= coWorkers[i][1]) {
				numPeople++;
				System.out.print(coWorkers[i][0] + " ");
			}
		}
		System.out.println(" 共 " + numPeople + " 人!");
	}

	private static void dayOfYear() {
		int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		boolean acceptableDate = false;
		while (!acceptableDate) {
			Scanner sc = new Scanner(System.in);
			System.out.println("請輸入西元yyyy年,mm月,dd日:");
			int year = sc.nextInt();
			int month = sc.nextInt();
			int date = sc.nextInt();

			if (year < 0 || month < 1 || month > 12 || date < 1) {
				System.out.println("請輸入有效的西元年,月,日.");
				continue;
			}

			boolean leapYear = year % 4 == 0;

			if (date > monthDays[month - 1] && month != 2 || !leapYear && month == 2 && date > 28
					|| leapYear && month == 2 && date > 29) {
				System.out.println("西元" + year + "年" + month + "月沒有" + date + "號.");
				continue;
			}

			int days = 0;
			for (int i = 0; i < month; i++) {
				int curMonth = i + 1;
				if (leapYear && curMonth == 2) days += 29;
				else if (month == curMonth) days += date;
				else days += monthDays[curMonth-1];
			}
			
			System.out.println("輸入的日期為該年第" + days + "天");

			acceptableDate = true;
		}
	}
	
	private static void numMaxScores(Integer[][] scores) {
		int[] maxScoreCount = new int[8];
		for(int i = 0; i < scores.length; i++) {
			Integer[] examScores = Arrays.copyOf(scores[i], scores[i].length);
			Arrays.sort(examScores);
			int maxScore = examScores[examScores.length-1];
			int studentIndex = Arrays.asList(scores[i]).indexOf(maxScore);
			maxScoreCount[studentIndex]++;
		}
		for(int i = 0; i < maxScoreCount.length; i++) {
			System.out.println("同學" +  (i+1) + "考最高分的次數是 " + maxScoreCount[i]+ " 次");
		}
	}
	
}
