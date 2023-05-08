package code.day010.tools;

import code.day010.entity.University;

import java.io.*;
import java.util.List;

public class MyUtils {


    public static void printInfo(String str) {
        System.out.println(str);
    }


    public static void printInfo() {
        printInfo("学校名\t\t\t\t城市\t\t办学性质\t科目\t\t批次\t\t\t\t2022分数线\t2022排名");
    }

    public static void printInfo(List<University> uList) {
        printInfo();
        for (University university : uList) {
            printInfo(boxedUniversity(university));
        }
        printInfo("--------------------------------------------------------------------------------");
    }

    public static void printInfo(University u) {
        printInfo();
        System.out.println(boxedUniversity(u));
    }

    private static String boxedUniversity(University uni) {
        String uname = String.format("%-14s\t", uni.getUname());
        String city = String.format("%-6s\t", uni.getCity());
        String type = String.format("%-6s\t", uni.getType());
        String subject = String.format("%-4s\t", uni.getSubject());
        String batch = String.format("%-12s\t", uni.getBatch());
        String topScore = String.format("%-10s\t", uni.getTopScore());
        String rank = String.format("%-10s\t", uni.getRank());
        return uname + city + type + subject + batch + topScore + rank;

    }

    public static Object objectInput(File file) throws IOException, ClassNotFoundException {
        if (file.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Object object = ois.readObject();
            ois.close();
            return object;
        } else {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(null);
            oos.close();
            return null;
        }
    }

    public static void objectOutput(File file, Object object) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(object);
        oos.close();
    }

//    public static void byteOutput
}
