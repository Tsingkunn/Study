package practice.Preview;

/**
 * 打印九九乘法表
 */
public class Job10 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i <= j) {
                    System.out.print(i + "*" + j + "=" + i * j + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i >= j) {
                    System.out.print(i + "*" + j + "=" + i * j + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 9; i > 0; i--) {
            for (int j = 9; j > 0; j--) {
                if (i <= j) {
                    System.out.print(i + "*" + j + "=" + i * j + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 9; i > 0; i--) {
            for (int j = 9; j > 0; j--) {
                if (i >= j) {
                    System.out.print(i + "*" + j + "=" + i * j + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

        for (int i = 9; i > 0; i--) {
            for (int j = 1; j < 10; j++) {
                if (i >= j) {
                    System.out.print(i + "*" + j + "=" + i * j + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 9; j > 0; j--) {
                if (i >= j) {
                    System.out.print(i + "*" + j + "=" + i * j + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
