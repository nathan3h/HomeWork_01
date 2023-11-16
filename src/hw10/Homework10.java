package hw10;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Homework10 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
//		• 請設計一隻程式,用亂數產生5個介於1~100之間的整數,而輸出結果可以判斷出這5個整數為是否
//		為質數 (提示:Math類別)
		generateNumbers();
		System.out.println("\n-----------------------------------------------------");

//		請設計一隻程式,讓使用者可以輸入一個任意數後,可以選擇要以下列何種表示方法顯示(1)千分位
//		(2)百分比(3)科學記號,而輸入非任意數會顯示提示訊息如圖 (提示: TestFormatter.java, Java API
//		文件, 判斷數字可用正規表示法)
		formatNumber();
		System.out.println("\n-----------------------------------------------------");

//		• 請設計一隻程式,讓使用者輸入日期(年月日,例如:20110131)後,可以轉成想要的輸出格式化成(1)
//		年/月/日(2)月/日/年(3)日/月/年三選一,而輸入非指定日期數字格式會顯示出提示訊息如圖
		formatDate();

		sc.close();

	}

	private static void generateNumbers() {
		for (int i = 0; i < 5; i++) {
			int num = (int) (Math.random() * 100) + 1;
			boolean isPrime = true;
			for (int j = 1; j <= num; j++) {
				if (num % j == 0 && j != 1 && j != num) {
					isPrime = false;
					break;
				}
			}
			System.out.println(num + (isPrime ? "是" : "不是") + "質數");
		}
	}

	private static void formatNumber() {

		String numRegex = "^\\-?[0-9]+(\\.[0-9]+)?$";
		String optionRegex = "[1-3]";
		while (true) {
			System.out.println("請輸入數字: ");
			String input = sc.next();

			if (!input.matches(numRegex)) {
				System.out.println("數字格式不正確, 請再輸入一次!");
				continue;
			}

			System.out.println("欲格式化成(1)千分位(2)百分比(3)科學記號: ");
			String option = sc.next();
			if (!option.matches(optionRegex)) {
				System.out.println("沒有這個選項!");
				continue;
			}

			double inputNumber = Double.parseDouble(input);

			String outputNumber = "";

			switch (option) {
			case "1":
				Format df1 = new DecimalFormat("#,###");
				outputNumber = df1.format(inputNumber);
				break;
			case "2":
				Format df2 = new DecimalFormat("#%");
				outputNumber = df2.format(inputNumber);
				break;
			case "3":
				Format df3 = new DecimalFormat("0.######E00");
				outputNumber = df3.format(inputNumber);
				break;
			}

			System.out.println(
					(option.equals("1") ? "千分位" : (option.equals("2") ? "百分比" : "科學記號")) + "數字: " + outputNumber);

			break;
		}

	}

	private static void formatDate() {

		String dateRegex = "^[0-9]{4}((0[1-9])|(1[0-2]))((0[1-9])|([12][0-9])|(3[01]))$";
		String optionRegex = "[1-3]";
		while (true) {
			System.out.println("請輸入日期(年月日,例如20110131): ");
			String input = sc.next();

			if (!input.matches(dateRegex)) {
				System.out.println("日期格式不正確, 請再輸入一次!");
				continue;
			}

			System.out.println("欲格式化成(1)年/月/日(2)月/日/年(3)日/月/年: ");
			String option = sc.next();
			if (!option.matches(optionRegex)) {
				System.out.println("沒有這個選項!");
				continue;
			}

			String newFormat = "";
			StringBuffer sb = new StringBuffer(input).insert(4, "/").insert(7, "/");

			switch (option) {
			case "1":
				newFormat = "yyyy/MM/dd";
				break;
			case "2":
				newFormat = "MM/dd/yyyy";
				break;
			case "3":
				newFormat = "dd/MM/yyyy";
				break;
			}

			final String OLD_FORMAT = "yyyy/MM/dd";

			SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
			Date inputDate = null;
			try {
				inputDate = sdf.parse(sb.toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			sdf.applyPattern(newFormat);
			String outputDate = sdf.format(inputDate);

			System.out.println(
					(option.equals("1") ? "年/月/日" : (option.equals("2") ? "月/日/年" : "日/月/年")) + ": " + outputDate);
			break;
		}

	}
}
