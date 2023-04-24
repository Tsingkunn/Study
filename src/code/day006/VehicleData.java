package code.day006;

public class VehicleData {
    static Vehicle[] vehicles;

    // static中的变量局部变量
    static {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVid("20231122");
        vehicle1.setBrand("奔驰");
        vehicle1.setStyle("GLC");
        vehicle1.setCost(40000);
        vehicle1.setType("中型");
        vehicle1.setStructure("SUV");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVid("20231123");
        vehicle2.setBrand("比亚迪");
        vehicle2.setStyle("护卫舰07");
        vehicle2.setCost(202800);
        vehicle2.setType("中型");
        vehicle2.setStructure("SUV");

        Vehicle vehicle3 = new Vehicle();
        vehicle3.setVid("20231124");
        vehicle3.setBrand("比亚迪");
        vehicle3.setStyle("汉");
        vehicle3.setCost(197800);
        vehicle3.setType("中型");
        vehicle3.setStructure("轿车");

        Vehicle vehicle4 = new Vehicle();
        vehicle4.setVid("20231125");
        vehicle4.setBrand("特斯拉");
        vehicle4.setStyle("ModelY");
        vehicle4.setCost(261900);
        vehicle4.setType("中型");
        vehicle4.setStructure("SUV");

        Vehicle vehicle5 = new Vehicle();
        vehicle5.setVid("20231126");
        vehicle5.setBrand("比亚迪");
        vehicle5.setStyle("海豚");
        vehicle5.setCost(116800);
        vehicle5.setType("小型");
        vehicle5.setStructure("轿车");

        vehicles = new Vehicle[]{vehicle1, vehicle2, vehicle3, vehicle4, vehicle5};
    }
}
