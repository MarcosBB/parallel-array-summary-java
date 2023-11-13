import java.util.List;

public class ObjectsList {
    List<Object> objectsList;
    double totalSum;
    long lesThan5Quantity;
    long moreThan5Quantity;

    public ObjectsList(List<Object> objectsList) {
        this.objectsList = objectsList;
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

    public double getTotalSum() {
        return totalSum;
    }

    public long getLesThan5Quantity() {
        return lesThan5Quantity;
    }

    public long getMoreThan5Quantity() {
        return moreThan5Quantity;
    }
}