import java.util.List;
import java.util.Map;
import java.util.Dictionary;

public class ProcessingThread extends Thread {
    private List<Object> subset;
    private ObjectsList objectsList;
    private double totalSum;
    private long lesThan5Quantity;
    private long moreThan5Quantity;
    // private Dictionary totalSumByGroup;

    public ProcessingThread(List<Object> subset, ObjectsList objectsList) {
        this.subset = subset;
        this.totalSum = 0;
        this.lesThan5Quantity = 0;
        this.moreThan5Quantity = 0;
        this.objectsList = objectsList;
    }

    public void run() {
        for (Object object : subset) {
            totalSum += object.getTotal();
            if (object.getTotal() < 5) {
                lesThan5Quantity++;
            } else {
                moreThan5Quantity++;
            }
        }

        objectsList.addTotalSum(totalSum);
        objectsList.addLesThan5Quantity(lesThan5Quantity);
        objectsList.addMoreThan5Quantity(moreThan5Quantity);

    }
}
