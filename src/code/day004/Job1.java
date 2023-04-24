package week1.day4;

import java.util.Arrays;
import java.util.Scanner;

public class Job1 {

	public static void main(String[] args) {
		String[] arr = { "100-司马懿-男-11000", "101-貂蝉-女-18000", "102-孙权-男-12000", "103-黄忠-男-20000", "104-孙尚香-女-13000",
				"105-诸葛亮-男-15000", "106-西门吹雪-男-16000" };

		try (Scanner scan = new Scanner(System.in)) {

			int selection = -1;

			while (true) {
				showMainPage();
				selection = scan.nextInt();
				switch (selection) {
					case 1 -> showAllWorkerInfo(arr);
					case 2 -> arr = addWorkerInfo(scan, arr);
					case 3 -> arr = updateWorkerInfoByIndexAndName(scan, arr);
					case 4 -> arr = delete(scan, arr);
					case 5 -> search(scan, arr);
					case 6 -> findMoney(arr);
					case 7 -> findMaxAndMin(arr);
					case 8 -> findMale(arr);
					default -> System.out.println("输入信息有误,请重新输入!");
				}
			}
		}

	}

	static boolean isIdValid(int id, String[] arr) {

		if (id > 0) {
			for (String worker : arr) {
				if (worker.split("-")[0].equals(id + "")) {
					return false;
				} else {
					return true;
				}
			}
		} else {
			return false;
		}
		return false;
	}

	static boolean isNameValid(String name) {
		if (name.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	static boolean isGenderValid(String gender) {
		return gender.equals("男") || gender.equals("女");
	}

	static boolean isIncomeValid(int income) {
		return income > 0;
	}

	static void showMainPage() {
		System.out.println("""
				┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
				┃\t主菜单\t\t\t┃
				┃1. 查询完整名单\t\t┃
				┃2. 新增员工信息\t\t┃
				┃3. 更改员工信息\t\t┃
				┃4. 删除员工信息\t\t┃
				┃5. 模糊查找员工信息\t\t┃
				┃6. 找出工资在15k-20k之间的员工\t┃
				┃7. 查询工资最高/最低的员工\t┃
				┃8. 查询女员工信息\t\t┃
				┃...请选择对应操作...\t\t┃
				┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛""");

	}

	static void showAllWorkerInfo(String[] arr) {
		System.out.println("Id\t姓名\t\t性 别\t工 资");
		for (String worker : arr) {
			String[] info = worker.split("-");
			// String.format(String.format("%1$-8s", str))
			// str 的长度不为8时,在字符串后面补空格
			System.out.println(info[0] + "\t" + String.format("%1$-8s", info[1]) + "\t" + info[2] + "\t" + info[3]);
		}
	}

	static String[] addWorkerInfo(Scanner scan, String[] arr) {

		int id = -1;
		String name = "";
		String gender = "";
		int income = -1;

		String workerInfo = "";

		System.out.println("请输入员工id");

		do {
			id = scan.nextInt();
			if (isIdValid(id, arr)) {
				break;
			} else {
				System.out.println("员工id输入错误,请重新输入:");
			}
		} while (true);

		System.out.println("请输入员工姓名:");

		do {
			name = scan.next();
			if (isNameValid(name)) {
				break;
			} else {
				System.out.println("姓名不可为空,请重新输入:");
			}
		} while (true);

		System.out.println("请输入员工性别");

		do {
			gender = scan.next();
			if (isGenderValid(gender)) {
				break;
			} else {
				System.out.println("性别(男|女)输入有误,请重新输入:");
			}
		} while (true);

		System.out.println("请输入员工工资:");

		do {
			income = scan.nextInt();
			if (isIncomeValid(income)) {
				break;
			} else {
				System.out.println("员工工资金额输入有误,请重新输入:");
			}
		} while (true);

		workerInfo = id + "-" + name + "-" + gender + "-" + income;

		arr = Arrays.copyOf(arr, arr.length + 1);
		arr[arr.length - 1] = workerInfo;

		return arr;
	}

	static String[] updateWorkerInfoByIndexAndName(Scanner scan, String[] arr) {
		int index = -1;

		int id = -1;
		String name = "";
		String gender = "";
		int income = -1;
		boolean notExist = true;

		String workerInfo = "";

		do {
			System.out.println("请输入下标:(输入-1退出)");
			index = scan.nextInt();
			if (index != -1) {
				System.out.println("请输入姓名:");
				name = scan.next();
			}

			if (index > -1 && index < arr.length) {
				notExist = arr[index].split("-")[1].equals(name) ? false : true;
				break;
			} else if (index == -1) {
				break;
			} else {
				System.out.println("请检查所输入的姓名与下标是否正确,再重新输入:");
			}

		} while (true);

		if (!notExist && index != -1) {
			System.out.println("请输入员工id");

			do {
				id = scan.nextInt();
				if (isIdValid(id, arr)) {
					break;
				} else {
					System.out.println("员工id输入错误,请重新输入:");
				}
			} while (true);

			System.out.println("请输入员工性别");

			do {
				gender = scan.next();
				if (isGenderValid(gender)) {
					break;
				} else {
					System.out.println("性别(男|女)输入有误,请重新输入:");
				}
			} while (true);

			System.out.println("请输入员工工资:");

			do {
				income = scan.nextInt();
				if (isIncomeValid(income)) {
					break;
				} else {
					System.out.println("员工工资金额输入有误,请重新输入:");
				}
			} while (true);

			workerInfo = id + "-" + name + "-" + gender + "-" + income;

			arr[index] = workerInfo;

			return arr;
		}

		return arr;
	}

	static String[] delete(Scanner scan, String[] arr) {

		int index = -1;

		System.out.println("请输入要删除员工信息的下标(输入-1退出):");
		do {
			index = scan.nextInt();
			if (index >= 0 && index < arr.length) {
				break;
			} else if (index == -1) {
				break;
			} else {
				System.out.println("输入下表有误,请重新输入:");
			}
		} while (true);

		if (index != -1) {

			System.arraycopy(arr, index + 1, arr, index, arr.length - 1 - index);
			arr = Arrays.copyOf(arr, arr.length - 1);
		}

		return arr;
	}

	static void search(Scanner scan, String[] arr) {

		String name = "";

		boolean flagsFirst = true;
		System.out.println("请输入姓名(输入exit退出):");
		do {
			name = scan.next();
			if (!name.equals("exit")) {
				for (String worker : arr) {
					if (worker.contains(name)) {
						if (flagsFirst == true) {
							System.out.println("Id\t姓名\t\t性 别\t工 资");
							flagsFirst = false;
						}
						String[] info = worker.split("-");
						System.out.println(
								info[0] + "\t" + String.format("%1$-8s", info[1]) + "\t" + info[2] + "\t" + info[3]);
					}
				}

				if (flagsFirst) {
					System.out.println("查无此人,重新查找或退出程序.");
				} else {
					break;
				}
			} else {
				break;
			}
		} while (true);
	}

	static void findMoney(String[] arr) {

		boolean flagsFirst = true;
		for (String worker : arr) {
			String[] info = worker.split("-");
			if (Integer.parseInt(info[3]) > 15000 && Integer.parseInt(info[3]) < 20000) {
				if (flagsFirst == true) {
					System.out.println("Id\t姓名\t\t性 别\t工 资");
					flagsFirst = false;
				}
				System.out.println(
						info[0] + "\t" + String.format("%1$-8s", info[1]) + "\t" + info[2] + "\t" + info[3]);

			}
		}
	}

	static void findMaxAndMin(String[] arr) {

		int maxIndex = 0;
		int minIndex = 0;

		int max = Integer.parseInt(arr[0].split("-")[3]);
		int min = Integer.parseInt(arr[0].split("-")[3]);

		for (int i = 0; i < arr.length; i++) {
			String[] info = arr[i].split("-");

			if (Integer.parseInt(info[3]) > max) {
				maxIndex = i;
			}
			if (Integer.parseInt(info[3]) < min) {
				minIndex = i;
			}

		}

		String maxInfo = arr[maxIndex].split("-")[1];
		String minInfo = arr[minIndex].split("-")[1];

		System.out.println("工资最高的人是:" + maxInfo + ";\n工资最低的人是:" + minInfo);
	}

	static void findMale(String[] arr) {
		System.out.println("Id\t姓名\t\t性 别\t工 资");
		for (String worker : arr) {
			String[] info = worker.split("-");
			if (info[2].equals("女")) {
				System.out.println(info[0] + "\t" + String.format("%1$-8s", info[1]) + "\t" + info[2] + "\t" + info[3]);
			}
		}
	}
}
