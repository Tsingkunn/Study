package week1.day001;

public class Homework1 {
    public static void main(String[] args) {

        // 输出直角三角形
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i > j) {
                    System.out.print("* ");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

        // 输出等腰三角形
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < (2 * (i + 1) - 1); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // 输出如图中的的信息
        System.out.println("*\t*\t*\t*\t*\t*\t*");
        System.out.println("*\t*\t*控制台计算器:\t*\t*\t*");
        System.out.println("*\t*\t*\t*\t*\t*\t*");

    }
}