package hw5;

public class InkBrush extends Pen{

	@Override
	public void write() {
		System.out.println("沾墨汁再寫");
	}
	
	public double getPrice() {
		return super.getPrice()*0.9;
	}

}
