package code.day007;

public class Job01 {

    public Job01() {
        System.out.println("无参构造方法");
    }

    public Job01(int num) {
        System.out.println("int : " + num);
    }

    public static byte sum(byte x, byte y) {
        return (byte) (x + y);
    }

    public short sum(short x, short y) {
        return (short) (x + y);
    }

    public int sum(int x, int y) {
        return x + y;
    }

    public long sum(long x, long y) {
        return x + y;
    }

    public double sum(double x, double y) {
        return x + y;
    }

    public float sum(float x, float y) {
        return x + y;
    }
}
