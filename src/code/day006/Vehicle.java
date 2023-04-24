package code.day006;

import lombok.Data;

@Data
public class Vehicle {
    // 车辆编码
    private String vid;
    // 车辆品牌
    private String brand;
    // 车辆款式
    private String style;
    // 车辆售价
    private double cost;
    // 车辆类型
    private String type;
    // 车辆结构
    private String structure;

    public Vehicle() {
    }

    public Vehicle(String vid, String brand, String style, double cost, String type, String structure) {
        this.vid = vid;
        this.brand = brand;
        this.style = style;
        this.cost = cost;
        this.type = type;
        this.structure = structure;
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
