package code.day006;

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

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
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
