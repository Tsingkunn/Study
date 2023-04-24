package code.day006;

public class VehicleData {
    static Vehicle[] vehicles;

    // static中的变量局部变量
    static {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.vid = "20231122";
        vehicle1.brand = "奔驰";
        vehicle1.style = "GLC";
        vehicle1.cost = 400000;
        vehicle1.type = "中型";
        vehicle1.structure = "SUV";

        Vehicle vehicle2 = new Vehicle();
        vehicle2.vid = "20231123";
        vehicle2.brand = "比亚迪";
        vehicle2.style = "护卫舰07";
        vehicle2.cost = 202800;
        vehicle2.type = "中型";
        vehicle2.structure = "SUV";

        Vehicle vehicle3 = new Vehicle();
        vehicle3.vid = "20231124";
        vehicle3.brand = "比亚迪";
        vehicle3.style = "汉";
        vehicle3.cost = 197800;
        vehicle3.type = "中型";
        vehicle3.structure = "轿车";

        Vehicle vehicle4 = new Vehicle();
        vehicle4.vid = "20231125";
        vehicle4.brand = "特斯拉";
        vehicle4.style = "ModelY";
        vehicle4.cost = 261900;
        vehicle4.type = "中型";
        vehicle4.structure = "SUV";

        Vehicle vehicle5 = new Vehicle();
        vehicle5.vid = "20231126";
        vehicle5.brand = "比亚迪";
        vehicle5.style = "海豚";
        vehicle5.cost = 116800;
        vehicle5.type = "小型";
        vehicle5.structure = "轿车";

        vehicles = new Vehicle[]{vehicle1, vehicle2, vehicle3, vehicle4, vehicle5};
    }
}
