package code.day005;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1、查看所有账户信息(10分)
 * 2、新增一条账户信息(10分)
 * 3、手动输入下标，根据下标修改账户姓名(10分)
 * 4、输入一个下标，删除该下标的账户信息(10分)
 * 5、查询指定编号的账户信息(10分)
 * 6、查询所有性别是"女"的账户信息(10分)
 * 7、找出所有姓"杨"的账户信息(10分)
 * 8、找出余额最高的那个账户信息(10分)
 * 9、找出电话号码以"150"开头的账户信息(10分)
 * 10、统计处不同性别的人数，并且显示出这个性别的所有账户信息(10分)
 */
public class Exam0421 {

    static String[] people = {"20230111-李朝宗-男-15067682233-30899", "20230112-杨星阑-男-15067682255-60000",
            "20230113-唐碗儿-女-15067682266-18899", "20230114-杨婉柔-女-15367682277-60000"};

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {


        boolean isLoop = true;
        while (isLoop) {
            showMainPage();
            int selection = scan.nextInt();
            switch (selection) {
                case 1 -> queryAllInfo();
                case 2 -> addPersonInfo();
                case 3 -> updatePersonNameByIndex();
                case 4 -> deletePersonInfoByIndex();
                case 5 -> findPersonByUid();
                case 6 -> queryPersonByFemale();
                case 7 -> queryPersonByFamilyName();
                case 8 -> findPersonByMaxBalance();
                case 9 -> queryPersonInfoByTelStartedWith();
                case 10 -> queryAndCountPersonInfoByGender();
                case 11 -> queryCountInfoByGender();
                case -1 -> isLoop = false;
                default -> System.out.println("此功能尚未开发...");
            }
        }
        System.out.println("已退出账户管理系统");
    }

    /**
     * 显示主界面
     */
    public static void showMainPage() {
        System.out.print("""
                        主菜单
                 1、查看所有账户信息
                 2、新增一条账户信息
                 3、根据下标修改账户姓名
                 4、删除该下标的账户信息
                 5、查询指定编号的账户信息
                 6、查询所有性别是"女"的账户信息
                 7、找出所有姓"杨"的账户信息
                 8、找出余额最高的那个账户信息
                 9、找出电话号码以"150"开头的账户信息
                 10、统计处不同性别的人数，并且显示出这个性别的所有账户信息
                 11.
                        按-1退出系统
                """);
    }

    /**
     * 1.查看所有账户信息
     */
    public static void queryAllInfo() {
        // 遍历
        for (String per : people) {
            // 控制台打印
            System.out.println(per);
        }
    }

    /**
     * 2.新增一条账户信息
     */
    public static void addPersonInfo() {
        // 输入id
        System.out.println("请输入用户id: ");
        int uid = scan.nextInt();

        // 判断uid是否合法
        if (isIdValid(uid)) {
            // 提示并输入姓名
            System.out.println("请输入姓名;");
            String name = scan.next();

            // 提示并输入性别
            System.out.println("请输入性别");
            String gender = scan.next();

            // 判断性别输入是否合理
            if (isGenderValid(gender)) {

                // 提示并输入电话号码和余额
                System.out.println("请输入电话号码:");
                long tel = scan.nextLong();
                System.out.println("请输入用户余额:");
                int balance = scan.nextInt();

                // 拼接账户信息
                String personInfo = uid + "-" + name + "-" + gender + "-" + tel + "-" + balance;

                // 调用addElement方法来添加新元素(人员信息)
                people = addElement(people, personInfo);

                System.out.println("添加信息成功!");
            } else {
                System.out.println("输入的性别不合理.");
            }
        } else {
            System.out.println("此用户id已存在!");
        }
    }

    /**
     * 3、根据下标修改账户姓名
     */
    public static void updatePersonNameByIndex() {
        // 提示并输入需要修改信息的下标
        System.out.println("请输入需要修改姓名的下标");
        int index = scan.nextInt();

        // 判断下标是否合法
        if (isIndexValid(people, index)) {

            // 键入新的姓名
            System.out.println("请输入用户姓名:");
            String newName = scan.next();

            // 暂存旧姓名,用作提示信息
            String oldName = people[index].split("-")[1];

            // 拼接字符串
            String newInfo = people[index].split("-")[0] + "-" + newName + "-" + people[index].split("-")[2] + "-" +
                    people[index].split("-")[3] + "-" + people[index].split("-")[4];

            // 更新用户信息
            people[index] = newInfo;

            // 提示更新成功
            System.out.println("用户: " + oldName + " 已经修改为: " + newName);
        } else {
            System.out.println("输入的下标不合理!");
        }
    }

    /**
     * 4.输入一个下标，删除该下标的账户信息
     */
    public static void deletePersonInfoByIndex() {
        // 提示并输入需要修改信息的下标
        System.out.println("请输入需要删除人员的下标");
        int index = scan.nextInt();

        // 判断下标是否合法
        if (isIndexValid(people, index)) {
            //调用方法,删除该元素
            people = deleteElement(people, index);
        } else {
            System.out.println("输入下标有误!");
        }
    }

    /**
     * 5.查询指定编号的账户信息
     */
    public static void findPersonByUid() {
        // 提示并输入
        System.out.println("输入查询的账户id:");
        int uid = scan.nextInt();

        // 用于记录指定编号的下标,初始化为-1,默认不存在此人
        int index = -1;

        // 判断id是否存在
        if (!isIdValid(uid)) {
            // 遍历
            for (int i = 0; i < people.length; i++) {
                // 找到此uid的下标,记录下标到index中,并退出循环
                if (Integer.parseInt(people[i].split("-")[0]) == uid) {
                    index = i;
                    break;
                }
            }
            //输出
            System.out.println("查询到的任务信息为:");
            System.out.println(people[index]);
        } else {
            System.out.println("查无此人!");
        }
    }

    /**
     * 6.查询所有性别是"女"的账户信息
     */
    public static void queryPersonByFemale() {
        // 遍历
        for (String person : people) {
            // 拆分字符串,找到性别是女的人员信息
            if (person.split("-")[2].equals("女")) {
                // 打印到控制台
                System.out.println(person);
            }
        }
    }

    /**
     * 7.找出所有姓"杨"的账户信息
     */
    public static void queryPersonByFamilyName() {
        // 遍历
        for (String person : people) {
            // 拆分字符串,找到姓杨的
            if (person.split("-")[1].startsWith("杨")) {
                // 打印到控制台
                System.out.println(person);
            }
        }
    }

    /**
     * 8.找出余额最高的那个账户信息
     */
    public static void findPersonByMaxBalance() {
        // 默认最大值是第一个元素,并记录下标:0
        int max = Integer.parseInt(people[0].split("-")[4]);

        // 遍历
        for (int i = 1; i < people.length; i++) {
            // 每个用户的余额
            int balance = Integer.parseInt(people[i].split("-")[4]);
            // 遍历数组比较,找出最大值
            if (max < balance) {
                max = balance;
            }
        }

        // 输出信息
        System.out.println("余额最高的人的账户信息是:");

        for (String person : people) {
            if (Integer.parseInt(person.split("-")[4]) == max) {
                System.out.println(person);
            }
        }
    }

    /**
     * 9.找出电话号码以"150"开头的账户信息(10分)
     */
    public static void queryPersonInfoByTelStartedWith() {
        // 遍历
        for (String person : people) {
            // 拆分字符串,找到以150数字开头的
            if (person.split("-")[3].startsWith("150")) {
                // 打印到控制台
                System.out.println(person);
            }
        }
    }


    /**
     * 10.统计处不同性别的人数，并且显示出这个性别的所有账户信息
     * <p>
     * 固定男女性别写法
     */
    public static void queryAndCountPersonInfoByGender() {
        // 记录男女数量
        int maleCount = 0;
        int femaleCount = 0;
        // 分别存放男女信息的数组
        String[] maleInfo = {};
        String[] femaleInfo = {};

        // 遍历
        for (String person : people) {
            // 是男的,或者是女的,记数自增1,并且将信息存入到对应的数组中
            if (person.split("-")[2].equals("男")) {
                maleCount++;
                maleInfo = addElement(maleInfo, person);
            } else {
                femaleCount++;
                femaleInfo = addElement(femaleInfo, person);
            }
        }

        // 打印
        System.out.println("男性有 " + maleCount + " 人,为:");
        for (String per : maleInfo) {
            System.out.println(per);
        }
        System.out.println("女性有 " + femaleCount + " 人,为:");
        for (String per : femaleInfo) {
            System.out.println(per);
        }

        // 知道数组长度 ,但每次都在数组后面添加元素,可以不用找下标的方法,可以利用每次数组扩容的方式在数组最后面添加元素
    }

    /**
     * 10.统计不同性别人数,性别不定
     */
    public static void queryCountInfoByGender() {
        String[] genders = {};
        int[] counts = {};
        int count = 0;
        boolean exist = false;
        for (String person : people) {
            String perGender = person.split("-")[2];
            for (String gender : genders) {
                if (perGender.equals(gender)) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                genders = addElement(genders, perGender);
            }
            exist = false;
        }
        // 用要统计的信息在数据中遍历
        for (String gender : genders) {
            for (String person : people) {
                if (person.split("-")[2].equals(gender)) {
                    count++;
                }
            }
            counts = Arrays.copyOf(counts, counts.length + 1);
            counts[counts.length - 1] = count;
            count = 0;
        }

        System.out.println(Arrays.toString(genders));
        System.out.println(Arrays.toString(counts));
    }


    /**
     * 判断添加新用户时输入的id是否合法
     *
     * @param uid 键入的用户id
     * @return 如果uid不重复, 返回true;否则,返回false
     */
    private static boolean isIdValid(int uid) {
        for (String per : people) {
            // 遍历数组每一个用户的uid,与用户输入的uid做比对
            if (Integer.parseInt(per.split("-")[0]) == uid) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断用户输入的性别是否是合法的.
     *
     * @param gender 用户输入的性别
     * @return 如果性别是"男"或"女",则为有效输入,返回true;否则,返回false
     */
    private static boolean isGenderValid(String gender) {
        return gender.equals("男") || gender.equals("女");
    }


    /**
     * 判断输入的数组下标是否合理
     *
     * @param arr   输入的数组
     * @param index 输入数组的相应的下标
     * @return 如果下标没有越界, 返回true;否则,返回false
     */
    private static boolean isIndexValid(String[] arr, int index) {
        return index >= 0 && index < arr.length;
    }

    /**
     * 在一组数组后追加新的元素.
     *
     * @param arr 需要添加新元素的数组
     * @param e   新的元素
     * @return 返回一个已经添加完成新元素的新数组
     */
    private static String[] addElement(String[] arr, String e) {
        // 扩容
        arr = Arrays.copyOf(arr, arr.length + 1);
        // 添加新元素
        arr[arr.length - 1] = e;
        return arr;
    }


    /**
     * 根据输入的数组下标删除对应的元素
     *
     * @param arr   需要删除元素的数组
     * @param index 需要删除元素的下标
     * @return 返回一个新的数组
     */
    private static String[] deleteElement(String[] arr, int index) {
        System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1);
        arr = Arrays.copyOf(arr, arr.length - 1);
        return arr;
    }
}
