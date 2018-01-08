package thread_exaple;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_Synchronization {

    Integer count=new Integer(0);
    private int tt=0,tt2=0;
    
    public static void main(String[] args) {
        Thread_Synchronization temp = new Thread_Synchronization();
        temp.doWork();
    }

    private void doWork() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    count++;
                    tt++;
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    count++;
                    tt2++;
                }
            }
        });
        t.start();
        t2.start();
        try {
            t.join();t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread_Synchronization.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(count.intValue());
        System.out.println(tt);
        System.out.println(tt2);
    }
}
