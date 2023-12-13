import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ProcessingThread extends Thread {
    private List<Object> subset;
    private ObjectsList objectsList;
    private double totalSum;
    private long lesThan5Quantity;
    private long moreThan5Quantity;
    private Map<Integer, Double> groupsTotalToAdd;

    public ProcessingThread(List<Object> subset, ObjectsList objectsList) {
        this.subset = subset;
        this.totalSum = 0;
        this.lesThan5Quantity = 0;
        this.moreThan5Quantity = 0;
        this.objectsList = objectsList;
        this.groupsTotalToAdd = new HashMap<Integer, Double>();
        for (int i = 1; i <= 5; i++) {
            this.groupsTotalToAdd.put(i, 0.0);
        }
    }

    public void run() {

        for (Object object : subset) {
            int group = object.getGroup();
            double total = object.getTotal();

            totalSum += total;

            if (group < 5) {
                lesThan5Quantity++;
            } else {
                moreThan5Quantity++;
            }

            groupsTotalToAdd.put(group, groupsTotalToAdd.get(group) + total);

        }

        objectsList.addGroupsTotal(groupsTotalToAdd);
        objectsList.addTotalSum(totalSum);
        objectsList.addLesThan5Quantity(lesThan5Quantity);
        objectsList.addMoreThan5Quantity(moreThan5Quantity);

    }
}
