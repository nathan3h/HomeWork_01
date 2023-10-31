package hw6;

public class Calculator {

	int powerXY(String input1, String input2) throws CalException {
		try {
			int x = Integer.parseInt(input1);
			int y = Integer.parseInt(input2);
			if (x == 0 && y == 0)
				throw new CalException("0的0次方沒有意義!");
			if (y < 0)
				throw new CalException("次方為負值,結果回傳不為整數!");
			return (int) Math.pow(x,y);
		} catch (NumberFormatException e) {
			throw new CalException("輸入格式不正確");
		}
	}

}
