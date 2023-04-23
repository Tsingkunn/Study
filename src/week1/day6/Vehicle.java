package week1.day6;

public class Vehicle {
    String vid;
    String brand;
    String style;
    double cost;
    String type;
    String structure;

    public Vehicle() {
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vid='" + vid + '\'' +
                ", brand='" + brand + '\'' +
                ", style='" + style + '\'' +
                ", cost=" + cost +
                ", type='" + type + '\'' +
                ", structure='" + structure + '\'' +
                '}';
    }
}
