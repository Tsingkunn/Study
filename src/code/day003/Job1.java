package code.day003;

/**
 * 找出200 - 500之间所有能够整除5的数字，打印在控制台，每行5个。
 */
public class Job1 {
    public static void main(String[] args) {
        for (int i = 200, j = 0; i <= 500; i++) {
            if (i % 5 == 0) {
                System.out.print(i + "\t");
                j++; // 只有是5的倍数,j才++
                if (j % 5 == 0) {
                    System.out.println();
                }
            }
        }
    }
}
