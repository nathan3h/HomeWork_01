package hw5;

public class TestPen {

	public static void main(String[] args) {
		Pen[] pens = new Pen[2];
		pens[0] = new Pencil();
		pens[0].setBrand("Pencil 1");
		pens[0].setPrice(100);
		pens[1] = new InkBrush();
		pens[1].setBrand("Ink Brush 1");
		pens[1].setPrice(100);
		for(int i = 0; i < pens.length; i++) {
			pens[i].write();
			System.out.println("品牌: " + pens[i].getBrand() + ", 實際售價: " + pens[i].getPrice());
			System.out.println("===============================================");
		}
	}
}
