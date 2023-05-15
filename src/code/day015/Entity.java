public class Entity {
    // 私有化构造函数
    private Entity() {
    }

    // 枚举类
    static enum SingletonEnum {
        // 创建静态枚举,该对象天生单例
        INSTANCE;

        private Entity entity;

        // 私有化枚举的构造函数
        private SingletonEnum() {
            entity = new Entity();
        }

        public Entity getInstance() {
            return entity;
        }
    }

    // 暴露获取Entity的静态方法
    public static Entity getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }
}
