package test.genericity;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: GenericityTest
 * @description:
 * @author: wangf-q
 * @date: 2020-01-14 17:49
 **/
public class GenericityTest {


    public static void main(String[] args) {
//        questionTest();
        extendsAttentionTest();
    }

    private static void questionTest() {
        Fruit fruit = new Fruit();
        Apple apple = new Apple();

        Plate<Fruit> fruitPlate = new Plate<>();
        Plate<Apple> applePlate = new Plate<>();

        fruitPlate.set(apple);
        fruitPlate.methodWithT(apple);

//        fruitPlate = applePlate;
    }

    private static void extendsTest() {
        Plate<Fruit> fruitPlate = new Plate<>();
        Plate<Apple> applePlate = new Plate<>();
        Plate<? extends Fruit> extendsFruitPlate;

        extendsFruitPlate = applePlate;
        extendsFruitPlate = fruitPlate;

    }

    private static void superTest() {
        Fruit fruit = new Fruit();
        Apple apple = new Apple();

        Plate<Fruit> fruitPlate = new Plate<>();
        Plate<Apple> applePlate = new Plate<>();
        Plate<Object> objectPlate = new Plate<>();
        Plate<? super Fruit> superFruitPlate;

        superFruitPlate = fruitPlate;
        superFruitPlate = objectPlate;
    }


    private static void extendsAttentionTest() {
        Fruit fruit = new Fruit();
        Apple apple = new Apple();
        Pear pear = new Pear();

        Plate<? extends Fruit> extendsFruitPlate;
        extendsFruitPlate = new Plate<Fruit>(fruit);
        extendsFruitPlate = new Plate<Apple>(apple);
        extendsFruitPlate = new Plate<Pear>(pear);

        // 以下ERROR代码,尝试调用接收泛型T的方法,均编译不过
        // ERROR:
//         extendsFruitPlate.set(fruit);
        // extendsFruitPlate.set(apple);
        // extendsFruitPlate.set(pear);
        // extendsFruitPlate.set(new Object());
        // extendsFruitPlate.methodWithT(fruit);
        // extendsFruitPlate.methodWithT(apple);
        // extendsFruitPlate.methodWithT(pear);
        // extendsFruitPlate.methodWithT(new Object());
        // 以上注释的错误代码,初学者也会有疑问,
        // 为什么<Plate<? extends Fruit> extendsFruitPlate;这样装水果子类的盘子,
        // 现在什么东西都不能放了?那我还要这个容器有什么用?这是不是跟思维惯性认知有点偏差?

        // SUCCESS
        // 返回的是泛型T即Fruit,具体的实例是Pear类型
        Fruit getFruit = extendsFruitPlate.get();
        getFruit.echo();// 输出Pear

        // 接口测试
        class ExtendsClass {
            public void extendsMethod(List<? extends Fruit> extendsList) {
                // ERROR:
                // 出错原理同上,不能调用接收泛型T的方法
                // extendsList.add(fruit);
                // extendsList.add(apple);
                // extendsList.add(new Object());
                // SUCCESS
                // 获取是父类,可以强转为子类再使用
                Fruit getFruitByList = extendsList.get(0);
                getFruitByList.echo();
            }
        }



        List<Fruit> fruits = Lists.newArrayList(fruit);
        List<Apple> apples = Lists.newArrayList(apple);
        ExtendsClass extendsClass = new ExtendsClass();
        // List<? extends Fruit> extendsList可以接收List<Fruit>/List<Apple>
        extendsClass.extendsMethod(fruits);
        extendsClass.extendsMethod(apples);
    }


    private static void superAttentionTest() {
        Object object = new Object();
        Food food = new Food();
        Fruit fruit = new Fruit();
        Apple apple = new Apple();
        Pear pear = new Pear();

        Plate<? super Fruit> superFruitPlate;
        // 可以被 Plate<Object> , Plate<Food> ,Plate<Fruit> Plate<父类容器> 赋值
        superFruitPlate = new Plate<Object>(object);
        superFruitPlate = new Plate<Food>();
        superFruitPlate = new Plate<Fruit>();

        // SUCCESS
        superFruitPlate.set(fruit);
        superFruitPlate.set(apple);
        superFruitPlate.set(pear);
        superFruitPlate.methodWithT(fruit);
        superFruitPlate.methodWithT(apple);
        superFruitPlate.methodWithT(pear);
        // ERROR:接收父类T的接口,当[不是 T或T的子类时],则编译异常
        // superFruitPlate.set(food);
        // superFruitPlate.set(object);
        // superFruitPlate.methodWithT(food);
        // superFruitPlate.methodWithT(object);
        // 以上注释的错误代码,初学者也会有疑问,
        // 为什么<Plate<? super Fruit> superFruitPlate;这样可以指向水果父类的盘子,
        // 现在却只能放子类?这是不是跟思维惯性认知有点偏差?

        // 只能获取到Object对象,需要进行强转才可以进行调用相关API
        Object supperFruitPlateGet = superFruitPlate.get();
        if (supperFruitPlateGet instanceof Fruit) {
            // 为什么需要 instanceof ?
            // superFruitPlate可以指向Plate<Food>,获取出来实际是Food实例
            Fruit convertFruit = (Fruit) supperFruitPlateGet;
            convertFruit.echo();
        }

        // 接口测试
        class SuperClass {
            public void supperMethod(List<? super Fruit> superList) {

                superList.add(fruit);
                superList.add(apple);
                superList.add(pear);
                // ERROR:原因如上,调用method(T t)时候,当t[不是 T或T的子类时],则编译异常
                // superList.add(object);
                // superList.add(food);
                Object innerObject = superList.get(0);
                if (innerObject instanceof Fruit) {
                    // 为什么需要 instanceof ?
                    // 像这样:superFruitPlate 可以指向List<Object> objects,获取出来是Object
                    Fruit innerConvertFruit = (Fruit) innerObject;
                    innerConvertFruit.echo();
                } else {
                    System.out.println("supperMethod:非Fruit,插入非本类或非子类:" + innerObject);
                }
            }
        }
        List<Object> objects = new ArrayList<>(Arrays.asList(object));
        List<Food> foods = new ArrayList<>(Arrays.asList(food));
        List<Fruit> fruits = new ArrayList<>(Arrays.asList(fruit));
        List<Apple> apples = new ArrayList<>(Arrays.asList(apple));
        List<Pear> pears = new ArrayList<>(Arrays.asList(pear));
        SuperClass superClass = new SuperClass();
        superClass.supperMethod(objects);
        superClass.supperMethod(foods);
        superClass.supperMethod(fruits);
        // ERROR 原因同上,非Fruit及Fruit父类容器则编译不通过
        // superClass.supperMethod(apples);
        // superClass.supperMethod(pears);
    }


}


