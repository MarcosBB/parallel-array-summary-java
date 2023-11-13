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
        for (int i = 0; i < objectsQuantity; i++) {
            new Object(i);
        }
        System.out.println();

    }
}
