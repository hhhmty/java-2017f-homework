import java.util.concurrent.*;
import java.util.concurrent.locks.*;
class Car {
    private boolean waxOn = false;
    public  boolean flag(){
        if(waxOn)
            return true;
        else
            return false;
    }

    public synchronized void waxed() {
        waxOn = true; // Ready to buff
        notifyAll();
    }

    public synchronized void buffed() {
        waxOn = false; // Ready for another coat of wax
        notifyAll();
    }

    public synchronized void waitForWaxing()
            throws InterruptedException {
        while (waxOn == false)
            wait();
    }

    public synchronized void waitForBuffing()
            throws InterruptedException {
        while (waxOn == true)
            wait();
    }
}

class WaxOn implements Runnable {
    private Car car;
    private static int taskcount = 0;
    private final int id = 1 + taskcount++;
    public static ReentrantLock lock = new ReentrantLock();
    static Object obj=new Object();
    public WaxOn(Car c) {
        car = c;
    }

    public void run() {

        try {
            while (!Thread.interrupted()) {
                synchronized (obj){
                    if (Thread.interrupted())
                        break;
                    else
                    {car.waitForBuffing();
                    System.out.println("WaxOn" + id + ":" + "Wax On! ");
                    TimeUnit.MILLISECONDS.sleep(200);
                    car.waxed();
                    car.waitForBuffing();}}
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
            System.out.println("Ending Wax On" + id + " task");
    }
}

class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car c) {
        car = c;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println ("WaxOff:Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
                car.waitForWaxing();
            }
        } catch (InterruptedException e) {
            System.out.println ("Exiting via interrupt");
        }
        System.out.println ("Ending Wax Off task");
    }
}

public class WaxOMatic {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        for (int i = 0; i <2 ; i++) {
            exec.execute(new WaxOn(car));
        }
        TimeUnit.SECONDS.sleep(5); // Run for a while...
        exec.shutdownNow(); // Interrupt all tasks
    }
}