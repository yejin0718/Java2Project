package w0827;

public class gugudan {
    public static void main(String[] args) {
        int i, j;

        for(i=2; i<10; i++) {
            for(j=0; j<10; j++) {
                System.out.printf("%d * %d = %d\t", i, j, i*j);
            }
            System.out.println();
        }
    }
}
