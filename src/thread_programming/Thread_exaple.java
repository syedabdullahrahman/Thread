package thread_programming;

public class Thread_exaple implements Runnable{
    long click=0;
    Thread t;
    private volatile boolean running = true;

    public Thread_exaple(int p) {
        t= new Thread(this);
        t.setPriority(p);
    }
    @Override
    public void run() {
        while (check()){
            click++;
        }
        
    }
    public void stop()
    {
        running=false;
    }
    public boolean check(){
        return running;
    }
    public void start()
    {
        t.start();
    }
}