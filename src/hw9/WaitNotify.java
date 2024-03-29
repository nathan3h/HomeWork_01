package hw9;

class Bank {
	private int money = 0;
	private int depositCount = 0;
	private int withdrawCount = 0;

	synchronized public void deposit(int qty) {
		while (money > 3000) {
			System.out.println("媽媽看到餘額在3000以上,暫停匯款");
			try {
				if (withdrawCount < 10) {
					wait();
				}
				break;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		depositCount++;
		if (money <= 3000) {
			money += qty;
			System.out.println("媽媽存了2000,帳戶共有:" + money);
			notify();
		} else if (depositCount >= 10) {
			System.out.println("媽媽匯完了");
			notify();
		}
	}

	synchronized public void withdraw(int qty) {
		while (money < qty) {
			System.out.println("雄大看到帳戶沒錢,暫停提款");
			try {
				if (depositCount < 10) {
					wait();
					System.out.println("雄大被老媽告知帳戶以經有錢!");
				}
				break;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (money >= qty) {
			money -= qty;
			System.out.println("雄大領了1000,帳戶共有:" + money);
		}
		withdrawCount++;
		if (money < 2000) {
			System.out.println("雄大看到餘額在2000以下,要求匯款");
			notify();
		} else if (withdrawCount >= 10) {
			System.out.println("雄大領完了");
			notify();
		}
	}
}

class Depositor extends Thread {
	Bank bank;

	public Depositor(Bank bank) {
		this.bank = bank;
	}

	public void run() {
		for (int i = 1; i <= 10; i++)
			bank.deposit(2000);
	}
}

class Withdrawer extends Thread {
	Bank bank;
	int count;

	public Withdrawer(Bank bank) {
		this.bank = bank;
	}

	public void run() {
		for (int i = 1; i <= 10; i++)
			bank.withdraw(1000);
	}
}

public class WaitNotify {
	public static void main(String[] args) {
		Bank bank = new Bank();
		Depositor depositor = new Depositor(bank);
		Withdrawer withdrawer = new Withdrawer(bank);
		depositor.start();
		withdrawer.start();
	}
}
