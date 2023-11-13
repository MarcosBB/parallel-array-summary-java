public class Object {
    private long id;
    private float total;
    private int group;

    public Object(long id) {
        this.total = (float) (new java.util.Random().nextFloat() * 10);
        this.group = new java.util.Random().nextInt(5) + 1;
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public int getGroup() {
        return group;
    }

    public long getId() {
        return id;
    }
}
