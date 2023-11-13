
public class CreationThread extends Thread {
    private int id;
    private long start;
    private long end;

    public CreationThread(int id, long start, long end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public void run() {
        System.out.println("thread " + id + " rodando");
    }
}