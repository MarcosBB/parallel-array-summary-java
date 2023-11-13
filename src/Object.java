public class Object {
    private long id;
    private int total;
    private float grupo;

    public Object(long id) {
        this.total = new java.util.Random().nextInt(10) + 1;
        this.grupo = new java.util.Random().nextFloat() * 4 + 1;
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public float getGrupo() {
        return grupo;
    }

    public long getId() {
        return id;
    }
}
