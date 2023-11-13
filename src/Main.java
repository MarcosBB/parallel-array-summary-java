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
        for (int i = 0; i < 10; i++) {
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

        System.out.println();
        System.out.println("Criando " + objectsQuantity + " objetos...");
        List<Object> objects = createObjects(objectsQuantity);
        System.out.println("Total de objetos criados: " + objects.size());

        System.out.println("Processando objetos...");
        ObjectsList objectsList = new ObjectsList(objects);
        List<ProcessingThread> processingThreads = new ArrayList<ProcessingThread>();
        double objectsDivision = objects.size() / T;

        for (int i = 0; i < T; i++) {
            int start = (int) objectsDivision * i;
            int end = (int) objectsDivision * (i + 1);
            if (i == T - 1) {
                end = objects.size();
            }

            List<Object> subset = objects.subList(start, end);
            processingThreads.add(new ProcessingThread(subset, objectsList));
        }

        for (ProcessingThread thread : processingThreads) {
            thread.start();
        }

        for (ProcessingThread thread : processingThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.exit(1);
            }
        }
        System.out.println();
        System.out.println("Total de objetos com valor menor que 5: " + objectsList.getLesThan5Quantity());
        System.out.println("Total de objetos com valor maior ou igual a 5: " + objectsList.getMoreThan5Quantity());
        System.out.println("Soma total dos valores dos objetos: " + objectsList.getTotalSum());

    }
}
