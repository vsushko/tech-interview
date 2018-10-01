package vsushko.concurrent;

/**
 * @author vsushko
 */
public class ExampleWithThreads {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        MyThread1 t1 = new MyThread1(myClass);
        MyThread2 t2 = new MyThread2(myClass);
        t1.start();
        t2.start();
    }
}

class MyThread1 extends Thread {
    private MyClass myClass;

    public MyThread1(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {
        myClass.a = 41;
        myClass.a = 42;
        myClass.b = true;
        myClass.a = 43;
        System.out.println(Thread.currentThread().getName() + " - " + myClass.a);
    }
}

class MyThread2 extends Thread {
    private MyClass myClass;

    public MyThread2(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {
        while (!myClass.b) {
            // do something...
        }
        System.out.println(Thread.currentThread().getName() + " - " + myClass.a);
    }
}

class MyClass {
    int a = 0;
    boolean b = false;
}