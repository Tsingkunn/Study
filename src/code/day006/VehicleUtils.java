package code.day006;

public class VehicleUtils {

    /**
     * 打印信息表头
     * <p>
     * 格式如下:
     * 编号   品牌  款式  价格  类型  车身结构
     */
    public static void printInfo() {
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
    public static void printInfo(Vehicle[] arr) {
        for (Vehicle vehicle : arr) {
            printInfo(vehicle.toString());
        }
    }

    /**
     * 打印字符串信息
     * <p>
     * 等同于System.out.println(String);
     *
     * @param str 需要打印的字符串信息
     */
    public static void printInfo(String str) {
        System.out.println(str);
    }

}
