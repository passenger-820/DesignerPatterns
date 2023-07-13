package creational.singleton;

public class EnumSingleton {
    private EnumSingleton(){}

    public static enum SingletonEnum {
        EnumSingleton; //这是枚举项-就是个单例

        private EnumSingleton instance = null;
        private SingletonEnum(){
            instance = new EnumSingleton();
        }

        public EnumSingleton getInstance(){
            return instance;
        }
    }
}
