package hw1;

public class Homework1 {

	public static void main(String[] args) {
		
		// Q1. 請設計一隻Java程式,計算12,6這兩個數值的和與積
		int i1 = 12, i2 = 6;
		// 和; sum = 18
		int sum = i1+i2;
		System.out.print("和 = " + sum + "\t");
		// 積; product = 72
		int product = i1*i2;
		System.out.println("積 = " + product);
		
		
		// Q2. 請設計一隻Java程式,計算200顆蛋共是幾打幾顆? (一打為12顆)
		int eggs = 200;
		final int DOZEN = 12;	
		
		// 16打 
		int numOfDozens = 200/12;
		System.out.print(numOfDozens + "打" + "\t");
		
		// 8顆
		int remainder = 200%12;
		System.out.println(remainder + "顆");
		
		
		// Q3. 請由程式算出256559秒為多少天、多少小時、多少分與多少秒
		
		final int SECOND = 1;
		final int MINUTE = SECOND*60;
		final int HOUR = MINUTE*60;
		final int DAY = HOUR*24;
		
		// 2天
		int day = 256559/DAY;
		System.out.print(day + "天" + "\t");
		
		// 23小時
		int hour = 256559%DAY/HOUR;
		System.out.print(hour + "小時" + "\t");
		
		// 15分
		int minute = 256559%DAY%HOUR/MINUTE;
		System.out.print(minute + "分" + "\t");
		
		// 59秒
		int second = 256559%DAY%HOUR%MINUTE/SECOND;
		System.out.println(second + "秒");
	
		
		// Q4. 請定義一個常數為3.1415(圓周率),並計算半徑為5的圓面積與圓周長
		
		final double PI = 3.1415;
		final int RADIUS = 5;
		
		// 圓面積 = 78.53750000000001
		double circleArea = PI*Math.pow(RADIUS,2);
		System.out.print("圓面積 = " + circleArea + "\t");
		
		// 圓周長 = 31.415000000000003
		double circumference = RADIUS*2*PI;
		System.out.println("圓周長 = " + circumference);
		
		
		/* Q5. 某人在銀行存入150萬,銀行利率為2%,如果每年利息都繼續存入銀行,請用程式計算10年後,本
		金加利息共有多少錢 (用複利計算,公式請自行google)*/
		
		// 本金加利息 = 1_828_491.629992136
		double totalBalance = 1_500_000*Math.pow((1+0.02),10);
		System.out.println("本金加利息 = " + totalBalance);
		
		
		/* Q6. 請寫一隻程式,利用System.out.println()印出以下三個運算式結果:
		  	5 + 5
			5 + ‘5’
			5 + “5” 
			並請用註解各別說明答案的產生原因 */
		
		// x3 = 10; 兩個運算元都是int型別所以5+5會回傳10(int型別)
		int x1 = 5;
		int x2 = 5;
		int x3 = x1 + x2;
		System.out.println("5 + 5 = " + x3);
		
		// y3 = 58; char的資料型別比int小所以會升為int型別. '5'的unicode是U+0035(53)所以5+‘5’會回傳58(int型別).
		int y1 = 5;
		char y2 = '5';
		int y3 = y1 + y2;
		System.out.println("5 + \'5\' = " + y3);
		
		// z3 = "55"; int的資料型別比String小所以會升為String型別. 5+“5”會回傳"55"(String型別).
		int z1 = 5;
		String z2 = "5";
		String z3 = z1 + z2;
		System.out.println("5 + \"5\" = " + z3);
		
		
	}
}
