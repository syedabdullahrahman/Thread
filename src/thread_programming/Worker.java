package thread_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Worker {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private Random random = new Random();
    private List<Integer> list = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();

    private void stageOne() {
        synchronized(lock1)
        {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
            list.add(random.nextInt(100));
        }
    }

    private void stageTwo() {
        synchronized(lock2)
        {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
            list2.add(random.nextInt(100));
        }
    }

    private  void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    void main() {
        System.out.println("Starting....");
        long start = System.currentTimeMillis();
        //process();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }
        long end = System.currentTimeMillis();
        
        System.out.println("Take time :" + (end - start));
        System.out.println("List 1:" + list.size());
        System.out.println("List 2:" + list2.size());
    }

}
