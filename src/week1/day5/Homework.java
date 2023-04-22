package week1.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 第一周周六练习
 * <p>
 * 1、 查看所有车辆信息。<br>
 * 2、 新增一条车辆信息。(车辆编号和款式不能重复)<br>
 * 3、 根据编号删除指定的车辆。<br>
 * 4、 查询所有的"中型"汽车信息。<br>
 * 5、 计算出是"SUV"结构的汽车的平均价格。<br>
 * 6、 找出"比亚迪"品牌中价格最高的车辆信息。<br>
 * 7、 有哪些汽车售价超过"20万"。<br>
 * 8、 根据编号查询车辆信息。<br>
 * 9、 上述数据中车辆有几种品牌，不同的品牌的车辆分别有几辆？<br>
 */

public class Homework {
    //汽车编号    品牌     款式     售价      类型      车身结构
    //20231122   奔驰    GLC      400000    中型      SUV
    //0          1       2        3         4        5
    static String[] vehicles = {
            "20231122-奔驰-GLC-400000-中型-SUV",
            "20231123-比亚迪-护卫舰07-202800-中型-SUV",
            "20231124-比亚迪-汉-197800-中型-轿车",
            "20231125-特斯拉-Model Y-261900-中型-SUV",
            "20231126-比亚迪-海豚-116800-小型-轿车"};
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // 循环控制器
        boolean isLoop = true;

        while (isLoop) {
            // 每次操作结束都展示首页面
            showMainPage();

            int selection = scan.nextInt();
            switch (selection) {
                // 查看全部信息
                case 1 -> {
                    String[] vehicles = queryAllVehicles();
                    // 打印表头信息
                    printInfo();
                    // 打印详细信息
                    printInfo(vehicles);
                }
                // 新增一条车辆信息.
                case 2 -> {
                    // 输入车辆编号
                    printInfo("请输入车辆编码:");
                    int vid = scan.nextInt();

                    // 判断编号是否存在
                    if (!isIdExist(vid)) {
                        // 如果不存在,让用户输入"品牌"/"款式"/"价格"/"类型"/"结构"信息
                        printInfo("请输入车辆品牌");
                        String vBrand = scan.next();
                        printInfo("请输入车辆款式");
                        String vType = scan.next();
                        printInfo("请输入车辆价格");
                        int vCost = scan.nextInt();
                        printInfo("请输入车辆类型");
                        String vSize = scan.next();
                        printInfo("请输入车辆车身结构");
                        String vStructure = scan.next();

                        // 拼接车俩信息,以便存入数组种
                        String vehicle = integratedInfo(vid, vBrand, vType, vCost, vSize, vStructure);

                        // 调用添加方法,如果添加成功返回true
                        if (addVehicle(vehicle)) {
                            printInfo("添加车辆信息成功!");
                        } else {
                            printInfo("添加车辆信息失败,请重试!");
                        }
                    } else {
                        // 如果编号已存在,提示提示信息
                        printInfo("车辆编号已存在,请重试!!");
                    }
                }
                // 根据编号删除指定的车辆.
                case 3 -> {
                    // 输入车辆编号
                    printInfo("请输入要删除车辆的编号:");
                    int vid = scan.nextInt();

                    // 判断编号是否存在
                    if (isIdExist(vid)) {
                        // 如果编号存在,调用删除方法,如果删除成功返回true
                        printInfo(deleteVehicleByVid(vid) ? "删除车辆信息成功" : "删除失败,请重试!");
                    } else {
                        // 如果编号不存在,提示提示信息.
                        printInfo("暂无该车辆信息!");
                    }
                }
                // 查询所有的"中型"汽车信息.
                case 4 -> {
                    // 调用查询方法查询所有车辆信息保存到变量vehicleArr中
                    String[] vehiclesArr = queryVehiclesByMiddleSize();
                    // 判断是否查询到数据
                    if (vehiclesArr.length != 0) {
                        // 如果查询到有数据据,调用输出方法,格式化输出打印
                        printInfo("查询到\"中型\"汽车信息如下:");
                        printInfo();
                        printInfo(vehiclesArr);
                    } else {
                        // 如果查询到信息为空,提示用户信息
                        printInfo("未查询到\"中型\"汽车");
                    }
                }
                // 计算出是"SUV"结构的汽车的平均价格.
                case 5 -> {
                    // 调用方法计算SUV的平均价格
                    double suvAvg = calculateAvgByStructureSUV();
                    // 如果suv的平均价格大于0,打印平均价格;否则,提示用户提示信息
                    if (suvAvg != 0) {
                        printInfo("\"SUV\"结构的汽车的平均价格是" + suvAvg);
                    } else {
                        printInfo("信息中暂无\"SUV\"类型的汽车!");
                    }
                }
                // 找出"比亚迪"品牌中价格最高的车辆信息.
                case 6 -> {
                    // 找出最贵的比亚迪汽车
                    String vehicle = findMaxCostFromBYD();
                    // 将该信息转换成只有一个元素的数组,便于格式化输出
                    String[] info = {vehicle};
                    // 判断数组中是否有比亚迪汽车
                    if (vehicle.length() != 0) {
                        // 如果有比亚迪汽车,打印信息
                        printInfo("\"比亚迪\"品牌中价格最高的车辆信息为:\n");
                        printInfo();
                        printInfo(info);
                    } else {
                        // 如果数组中暂无比亚迪汽车,打印提示信息
                        printInfo("暂无\"比亚迪\"车辆信息!");
                    }
                }
                // 有哪些汽车售价超过"20万".
                case 7 -> {
                    // 获取超过20万售价的汽车,存入变量中
                    String[] vehicles = queryVehiclesByCost();

                    // 判断有没有超过20万售价的汽车
                    if (vehicles.length > 0) {
                        //若有,打印信息
                        printInfo("售价超过20万的汽车信息如下:");
                        printInfo();
                        printInfo(vehicles);
                    } else {
                        // 若没有,打印提示信息
                        printInfo("暂无售价超过20万的汽车!");
                    }
                }
                // 根据编号查询车辆信息.
                case 8 -> {
                    // 提示用户输入信息,并接收编号信息
                    printInfo("请输入要查询的汽车信息的编号:");
                    int vid = scan.nextInt();
                    // 调用方法查询该编号汽车信息
                    String vehicle = findVehicleByVid(vid);
                    // 转存为只有一个元素的数组,便于格式化打印
                    String[] info = {vehicle};

                    // 判断是否有该汽车信息
                    // 如果接收到的汽车信息的字符串长度大于零,代表有数据;反之,则无,打印提示信息
                    if (vehicle.length() > 0) {
                        printInfo("编号 " + vid + " 的汽车信息如下:");
                        printInfo();
                        printInfo(info);
                    } else {
                        printInfo("编号输入有误!!");
                    }
                }
                // 查询不同品牌车辆的车辆信息
                case 9 -> {
                    // 查询车辆品牌,记数,并存储相应信息.详细操作见 queryVehicleByKinds() 方法.
                    List<String[]> veKindsArr = queryVehicleByKinds();

                    if (veKindsArr.size() > 0) {
                        printInfo("汽车品牌共有:" + veKindsArr.size() + " 种.\n");

                        // 打印每种品牌的数量与详细信息
                        for (String[] strings : veKindsArr) {
                            printInfo("品牌为: " + getVehicleBrand(strings[0]) + " 的种类有 " + strings.length + " 种");
                            printInfo();
                            printInfo(strings);
                        }
                    } else {
                        printInfo("系统异常!");
                    }
                }
                // 输入-1,退出系统
                case -1 -> isLoop = false;
                default -> System.out.println("此功能正在研发中...");
            }
        }
    }

    /**
     * 显示首页提示信息
     */
    public static void showMainPage() {
        System.out.println("""
                *     ...主界面...
                * 1、 查看所有车辆信息.
                * 2、 新增一条车辆信息.(车辆编号和款式不能重复)
                * 3、 根据编号删除指定的车辆.
                * 4、 查询所有的"中型"汽车信息.
                * 5、 计算出是"SUV"结构的汽车的平均价格.
                * 6、 找出"比亚迪"品牌中价格最高的车辆信息.
                * 7、 有哪些汽车售价超过"20万".
                * 8、 根据编号查询车辆信息.
                * 9、 查询不同品牌车辆的车辆信息.
                *     ...按-1退出系统...
                """);
    }

    /**
     * 1. 查询所有汽车信息
     *
     * @return 汽车信息数组
     */
    public static String[] queryAllVehicles() {
        return vehicles;
    }

    /**
     * 2. 添加车辆信息
     * <p>
     * 调用 {@link Homework#addElement(String)} 方法
     *
     * @param vehicle 整合好的车辆信息字符串
     * @return 是否添加成功, 添加成功返回true;反之,返回false
     */
    public static boolean addVehicle(String vehicle) {
        return addElement(vehicle);
    }

    /**
     * 3. 删除车辆信息
     * <p>
     * 1.先根据vid获取到此编号的数组下标index,调用{@link Homework#getIndexByVid(int)}<br>
     * 2.根据下标删除对应汽车信息元素,调用{@link Homework#deleteElement(int)}<br>
     *
     * @param vid 车辆编号
     * @return 是否删除成功;删除成功,返回true;否则,返回false
     */
    public static boolean deleteVehicleByVid(int vid) {
        int index = getIndexByVid(vid);
        return deleteElement(index);
    }

    /**
     * 4. 查询所有的"中型"汽车信息.
     * <p>
     * 定义一个字符串数组,用来存放"中型"汽车信息.
     * 遍历有全部汽车信息的数组,判断是否为中型,若为中型,则添加到"中型"汽车信息字符串数组中
     *
     * @return "中型"汽车信息的字符串数组
     */
    public static String[] queryVehiclesByMiddleSize() {
        String[] vehicleArr = {};
        for (String vehicle : vehicles) {
            if (getVehicleSize(vehicle).equals("中型")) {
                vehicleArr = addElement(vehicleArr, vehicle);
            }
        }
        return vehicleArr;
    }

    /**
     * 5. 计算SUV的平均价格
     * <p>
     * 定义一个变量sum,存放所有SUV汽车价格总和;定义一个变量suvCount,用来存放SUV汽车数量;
     * 遍历全部汽车信息的数组,记录SUV价格总和数量.sum / suvCount的值即为平均值
     *
     * @return 如果suvCount不为0, SUV价格平均值;若suvCount为0,返回0;
     */
    public static double calculateAvgByStructureSUV() {
        double sum = 0.0;
        int suvCount = 0;
        for (String vehicle : vehicles) {
            if (getVehicleStructure(vehicle).equals("SUV")) {
                sum += getVehicleCost(vehicle);
                suvCount++;
            }
        }
        if (suvCount != 0) {
            return sum / suvCount;
        } else {
            return 0;
        }
    }

    /**
     * 6. 查找"比亚迪"中售价最高的
     * <p>
     * 定义变量max初始值-1存储最高售价.
     * 定义变量vehicle存储当前车辆信息.
     * 遍历数组,比对出售价最高的车辆信息
     * <p>
     * 遍历,
     *
     * @return 售价最高的车辆信息, 若无比亚迪汽车, 则返回空字符串
     */
    public static String findMaxCostFromBYD() {
        String vehicle = "";
        int max = -1;
        for (String v : vehicles) {
            if (getVehicleBrand(v).equals("比亚迪")) {
                if (max < getVehicleCost(v)) {
                    vehicle = v;
                }
            }
        }
        return vehicle;
    }

    /**
     * 7. 找出售价20万以上的车辆信息
     * <p>
     * 定义一个用来存放车辆信息的空字符串数组.<br>
     * 遍历数组,每次遇到售价超20万的车辆,将其信息存储到此空字符串数组中.<br>
     * <p>
     * 空字符串数组追加新的元素,详情 {@link Homework#addElement(String[], String)}
     *
     * @return 售价20万以上的车辆信息字符串数组
     */
    public static String[] queryVehiclesByCost() {
        String[] vehicleArr = {};
        for (String vehicle : vehicles) {
            if (getVehicleCost(vehicle) > 200000) {
                vehicleArr = addElement(vehicleArr, vehicle);
            }
        }
        return vehicleArr;
    }

    /**
     * 8. 根据编号查询车辆信息
     * <p>
     * 定义一个字符串变量vehicle来存储查询到的车辆信息,默认为空字符串<br>
     * 遍历数组,比对每一个车辆标号信息是否与用户输入的相等.若相等,则将车辆信息赋值vehicle,并结束遍历<br>
     * <p>
     * 关于获取每条车辆信息的车辆编号,详见 {@link Homework#getVid(String)}
     *
     * @param vid 用户输入的车辆编码
     * @return 若编码存在, 则返回车辆信息字符串;反之,则返回空字符串
     */
    public static String findVehicleByVid(int vid) {
        String vehicle = "";
        for (String v : vehicles) {
            if (getVid(v) == vid) {
                vehicle = v;
                break;
            }
        }
        return vehicle;
    }

    /**
     * 9. 数据中车辆有几种品牌，并统计不同的品牌的车辆数量<br>
     * <br>
     * 方法中定义了一个动态数组 {@code ArrayList} veKindsArr的数组<br>
     * veKindsArr 中的每一项都用数组 {@code String} arr都存储了一个关于某一品牌数量统计的全部信息<br>
     * veKindsArr 的格式为:{arr1, arr2,arr3,....}<br>
     * arr 的具体存储形式为: arr = {"品牌汽车1详细信息","品牌汽车2详细信息",...}<br>
     *
     * @return 类型为String[]的 veKindsArr, 用于存放所有数据,返回 {@code List<String[]> }
     */
    public static List<String[]> queryVehicleByKinds() {

        List<String[]> veKindsArr = new ArrayList<>();

        // 用于记录的ArrayList中是否有该车辆品牌信息
        boolean exist = false;
        // 用于记有存放同一品牌arr数组在 veKindsArr 中的下标
        int index = -1;

        // 这两侧for循环的含义为: 每遍历车辆信息数组vehicles的每一次,都要与veKindsArr中的已存在的每一个品牌做比对
        // 遍历一边vehicles数组数据,
        for (String vehicle : vehicles) {
            // 如果存在,变量index记录当前ArrayList的下标,exit标识已存在当前品牌,并break当前ArrayList的循环
            for (int j = 0; j < veKindsArr.size(); j++) {
                String existingBrand = getVehicleBrand(veKindsArr.get(j)[0]);
                String currentBrand = getVehicleBrand(vehicle);
                // 判断"品牌是否存在"
                // 如果遍历vehicles的当前车辆品牌,已经被veKindsArr记录,则返回true,代表已经存入该品牌;反之,代表该品牌是一个新品牌
                if (currentBrand.equals(existingBrand)) {
                    index = j;
                    exist = true;
                    break;
                }
            }
            // 判断当前vehicle是否存在于veKindsArr中
            // 若存在,该品牌记数+1,该品牌数据数组末尾追加当前vehicle信息
            if (exist) {
                // 在ArrayList中获取该品牌汽车的全部信息;
                String[] veArrTemp = veKindsArr.get(index);
                // 将新的vehicle数据拼接到已有数组arr之后
                veArrTemp = addElement(veArrTemp, vehicle);
                // 更新对应下标的ArrayList数据
                veKindsArr.set(index, veArrTemp);
            } else {
                // 若不存在,新建一个该品类的车辆信息,格式为{"车辆信息"}
                String[] newVeArr = {vehicle};
                // 添加到ArrayList之中
                veKindsArr.add(newVeArr);
            }
            // 每一次的vehicles循环,都是新的车辆信息,要重置exist标记信息.
            exist = false;
        }
        // 返回数据信息
        return veKindsArr;
    }

    /**
     * 打印信息表头
     * <p>
     * 格式如下:
     * 编号   品牌  款式  价格  类型  车身结构
     */
    private static void printInfo() {
        String[] title = {"编号", "品牌", "款式", "价格", "类型", "车身结构"};
        for (String t : title) {
            // "%-12s" 的含义为从左开始,补全字符串,补全长度为12个字符,长度不足12个字符则用空格填充
            System.out.printf("%-12s\t", t);
        }
        System.out.println();
    }

    /**
     * 打印详细汽车信息,按照规定格式输出
     * <p>
     * 具体格式如下:
     * 20231122 奔驰  GLC 400000  中型  SUV
     *
     * @param arr 汽车信息数组
     */
    private static void printInfo(String[] arr) {
        for (String str : arr) {
            String[] split = str.split("-");
            for (String s : split) {
                System.out.printf("%-12s\t", s);
            }
            System.out.println();
        }
    }

    /**
     * 打印字符串信息
     * <p>
     * 等同于System.out.println(String);
     *
     * @param str 需要打印的字符串信息
     */
    private static void printInfo(String str) {
        System.out.println(str);
    }

    /**
     * 查询车辆编码是否存在
     * <p>
     * 遍历数组,对比每条数组的车辆编码与用户输入的是否一致.
     * <p>
     * 获取数据车辆信息编码,详见 {@link Homework#getVid(String)}
     *
     * @param vId 用户输入的车辆编号
     * @return 如果vid存在, 返回true;反之,返回false
     */
    private static boolean isIdExist(int vId) {
        for (String vehicle : vehicles) {
            if (getVid(vehicle) == vId) {
                return true;
            }
        }
        return false;
    }

    /**
     * 车辆信息字符串截取车辆信息的编码
     *
     * @param vehicle 单条车辆信息字符串
     * @return 车辆信息编码
     */
    private static int getVid(String vehicle) {
        return Integer.parseInt(vehicle.split("-")[0]);
    }

    /**
     * 车辆信息字符串截取车辆信息的品牌
     *
     * @param vehicle 单条车辆信息字符串
     * @return 车辆品牌信息
     */
    private static String getVehicleBrand(String vehicle) {
        return vehicle.split("-")[1];
    }

    /**
     * 车辆信息字符串截取车辆信息的价格
     *
     * @param vehicle 单条车辆信息字符串
     * @return 车辆的售价信息
     */
    private static int getVehicleCost(String vehicle) {
        return Integer.parseInt(vehicle.split("-")[3]);
    }

    /**
     * 车辆信息字符串截取车辆信息的类型
     *
     * @param vehicle 单条车辆信息字符串
     * @return 车辆的类型信息
     */
    private static String getVehicleSize(String vehicle) {
        return vehicle.split("-")[4];
    }

    /**
     * 车辆信息字符串截取车辆信息的结构
     *
     * @param vehicle 单条车辆信息
     * @return 车辆的结构信息
     */
    private static String getVehicleStructure(String vehicle) {
        return vehicle.split("-")[5];
    }

    /**
     * 根据输入的车辆编码,获取该车辆的在车辆信息数组中的下标
     *
     * @param vid 车辆编码
     * @return 若此编码存在, 返回该编码在车辆信息数组中的下标;反之,返回-1.
     */
    private static int getIndexByVid(int vid) {
        int index = -1;
        for (int i = 0; i < vehicles.length; i++) {
            if (getVid(vehicles[i]) == vid) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 拼接车辆信息,将其整合为标准的车辆信息字符串
     *
     * @param vId        车辆编码
     * @param vBrand     车辆品牌
     * @param vType      车辆款式
     * @param vCost      车辆价格
     * @param vSize      车辆类型
     * @param vStructure 车辆结构
     * @return 标准车辆信息字符串
     */
    private static String integratedInfo(int vId, String vBrand, String vType, double vCost, String vSize, String vStructure) {
        return vId + "-" + vBrand + "-" + vType + "-" + vCost + "-" + vSize + "-" + vStructure;
    }

    /**
     * 向车辆信息数组中追加车辆信息
     *
     * @param vehicle 单条车辆信息字符串
     * @return 若添加成功, 返回true;反之,返回false
     */
    private static boolean addElement(String vehicle) {
        int oldLen = vehicles.length;
        // 扩容
        vehicles = Arrays.copyOf(vehicles, vehicles.length + 1);
        // 末位追加数据
        vehicles[vehicles.length - 1] = vehicle;
        int newLen = vehicles.length;

        return newLen == ++oldLen;
    }

    /**
     * 向特定车辆信息数组中追加车辆信息
     *
     * @param vehicles 特定的,存储车辆信息的数组
     * @param vehicle  单条车辆信息
     * @return 在末尾追加新的车辆信息的数组
     */
    private static String[] addElement(String[] vehicles, String vehicle) {
        // 扩容
        vehicles = Arrays.copyOf(vehicles, vehicles.length + 1);
        // 添加新元素
        vehicles[vehicles.length - 1] = vehicle;
        return vehicles;
    }

    /**
     * 根据下标删除元素
     *
     * @param index 数组下标
     * @return 删除成功, 返回true;否则,返回false
     */
    private static boolean deleteElement(int index) {
        int oldLen = vehicles.length;
        System.arraycopy(vehicles, index + 1, vehicles, index, vehicles.length - index - 1);
        vehicles = Arrays.copyOf(vehicles, vehicles.length - 1);
        int newLen = vehicles.length;
        return oldLen == ++newLen;
    }

}
