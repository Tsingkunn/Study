import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// 登记模式是用来维护一组单例模式的,保证map中的对象是同一份
// Spring用的就是类似的模式
public class RegisterSingleton {

    // 登记单例模式,保证map是同一份
    private static Map<String, Object> map;

    // 静态域
    static {
        map = new ConcurrentHashMap<>();
        map.put(RegisterSingleton.class.getName(), new RegisterSingleton());
    }

    // 私有化构造方法
    private RegisterSingleton() {
    }

    // 根据类名获取实例
    public static Object getInstance(String clazzName)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException {
        if (clazzName == null) {
            clazzName = RegisterSingleton.class.getName();
        }
        if (map.get(clazzName) == null) {
            map.put(clazzName, Class.forName(clazzName).getDeclaredConstructor().newInstance());
        }
        return map.get(clazzName);
    }

}