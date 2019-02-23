public class Threads extends Thread{
    private boolean executed = false;
    private String name;

    public Threads(String name) {
        this.name = name;
    }

    private Threads[] waitThreads = new Threads[0];

    void waitThreads(Threads... waitThreads){
        this.waitThreads = new Threads[waitThreads.length];
        System.arraycopy(waitThreads, 0, this.waitThreads, 0, waitThreads.length);
    }

    private void wait(int i){
        synchronized (this.waitThreads[i]) {
            try {
                if (!this.waitThreads[i].executed){
                    this.waitThreads[i].wait();
                }
            }catch (Exception ignored){}
        }
    }

    public void run(){
            for (int i = 0; i < this.waitThreads.length; i++){
                wait(i);
            }
            System.out.println(this.name);
            this.executed = true;
            synchronized (this) {
                this.notifyAll();
            }
    }
}
