package practice.copy;

import java.io.*;

/**
 * 通过序列化的方式进行深克隆
 */
public class Clone {

    /**
     * 通过序列化的方式进行深克隆,但是效率不高
     *
     * @param object 需要克隆的对象
     * @return 克隆之后的对象
     * @throws IOException            序列化时会出现IO异常
     * @throws ClassNotFoundException 没要找到此类异常
     */
    public Object deep(Object object) throws IOException, ClassNotFoundException {

        // 序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(object);

        // 反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }
}
