package test.single;

/**
 * @program: Singleton
 * @description:
 * @author: wangf-q
 * @date: 2020-01-15 14:14
 **/
public class Singleton {


    /**
     * volatile 在此是禁止指令重排的作用, 保证先初始化, 再把对象引用赋值给instance变量
     */
    volatile private static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        try {
            //懒汉式
            if (instance != null) {
            } else {
                //创建实例之前可能会有一些准备性的耗时工作
                Thread.sleep(50);
                synchronized (Singleton.class) {
                    //二次检查
//                    if (instance == null) {
                        instance = new Singleton();
//                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return instance;
    }

}
