package practice.baseclass;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 抽象类,定义了一个读取文件的基础看框架,其中 mapFileLine 是一个抽象方法,具体实现需要由子类来完成
 */
public abstract class BaseFileReader {
    // 定义一个 protected 的 Path 对象,表示文件读取路径
    protected Path filePath;

    /**
     * 构造方法,传入读取的文件路径
     *
     * @param filePath 读取的文件路径
     */
    public BaseFileReader(Path filePath) {
        this.filePath = filePath;
    }

    /**
     * 空参构造方法
     */
    public BaseFileReader() {
    }

    /**
     * 读取文件的方法,返回一个字符串列表
     *
     * @return 字符串列表, 表示文件内容
     * @throws IOException 如果文件读取出从,抛出该异常
     */
    public List<String> readFile() throws IOException {
        // 使用 Files 的 lines 方法,读取文件的每一行
        return Files.lines(filePath, StandardCharsets.UTF_8)
                // 对每一行应用 mapFileLine 方法,将其转化为指定格式
                .map(this::mapFileLine)
                // 将处理后的每一行收集到的一个字符串列表中,返回
                .collect(Collectors.toList());

    }

    /**
     * 抽象方法,子类需要实现该方法,将文件中的每一行转换为指定格式
     *
     * @param line 文件中的每一行
     * @return 转化后的字符串
     */
    protected abstract String mapFileLine(String line);
}
