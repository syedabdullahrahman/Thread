package thread_exaple;

class A{
    int a=5;
    void print(){
        System.out.println("Class A");
    }
}
class B extends A{
    int a=10;

    @Override
    void print() {
        System.out.println("Class B");
    }
    
}
class Print {
     void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        System.out.println("]");
    }
}

public class BasicTest implements Runnable {
    String msg;
    Print p;
    Thread t ;
    public BasicTest(Print trg,String s){
        p=trg;
        msg = s ;
        t = new Thread(this);
        //t.start();
    }
    @Override
    public void run() {
        synchronized(p){
            p.call(msg);
        }
       
    }

    public static void main(String[] args) {
//        Print o = new Print();
//        BasicTest ob1= new BasicTest(o, "Hello");
//        BasicTest ob2 = new BasicTest(o, "World");
//        BasicTest ob3 = new BasicTest(o, "Synchronized");
//        
//        ob1.t.start();
//        ob2.t.start();
//        ob3.t.start();
//        try {
//            ob1.t.join();
//            ob2.t.join();
//            ob3.t.join();
//        } catch (InterruptedException e) {
//        }
          A b = new B();
          System.out.println(b.a);
          b.print();
    }
}
