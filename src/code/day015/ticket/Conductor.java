package ticket;

public class Conductor extends Thread {

    // 票务信息
    private Ticket ticket;

    // 售票员姓名
    private String name;

    // 售票员构造方法
    public Conductor(String name) {
        this.name = name;
        this.ticket = Ticket.getInstance();
    }

    // 售票员在卖票
    @Override
    public void run() {
        while (true) {
            int count = ticket.send();
            if (count >= 0) {
                System.out.println("售票员'" + name + "'卖的第" + (1000 - count) + "张票");
            } else {
                break;
            }
        }
    }
}
