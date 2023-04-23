package week1.day6;

public class VehicleTest {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.vid = "20231122";
        vehicle1.brand = "奔驰";
        vehicle1.style = "GLC";
        vehicle1.cost = 400000;
        vehicle1.type = "中型";
        vehicle1.structure = "SUV";

        System.out.println(vehicle1);
    }
}
