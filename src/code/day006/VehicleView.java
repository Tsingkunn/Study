package code.day006;

import java.util.*;

public class VehicleView {

    private static final Scanner scan = new Scanner(System.in);
    private static boolean isLoop = true;
    private final VehicleDao vehicleDao = new VehicleDao();

    public void run() {
        int selection;
        while (isLoop) {
            showMainPage();
            selection = scan.nextInt();
            switch (selection) {
                // 查看全部信息
                case 1 -> showAllVehiclesMsg();
                // 新增一条车辆信息.
                case 2 -> addVehicleMsg();
                // 根据编号删除指定的车辆.
                case 3 -> removeVehicleMsgByVid();
                // 根据类型查询汽车信息
                case 4 -> showVehiclesFromType();
                // 根据汽车结构的查询平均价格
                case 5 -> showVehiclesAvgFromStructure();
                // 根据汽车品牌查询最高价
                case 6 -> showVehiclesMaxCostFromBrand();
                // 获取超过20万售价的汽车,存入变量中
                case 7 -> showVehiclesCostThanTwentyThousand();
                // 根据编号查询车辆信息.
                case 8 -> showVehicleMsgByVid();
                // 查询不同品牌车辆的车辆信息
                case 9 -> showVehiclesMsgFromKinds();
                // 输入-1,结束程序
                case -1 -> exitProgram();
                // 展示默认信息
                default -> showDefaultMsg();

            }
        }
    }

    /**
     * 显示首页提示信息
     */
    public void showMainPage() {
        System.out.println("""
                *     ...主界面...
                * 1、 查看所有车辆信息.
                * 2、 新增一条车辆信息.
                * 3、 根据编号删除指定的车辆.
                * 4、 根据类型查询类汽车信息.
                * 5、 根据汽车结构查询汽车的平均价格.
                * 6、 根据品牌查询其中价格最高的车辆信息.
                * 7、 查询汽车售价超过"20万"的车辆信息.
                * 8、 根据编号查询车辆信息.
                * 9、 查询不同品牌车辆的车辆信息.
                *     ...按-1退出系统...
                """);
    }

    public void showAllVehiclesMsg() {
        VehicleUtils.printInfo();
        Vehicle[] vehicles = vehicleDao.queryAllVehicles();
        VehicleUtils.printInfo(vehicles);
    }

    public void addVehicleMsg() {
        // 输入车辆编号
        VehicleUtils.printInfo("请输入车辆编码:");
        String vid = scan.next();

        // 判断编号是否存在
        if (!vehicleDao.isIdExist(vid)) {
            // 如果不存在,让用户输入"品牌"/"款式"/"价格"/"类型"/"结构"信息
            VehicleUtils.printInfo("请输入车辆品牌");
            String vBrand = scan.next();

            VehicleUtils.printInfo("请输入车辆款式");
            String vStyle = scan.next();

            VehicleUtils.printInfo("请输入车辆价格");
            double vCost = scan.nextDouble();
            if (vCost < 0) {
                VehicleUtils.printInfo("车辆价格信息输入有误!");
                return;
            }

            VehicleUtils.printInfo("请输入车辆类型");
            String vType = scan.next();

            VehicleUtils.printInfo("请输入车辆车身结构");
            String vStructure = scan.next();

            Vehicle vehicle = new Vehicle(vid, vBrand, vStyle, vCost, vType, vStructure);

            // 调用添加方法,如果添加成功返回true
            if (vehicleDao.insertVehicleMsg(vehicle)) {
                VehicleUtils.printInfo("添加车辆信息成功!");
            } else {
                VehicleUtils.printInfo("添加车辆信息失败,请重试!");
            }
        } else {
            // 如果编号已存在,提示提示信息
            VehicleUtils.printInfo("车辆编号已存在,请重试!!");
        }
    }

    public void removeVehicleMsgByVid() {
        // 输入车辆编号
        VehicleUtils.printInfo("请输入要删除车辆的编号:");
        String vid = scan.next();

        // 判断编号是否存在
        if (vehicleDao.isIdExist(vid)) {
            // 如果编号存在,调用删除方法,如果删除成功返回true
            VehicleUtils.printInfo(vehicleDao.deleteVehicleByVid(vid) ? "删除车辆信息成功" : "删除失败,请重试!");
        } else {
            // 如果编号不存在,提示提示信息.
            VehicleUtils.printInfo("暂无该车辆信息!");
        }
    }

    public void showVehiclesFromType() {
        VehicleUtils.printInfo("请输入要查询详细车辆信息的类型:");
        String vType = scan.next();
        // 调用查询方法查询所有车辆信息保存到变量vehicleArr中
        Vehicle[] vehiclesArr = vehicleDao.queryVehiclesByMiddleSize(vType);
        // 判断是否查询到数据
        if (vehiclesArr.length != 0) {
            // 如果查询到有数据据,调用输出方法,格式化输出打印
            VehicleUtils.printInfo("查询到汽车信息如下:");
            VehicleUtils.printInfo();
            VehicleUtils.printInfo(vehiclesArr);
        } else {
            // 如果查询到信息为空,提示用户信息
            VehicleUtils.printInfo("未查询到该类型汽车");
        }
    }

    public void showVehiclesAvgFromStructure() {
        VehicleUtils.printInfo("请输入要查询的结构车型的平均值");
        String vStructure = scan.next();

        // 调用方法计算的平均价格
        double suvAvg = vehicleDao.calculateAvgByStructure(vStructure);
        // 如果suv的平均价格大于0,打印平均价格;否则,提示用户提示信息
        if (suvAvg != 0) {
            VehicleUtils.printInfo("该结构的汽车的平均价格是" + suvAvg);
        } else {
            VehicleUtils.printInfo("信息中暂无此结构类型的汽车!");
        }
    }

    public void showVehiclesMaxCostFromBrand() {
        VehicleUtils.printInfo("请输入要查询最高价的品牌");
        String vBrand = scan.next();
        Vehicle[] vehicle = vehicleDao.findMaxCostFromBrand(vBrand);
        // 将该信息转换成只有一个元素的数组,便于格式化输出
        // 判断数组中是否有比亚迪汽车
        if (vehicle.length != 0) {
            // 如果有比亚迪汽车,打印信息
            VehicleUtils.printInfo("该品牌中价格最高的车辆信息为:\n");
            VehicleUtils.printInfo();
            VehicleUtils.printInfo(vehicle);
        } else {
            // 如果数组中暂无比亚迪汽车,打印提示信息
            VehicleUtils.printInfo("暂无该品牌车辆信息!");
        }
    }

    public void showVehiclesCostThanTwentyThousand() {
        // 获取超过20万售价的汽车,存入变量中
        Vehicle[] vehicles = vehicleDao.queryVehiclesByCost();

        // 判断有没有超过20万售价的汽车
        if (vehicles.length > 0) {
            // 若有,打印信息
            VehicleUtils.printInfo("售价超过20万的汽车信息如下:");
            VehicleUtils.printInfo();
            VehicleUtils.printInfo(vehicles);
        } else {
            // 若没有,打印提示信息
            VehicleUtils.printInfo("暂无售价超过20万的汽车!");
        }
    }

    public void showVehicleMsgByVid() {
        // 提示用户输入信息,并接收编号信息
        VehicleUtils.printInfo("请输入要查询的汽车信息的编号:");
        String vid = scan.next();
        // 调用方法查询该编号汽车信息
        Vehicle vehicle = vehicleDao.findVehicleByVid(vid);
        // 转存为只有一个元素的数组,便于格式化打印
        Vehicle[] info = {vehicle};

        // 判断是否有该汽车信息
        // 如果接收到的汽车信息的字符串长度大于零,代表有数据;反之,则无,打印提示信息
        if (vehicle != null) {
            VehicleUtils.printInfo("编号 " + vid + " 的汽车信息如下:");
            VehicleUtils.printInfo();
            VehicleUtils.printInfo(info);
        } else {
            VehicleUtils.printInfo("编号输入有误!!");
        }
    }

    public void showVehiclesMsgFromKinds() {
        // 查询车辆品牌,记数,并存储相应信息.详细操作见 queryVehicleByKinds() 方法.
        List<Vehicle[]> veKindsArr = vehicleDao.queryVehicleByKinds();

        if (veKindsArr.size() > 0) {
            VehicleUtils.printInfo("汽车品牌共有:" + veKindsArr.size() + " 种.\n");

            // 打印每种品牌的数量与详细信息
            for (Vehicle[] v : veKindsArr) {
                VehicleUtils.printInfo("品牌为: " + v[0].getBrand() + " 的种类有 " + v.length + " 种");
                VehicleUtils.printInfo();
                VehicleUtils.printInfo(v);
            }
            VehicleUtils.printInfo(" ");
        } else {
            VehicleUtils.printInfo("系统异常!");
        }
    }

    public void exitProgram() {
        isLoop = false;
    }

    public void showDefaultMsg() {
        VehicleUtils.printInfo("暂无此功能!");
    }

}
