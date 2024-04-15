package singlepattern;

/*
* 单件模式、单例模式
* */
public class SingletonPattern {

    /*
    * dcl double checked locking
    * */
    static class DCLSingleton {
        private static volatile DCLSingleton dclSingleton;
        private DCLSingleton(){}
        public static DCLSingleton getInstance() {
            if (dclSingleton == null){
                synchronized (DCLSingleton.class){
                    if (dclSingleton == null) dclSingleton = new  DCLSingleton();
                }
            }
            return dclSingleton;
        }
    }

    /*
    * 静态内部类
    * */
    static class StaticSingleton {
        private StaticSingleton() {}
        private static class SingleHolder {
            private static final StaticSingleton INSTANCE = new StaticSingleton();
        }
        public static StaticSingleton getInstance() {
            return SingleHolder.INSTANCE;
        }
    }
}
