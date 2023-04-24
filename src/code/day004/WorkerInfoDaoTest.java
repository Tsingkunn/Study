package code.day004;

import java.util.Scanner;

public class WorkerInfoDaoTest {
    public static void main(String[] args) {

        boolean isLoop = true;
        try (Scanner scan = new Scanner(System.in)) {
            int selection = -1;
            // String quit = "";
            WorkerInfoDao workerDao = new WorkerInfoDao();
            String[] arr = {};
            while (isLoop) {
                showMainPage();
                selection = scan.nextInt();
                switch (selection) {
                    case 1 -> {
                        arr = workerDao.showAll();
                        System.out.println("Id\t姓名\t\t性 别\t工 资");
                        for (String worker : arr) {
                            String[] info = worker.split("-");
                            System.out.println(info[0] + "\t" + String.format("%1$-8s", info[1]) + "\t" + info[2] + "\t"
                                    + info[3]);
                        }
                    }
                    case 2 -> {
                        WorkerInfoBean workerBean = new WorkerInfoBean();

                        workerBean.setId(123);
                        workerBean.setName("李逍遥");
                        workerBean.setGender("男");
                        workerBean.setSalary(30000);
                        System.out.println(workerBean.toString());
                        if (workerDao.addWorkerInfo(workerBean)) {
                            System.out.println("添加信息成功!");
                        } else {
                            System.out.println("添加信息失败");
                        }
                    }
                    case 3 -> {
                        System.out.println("请输入要修改的下标:");
                        int index = scan.nextInt();
                        System.out.println("请输入改成的姓名:");
                        String name = scan.next();
                        boolean done = workerDao.updateWorkerName(index, name);
                        if (done) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败!");
                        }
                    }
                    case 4 -> {
                        int index = scan.nextInt();
                        boolean done = workerDao.deleteWorkerInfo(index);
                        if (done) {
                            System.out.println("删除成功!");
                        } else {
                            System.out.println("删除失败!");
                        }
                    }
                    case 5 -> {
                        System.out.println("请输入查询信息:");
                        String name = scan.next();
                        String[] workers = workerDao.queryWorkerByNameLike(name);
                        for (String worker : workers) {
                            System.out.println(worker);
                        }
                    }
                }
            }
        }
    }

    static void showMainPage() {
        System.out.println(""
                + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n"
                + "┃\t主菜单\t\t\t┃\n"
                + "┃1. 查询完整名单\t\t┃\n"
                + "┃2. 新增员工信息\t\t┃\n"
                + "┃3. 更改员工信息\t\t┃\n"
                + "┃4. 删除员工信息\t\t┃\n"
                + "┃5. 模糊查找员工信息\t\t┃\n"
                + "┃6. 找出工资在15k-20k之间的员工\t┃\n"
                + "┃7. 查询工资最高/最低的员工\t┃\n"
                + "┃8. 查询女员工信息\t\t┃\n"
                + "┃...请选择对应操作...\t\t┃\n"
                + "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

    }
}
