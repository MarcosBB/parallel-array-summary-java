import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int N = 0;
        int T = 0;

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

        long objectsQuantity = Math.round(Math.pow(10, N));

        System.out.println("Criando " + objectsQuantity + " objetos:");
        long objectsDivision = objectsQuantity / 10;
        List<CreationThread> threads = new ArrayList<CreationThread>();
        for (int i = 0; i < 10; i++) {
            System.out.println("criando thread para crianção de objetos " + (objectsDivision * i + 1) + " a "
                    + (objectsDivision * (i + 1)));
            threads.add(new CreationThread(i, objectsDivision * i + 1, objectsDivision * (i + 1)));
        }

        System.out.println("Iniciando threads:");
        for (CreationThread thread : threads) {
            thread.start();
        }

    }
}
