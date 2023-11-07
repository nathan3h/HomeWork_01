package hw8;

import java.math.BigInteger;
import java.util.*;

public class Homework8 {

	public static void main(String[] args) {

//		• 請建立一個Collection物件並將以下資料加入:
//		Integer(100)、Double(3.14)、Long(21L)、Short(“100”)、Double(5.1)、“Kitty”、Integer(100)、
//		Object物件、“Snoopy”、BigInteger(“1000”)
//
//		• 印出這個物件裡的所有元素(使用Iterator, 傳統for與foreach)
//		• 移除不是java.lang.Number相關的物件
//		• 再次印出這個集合物件的所有元素,觀察是否已將非Number相關的物件移除成功

		removeElements();

//		• 請設計一個Train類別,並包含以下屬性:
//			- 班次 number,型別為int - 車種 type,型別為String - 出發地 start,型別為String
//			- 目的地 dest,型別為String - 票價 price,型別為double
//			• 設計對應的getter/setter方法,並在main方法裡透過建構子產生以下7個Train的物件,放到每小題
//			需使用的集合裡
//			- (202, “普悠瑪”, “樹林”, “花蓮”, 400)
//			- (1254, “區間”, “屏東”, “基隆”, 700)
//			- (118, “自強”, “高雄”, “台北”, 500)
//			- (1288, “區間”, “新竹”, “基隆”, 400)
//			- (122, “自強”, “台中”, “花蓮”, 600)
//			- (1222, “區間”, “樹林”, 七堵, 300)
//			- (1254, “區間”, “屏東”, “基隆”, 700)

		Collection<Train> trains;

//		請寫一隻程式,能印出不重複的Train物件
		System.out.println("--------------------請寫一隻程式,能印出不重複的Train物件--------------------");
		trains = new HashSet<Train>();
		addTrains(trains);
		printTrains(trains);

//		請寫一隻程式,讓Train物件印出時,能以班次編號由大到小印出
		System.out.println("\n--------------------請寫一隻程式,讓Train物件印出時,能以班次編號由大到小印出--------------------");
		trains = new ArrayList<Train>();
		addTrains(trains);
		List<Train> trainsList = (ArrayList<Train>) trains;
		Collections.sort(trainsList);
		printTrains(trainsList);

//		承上,不僅能讓班次編號由大排到小印出, 還可以不重複印出Train物件
		System.out.println("\n--------------------承上,不僅能讓班次編號由大排到小印出, 還可以不重複印出Train物件--------------------");
		trains = new TreeSet<Train>();
		addTrains(trains);
		printTrains(trains);

	}

	private static void removeElements() {

		List list = new ArrayList();
		list.add(100);
		list.add(3.14);
		list.add(21L);
		list.add((short) 100);
		list.add(5.1);
		list.add("Kitty");
		list.add(100);
		list.add(new Object());
		list.add("Snoopy");
		list.add(BigInteger.valueOf(1000));

		System.out.println("--------------------iterator--------------------");
		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + "\t");
		}
		System.out.println("\n\n--------------------傳統for--------------------");
		int length = list.size();
		for (int i = 0; i < length; i++) {
			System.out.print(list.get(i) + "\t");
		}
		System.out.println("\n\n--------------------foreach--------------------");
		for (Object obj : list) {
			System.out.print(obj + "\t");
		}
		System.out.println("\n\n--------------------移除不是java.lang.Number相關的物件--------------------");

		list.removeIf(obj -> obj instanceof Number);
		length = list.size();
		for (int i = 0; i < length; i++) {
			System.out.print(list.get(i) + "\t");
		}
		System.out.println("\n\n\n\n");
	}

	private static void addTrains(Collection<Train> trains) {
		trains.add(new Train(202, "普悠瑪", "樹林", "花蓮", 400));
		trains.add(new Train(1254, "區間", "屏東", "基隆", 700));
		trains.add(new Train(118, "自強", "高雄", "台北", 500));
		trains.add(new Train(1288, "區間", "新竹", "基隆", 400));
		trains.add(new Train(122, "自強", "台中", "花蓮", 600));
		trains.add(new Train(1222, "區間", "樹林", "七堵", 300));
		trains.add(new Train(1254, "區間", "屏東", "基隆", 700));
	}

	private static void printTrains(Collection<Train> trains) {
		Iterator<Train> it = trains.iterator();
		System.out.print("Iterator: ");
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println();
		System.out.print("foreach: ");
		for (Train t : trains) {
			System.out.print(t);
		}
		System.out.println();
		List<Train> trainsList = new ArrayList<Train>();
		if (trains instanceof Set) {
			trainsList.addAll((Set<Train>) trains);
		} else {
			trainsList = (ArrayList<Train>) trains;
		}
		int size = trainsList.size();
		System.out.print("傳統for: ");
		for (int i = 0; i < size; i++) {
			System.out.print(trainsList.get(i));
		}
		System.out.println();
	}

}
