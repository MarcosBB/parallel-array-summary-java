import java.util.List;
import java.util.ArrayList;

public class CreationThread extends Thread {
    private int id;
    private long start;
    private long end;
    private List<Object> objectsList;

    public CreationThread(int id, long start, long end, List<Object> objectsList) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.objectsList = objectsList;
    }

    public void run() {
        List<Object> myObjectList = new ArrayList<Object>();
        for (long i = start; i <= end; i++) {
            myObjectList.add(new Object(i));
        }
        objectsList.addAll(myObjectList);
    }
}