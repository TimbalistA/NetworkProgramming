import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Multithreading {
        public static void main(String[] args){
        Threads thread1 = new Threads("1");
        Threads thread2 = new Threads("2");
        Threads thread3 = new Threads("3");
        Threads thread4 = new Threads("4");
        Threads thread5 = new Threads("5");
        Threads thread6 = new Threads("6");

        thread1.waitThreads(thread2);
        thread2.waitThreads(thread5);
        thread3.waitThreads(thread1,thread2,thread4,thread5,thread6);
        thread4.waitThreads(thread6);
        thread5.waitThreads(thread4);

        ExecutorService executorService = Executors.newFixedThreadPool(6);
        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);
        executorService.submit(thread4);
        executorService.submit(thread5);
        executorService.submit(thread6);
        executorService.shutdown();
    }
}
