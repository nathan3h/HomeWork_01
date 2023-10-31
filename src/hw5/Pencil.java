package hw5;

public class Pencil extends Pen{

	@Override
	public void write() {
		System.out.println("削鉛筆再寫");		
	}
	
	public double getPrice() {
		return super.getPrice()*0.8;
	}

}
