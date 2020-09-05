package test.genericity;

/**
 * @program: Plate
 * @description:
 * @author: wangf-q
 * @date: 2020-01-14 17:42
 **/
public class Plate<T> {
    private T item;

    public Plate() {
    }

    public Plate(T item) {
        this.item = item;
    }

    public void set(T t) {
        item = t;
    }

    public T get() {
        return item;
    }

    /**
     * 模仿处理泛型T实例
     */
    public void methodWithT(T t) {
        //简单打印实例
        System.out.println("methodWithT,T's is : " + t);
    }
}
