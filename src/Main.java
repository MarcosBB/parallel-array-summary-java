import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static int N;
    private static int T;

    private static void getArgs(String[] args) {
        try {
            N = Integer.parseInt(args[0]);
            T = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.out.println("Parâmetros inválidos. Utilize: java Main <N> <T> com N e T inteiros.");
            System.exit(1);
        }

        System.out.println("Parâmetros passados:");
        System.out.println("N = " + N);
        System.out.println("T = " + T);
    }

    private static List<Object> createObjects(long objectsQuantity) {
        long objectsDivision = objectsQuantity / 10;

        List<Object> objectsList = Collections.synchronizedList(new ArrayList<Object>());
        List<CreationThread> creationThreads = new ArrayList<CreationThread>();
        for (int i = 0; i < 100; i++) {
            creationThreads.add(new CreationThread(i, objectsDivision * i + 1, objectsDivision * (i + 1), objectsList));
        }

        for (CreationThread thread : creationThreads) {
            thread.start();
        }

        for (CreationThread thread : creationThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.exit(1);

            }
        }
        return objectsList;
    }

    public static void main(String[] args) {

        getArgs(args);
        long objectsQuantity = Math.round(Math.pow(10, N));
        List<Object> objects = createObjects(objectsQuantity);

        System.out.println("Criando " + objectsQuantity + " objetos:");
        createObjects(objectsQuantity);
        System.out.println("Total de objetos criados: " + objects.size());
    }
}
