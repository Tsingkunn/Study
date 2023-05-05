package practice.io;

import java.io.*;

public class InputStreamTest {
    public static void main(String[] args) {
        File input = new File("src/practice/io/JavaSE-API.docx");
        File output = new File("src/practice/io/JavaSE-API-副本.docx");

        System.out.println("input.txt content is " + getFileContent(input));

//        fileOutputStream(input, output);

//        System.out.println(fileReader(input));
//        fileWriter(input, output);
        bufferedTest(input, output);
    }

    public static void bufferedTest(File from, File to) {

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(from));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(to))) {
            int content;
            while ((content = bis.read()) != -1) {
                bos.write(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fileWriter(File from, File to) {
        String content = fileReader(from);
        try (FileWriter fw = new FileWriter(to)) {
            fw.write(content);
            fw.append('c');
            fw.append("\n怎么样?我练成了吗?");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String fileReader(File file) {
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader(file)) {
            int content;
            while ((content = fr.read()) != -1) {
                sb.append((char) content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void fileOutputStream(File from, File to) {
        String content = getFileContent(from);
        System.out.println(content);
        try (OutputStream fos = new FileOutputStream(to)) {
            fos.write(content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 读取文件
     */
    public static String getFileContent(File file) {
        StringBuilder sb = new StringBuilder();
        try (InputStream fis = new FileInputStream(file)) {

            int content;
            while ((content = fis.read()) != -1) {
                sb.append((char) content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void fileInputStream() {
        // InputStream 字节输入流
        // FileInputStream 字节流输入对象
        try (InputStream fis = new FileInputStream("src/practice/io/input.txt")) {
            System.out.println("Number of remaining bytes: " + fis.available());

            long skip = fis.skip(2);
            System.out.println("The actual number of bytes skips:" + skip);

            int content;
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
