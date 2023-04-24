package week1.day3;

public class Job4 {
    public static void main(String[] args) {
        int incomes[] = { 5000, 4500, 12000, 9000, 2500, 6000, 7500, 8000, 9000 };
        int index[] = new int[9];

        int count = 0;
        int countSelf = 0;
        int sum = 0;
        double avg = 0;

        for (int i = 0; i < incomes.length; i++) {
            if (incomes[i] > 5000) {
                sum += incomes[i];
                index[i] = 1;
                count++;
            }
        }
        if (count > 0) {
            avg = (double) sum / count;
            System.out.println("工资大于5000的员工的平均工资为:" + avg);
            System.out.print("工资大于5000的员工为第");
            for (int i = 0; i < index.length; i++) {
                if (index[i] == 1) {
                    countSelf++;
                    if (countSelf < count) {
                        System.out.print((i + 1) + ",");
                    } else {
                        System.out.print((i + 1));
                    }
                }
            }
            System.out.println("位");
        } else {
            System.out.println("暂无工资大于5000的员工");
        }

    }
}
