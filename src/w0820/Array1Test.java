package w0820;

public class Array1Test {
    public static void main(String[] args) {
        int[] arr1 = new int[4];
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;
        arr1[3] = 40;

        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("arr1[%d] = %d\n", i , arr1[i]);
        }
        System.out.println("==================================");
        int[] arr2 = {1, 3, 5, 7};

        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("arr2[%d] = %d\n", i , arr2[i]);
        }


    }
}
