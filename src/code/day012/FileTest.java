package code.day012;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {
        File f = new File("D:\\T1");
        remove(f);
    }

    public static void remove(File parent) {
        if (parent != null && parent.exists()) {
            if (parent.isDirectory()) {
                File[] files = parent.listFiles();
                for (File file : files) {
                    remove(file);
                }
            } else if (parent.isFile()) {
                parent.delete();
            }
        }
    }

    public static void removeFile(File parent) {
        // 获取当前目录下的所有文件和目录列表
        File[] files = parent.listFiles();

        // 遍历这个文件/目录数组
        for (File file : files) {
            // 是文件吗?是的话,删除
            if (file.isFile()) {
                file.delete();

                // 不是?不是的话,那就接着调用自己
            } else {
                removeFile(file);
            }
        }
    }
}
