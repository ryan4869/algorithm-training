package class08;

public class Singleton {
    // 懒汉式
    static Singleton singleton = null;
    private Singleton(){
        System.out.println("lazy");
    }
    public static Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

class Single{
    // 饿汉式
    private static Single single = new Single();
    // private修饰构造器 不能在外部new对象
    private Single(){
        System.out.println("single");
    }
    public static Single getInstance() {
        return single;
    }
}
