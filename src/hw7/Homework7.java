package hw7;

import java.io.*;

public class Homework7 {

	public static void main(String[] args) {

//		請寫一個程式讀取這個Sample.txt檔案,並輸出以下訊息:
//		Sample.txt檔案共有xxx個位元組,yyy個字元,zzz列資料
		printSampleFileData();
		System.out.println("--------------------");

//		請寫一隻程式,能夠亂數產生10個1~1000的整數,並寫入一個名為Data.txt的檔案裡 (請使用
//		append功能讓每次執行結果都能被保存起來)
		writeTenNumToFile();

//		請從無到有試著完成一個方法名為copyFile,這個方法有兩個參數。呼叫此方法時,第一個參數所
//		代表的檔案會複製到第二個參數代表的檔案

		File file1 = new File("src/hw7/Data.txt");
		File file2 = new File("src/hw7/Data2.txt");
		copyFile(file1, file2);

//		請寫一支程式,利用老師提供的Dog與Cat類別分別產生兩個物件,寫到C:\data\Object.ser裡。注
//		意物件寫入需注意的事項,若C:\內沒有data資料夾,請用程式新增這個資料夾

		try {
			writeCatDog();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		承上題,請寫一個程式,能讀取Object.ser這四個物件,並執行speak()方法觀察結果如何 (請利用多
//		型簡化本題的程式設計)

		try {
			readCatDog();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printSampleFileData() {
		try {
			File f = new File("src/hw7/Sample.txt");
//			FileInputStream fis = new FileInputStream(f);
//			InputStreamReader isr = new InputStreamReader(fis);
			FileReader fr = new FileReader(f);
//			BufferedReader br = new BufferedReader(isr);
			BufferedReader br = new BufferedReader(fr);
			long numByte = f.length();
			int numLine = 0;
			int numChar = 0;
			String line;
			while ((line = br.readLine()) != null) {
				numLine++;
				numChar += line.length();
			}
			System.out.print("Sample.txt檔案共有" + numByte + "個位元組, ");
			System.out.print(numChar + "個字元, ");
			System.out.println(numLine + "列資料");
			br.close();
			fr.close();
//			isr.close();
//			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeTenNumToFile() {
		int[] numbers = new int[10];
		for (int i = 0; i < 10; i++) {
			int num = (int) (Math.random() * 1000) + 1;
			numbers[i] = num;
		}
		try {
			File f = new File("src/hw7/Data.txt");
			FileOutputStream fos = new FileOutputStream(f, true);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			PrintStream ps = new PrintStream(bos);
			for (int i = 0; i < numbers.length; i++)
				ps.print(numbers[i] + " ");
			ps.close();
			bos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void copyFile(File file1, File file2) {
		try {
			FileReader fr = new FileReader(file1);
			BufferedReader br = new BufferedReader(fr);

			FileWriter fw = new FileWriter(file2);
			BufferedWriter bw = new BufferedWriter(fw);

			int c;
			while ((c = br.read()) != -1) {
				bw.write(c);
				System.out.flush();
			}
			br.close();
			fr.close();
			bw.close();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeCatDog() throws Exception {
		File data = new File("C:/data");
		if (!data.exists()) {
			data.mkdir();
		}
		File f = new File("C:/data/Object.ser");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		Cat[] cats = new Cat[2];
		cats[0] = new Cat("Cat 1");
		cats[1] = new Cat("Cat 2");
		Dog[] dogs = new Dog[2];
		dogs[0] = new Dog("Dog 1");
		dogs[1] = new Dog("Dog 2");

		for (int i = 0; i < cats.length; i++)
			oos.writeObject(cats[i]);
		for (int i = 0; i < dogs.length; i++)
			oos.writeObject(dogs[i]);

		oos.close();
		fos.close();
	}

	private static void readCatDog() throws Exception {

		File f = new File("C:/data/Object.ser");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);

		try {
			while (true) {
				Animal a = (Animal) ois.readObject();
				a.speak();
				System.out.println("--------------------");
			}
		} catch (EOFException e) {
			System.out.println("資料讀取完畢！");
		}
		ois.close();
		fis.close();
	}

}
