package week1.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class VehicleDao {

    static Vehicle[] vehicles = VehicleData.vehicles;

    /**
     * 1. 查询所有汽车信息
     *
     * @return 汽车信息数组
     */
    public static Vehicle[] queryAllVehicles() {
        return vehicles;
    }

    /**
     * 2. 添加车辆信息
     * <p>
     *
     * @param vehicle 需要添加到数据中的车辆信息
     * @return 是否添加成功, 添加成功返回true;反之,返回false
     */
    public static boolean insertVehicleMsg(Vehicle vehicle) {
        return addElement(vehicle);
    }

    /**
     * 3. 删除车辆信息
     * <p>
     *
     * @param vid 车辆编号
     * @return 是否删除成功;删除成功,返回true;否则,返回false
     */
    public static boolean deleteVehicleByVid(String vid) {
        int index = getIndexByVid(vid);
        return deleteElement(index);
    }

    /**
     * 4. 查询所有的某类型汽车信息.
     * <p>
     *
     * @return 若有该类型,返回该类型汽车信息的数组;若无该类型,返回null
     */
    public static Vehicle[] queryVehiclesByMiddleSize(String vType) {
        Vehicle[] vehicleArr = {};

        for (Vehicle vehicle : vehicles) {
            if (vehicle.type.equals(vType)) {
                vehicleArr = addElement(vehicleArr, vehicle);
            }
        }
        return vehicleArr;
    }

    /**
     * 5. 计算某类结构的平均价格
     * 
     * @param vStructure 汽车的结构信息
     * @return 若有该结构类型,返回此类型的汽车的平均值;若无,返回0
     */
    public static double calculateAvgByStructure(String vStructure) {
        double sum = 0.0;
        int suvCount = 0;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.structure.equals(vStructure)) {
                sum += vehicle.cost;
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
     * 6. 查找某品牌中售价最高的
     *
     * @return 返回售价最高的车辆信息数组,;若无该类型汽车, 则返回空数组
     */
    public static Vehicle[] findMaxCostFromBrand(String vBrand) {
        Vehicle[] vArr = {};
        Vehicle[] arr = {};
        double max = -1;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.brand.equals(vBrand)) {
                if (max < vehicle.cost) {
                    vArr = arr;
                    vArr = addElement(vArr, vehicle);
                    max = vehicle.cost;
                } else if (max == vehicle.cost) {
                    vArr = addElement(vArr, vehicle);
                }
            }
        }
        return vArr;
    }

    /**
     * 7. 找出售价20万以上的车辆信息
     * <p>
     * 定义一个用来存放车辆信息的数组.<br>
     * 遍历数组,每次遇到售价超20万的车辆,将其信息存储到此数组中.<br>
     *
     * @return 售价20万以上的车辆信息字符串数组
     */
    public static Vehicle[] queryVehiclesByCost() {
        Vehicle[] vehicleArr = {};
        for (Vehicle vehicle : vehicles) {
            if (vehicle.cost > 200000) {
                vehicleArr = addElement(vehicleArr, vehicle);
            }
        }
        return vehicleArr;
    }

    /**
     * 8. 根据编号查询车辆信息
     *
     * @param vid 用户输入的车辆编码
     * @return 若编码存在, 则返回车辆信息;反之,则返回null
     */
    public static Vehicle findVehicleByVid(String vid) {
        Vehicle vehicle = null;
        for (Vehicle v : vehicles) {
            if (Objects.equals(v.vid, vid)) {
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
     * veKindsArr 中的每一项都用数组 {@code Vehicle} arr都存储了一个关于某一品牌数量统计的全部信息<br>
     * veKindsArr 的格式为:{arr1, arr2,arr3,....}<br>
     * arr 的具体存储形式为: arr = {"品牌汽车1详细信息","品牌汽车2详细信息",...}<br>
     *
     * @return 类型为Vehicle[]的 veKindsArr, 用于存放所有数据,返回 {@code List<Vehicle[]> }
     */
    public static List<Vehicle[]> queryVehicleByKinds() {

        List<Vehicle[]> veKindsArr = new ArrayList<>();

        // 用于记录的ArrayList中是否有该车辆品牌信息
        boolean exist = false;
        // 用于记有存放同一品牌arr数组在 veKindsArr 中的下标
        int index = -1;

        // 这两侧for循环的含义为: 每遍历车辆信息数组vehicles的每一次,都要与veKindsArr中的已存在的每一个品牌做比对
        // 遍历一边vehicles数组数据,
        for (Vehicle vehicle : vehicles) {
            // 如果存在,变量index记录当前ArrayList的下标,exit标识已存在当前品牌,并break当前ArrayList的循环
            for (int j = 0; j < veKindsArr.size(); j++) {
                String existingBrand = veKindsArr.get(j)[0].brand;
                String currentBrand = vehicle.brand;
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
                Vehicle[] veArrTemp = veKindsArr.get(index);
                // 将新的vehicle数据拼接到已有数组arr之后
                veArrTemp = addElement(veArrTemp, vehicle);
                // 更新对应下标的ArrayList数据
                veKindsArr.set(index, veArrTemp);
            } else {
                // 若不存在,新建一个该品类的车辆信息,格式为{"车辆信息"}
                Vehicle[] newVeArr = { vehicle };
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
     * 根据输入的车辆编码,获取该车辆的在车辆信息数组中的下标
     *
     * @param vid 车辆编码
     * @return 若此编码存在, 返回该编码在车辆信息数组中的下标;反之,返回-1.
     */
    public static int getIndexByVid(String vid) {
        int index = -1;
        for (int i = 0; i < vehicles.length; i++) {
            if (Objects.equals(vehicles[i].vid, vid)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 查询车辆编码是否存在
     * <p>
     * 遍历数组,对比每条数组的车辆编码与用户输入的是否一致.
     *
     * @param vId 用户输入的车辆编号
     * @return 如果vid存在, 返回true;反之,返回false
     */
    public static boolean isIdExist(String vId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.vid.equals(vId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 向车辆信息数组中追加车辆信息
     *
     * @param vehicle 单条车辆信息字符串
     * @return 若添加成功, 返回true;反之,返回false
     */
    public static boolean addElement(Vehicle vehicle) {
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
    public static Vehicle[] addElement(Vehicle[] vehicles, Vehicle vehicle) {
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
    public static boolean deleteElement(int index) {
        int oldLength = vehicles.length;
        System.arraycopy(vehicles, index + 1, vehicles, index, vehicles.length - index - 1);
        vehicles = Arrays.copyOf(vehicles, vehicles.length - 1);
        int newLength = vehicles.length;
        return oldLength == ++newLength;
    }

}
