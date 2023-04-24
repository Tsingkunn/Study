package code.day006;

public class Vehicle {
    // 车辆编码
    String vid;
    // 车辆品牌
    String brand;
    // 车辆款式
    String style;
    // 车辆售价
    double cost;
    // 车辆类型
    String type;
    // 车辆结构
    String structure;

    public Vehicle() {
    }

    @Override
    public String toString() {
        String vid = String.format("%-12s\t", this.vid);
        String brand = String.format("%-12s\t", this.brand);
        String style = String.format("%-12s\t", this.style);
        String costStr = String.format("%-12s\t", this.cost);
        String type = String.format("%-12s\t", this.type);
        String structure = String.format("%-12s\t", this.structure);
        return vid + brand + style + costStr + type + structure;
    }
}
