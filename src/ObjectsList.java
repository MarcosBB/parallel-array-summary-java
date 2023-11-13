import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ObjectsList {
    List<Object> objectsList;
    double totalSum;
    long lesThan5Quantity;
    long moreThan5Quantity;
    Map<Integer, Double> groupsTotal;

    public ObjectsList(List<Object> objectsList) {
        this.objectsList = objectsList;
        this.totalSum = 0;
        this.lesThan5Quantity = 0;
        this.moreThan5Quantity = 0;
        this.groupsTotal = new HashMap<Integer, Double>();

        for (int i = 1; i <= 5; i++) {
            this.groupsTotal.put(i, 0.0);
        }
    }

    public synchronized void addTotalSum(double totalSum) {
        this.totalSum += totalSum;
    }

    public synchronized void addLesThan5Quantity(long lesThan5Quantity) {
        this.lesThan5Quantity += lesThan5Quantity;
    }

    public synchronized void addMoreThan5Quantity(long moreThan5Quantity) {
        this.moreThan5Quantity += moreThan5Quantity;
    }

    public synchronized void addGroupsTotal(int group, double total) {
        this.groupsTotal.put(group, this.groupsTotal.get(group) + total);
    }

    public double getTotalSum() {
        return totalSum;
    }

    public long getLesThan5Quantity() {
        return lesThan5Quantity;
    }

    public long getMoreThan5Quantity() {
        return moreThan5Quantity;
    }

    public Map<Integer, Double> getGroupsTotal() {
        return groupsTotal;
    }

}