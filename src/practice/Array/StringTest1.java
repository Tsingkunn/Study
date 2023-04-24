package practice.Array;

public class StringTest1 {
    public static void main(String[] args) {
        String text = "李青君厉害啊";
        int hashCode = computeHashCode(text);

        System.out.println(text + "的哈希码是" + hashCode);
        System.out.println(text + "调用方法的哈希码是" + text.hashCode());

        String sub = text.substring(1, 2);
        System.out.println(sub);
    }

    public static int computeHashCode(String text) {
        int h = 0;
        for (int i = 0; i < text.length(); i++) {
            h = 31 * h + text.charAt(i);
        }
        return h;
    }
}
