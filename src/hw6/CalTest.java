package hw6;

import java.util.Scanner;

public class CalTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculator c = new Calculator();

		while (true) {
			try {
				System.out.println("請輸入x的值:");
				String input1 = sc.nextLine();
				int x = Integer.parseInt(input1);
				System.out.println("請輸入y的值:");
				String input2 = sc.nextLine();
				int y = Integer.parseInt(input2);
				int power = c.powerXY(input1, input2);
				System.out.println(input1 + "的" + input2 + "次方等於" + power);
				break;
			} catch (NumberFormatException e) {
				System.out.println("輸入格式不正確");
			} catch (CalException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
