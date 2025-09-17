package w0910.multi_return;

import java.util.Scanner;

public class Scan {

    public int[] Scan() {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];

        for(int i=0; i<3; i++) {
            System.out.printf("*정수%d 입력:", i+1);
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}
