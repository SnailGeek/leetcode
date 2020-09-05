package test.single;

/**
 * @program: StaticSingleton
 * @description:
 * @author: wangf-q
 * @date: 2020-01-15 15:17
 **/
public class StaticSingleton {

    private static class SingletonHandler{
        private static StaticSingleton instance = new StaticSingleton();
    }

    private StaticSingleton(){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static StaticSingleton getInstance(){
        return SingletonHandler.instance;
    }
}
