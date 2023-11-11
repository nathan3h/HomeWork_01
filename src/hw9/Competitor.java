package hw9;

public class Competitor implements Runnable {

	int counter = 0;
	String name;

	public Competitor(String name) {
		this.name = name;
	}

	public void run() { // 執行緒執行的地方

		while (counter < 10) {
			counter++;
			int sleepTime = (int) (Math.random() * (3000 - 500 + 1)) + 500;
			System.out.println(name + "吃第" + counter + "碗飯");

			try {
				Thread.sleep(sleepTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + "吃完了!");
	}

	public static void main(String arg[]) {
		System.out.println("---------------------大胃王快食比賽開始!---------------------");
		Competitor c1 = new Competitor("饅頭人");
		Thread t1 = new Thread(c1);
		Competitor c2 = new Competitor("詹姆士");
		Thread t2 = new Thread(c2);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("---------------------大胃王快食比賽結束!---------------------");
	}
}
