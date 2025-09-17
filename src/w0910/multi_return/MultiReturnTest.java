package w0910.multi_return;

import w0910.Calc1;

public class MultiReturnTest {
    public static void main(String[] args) {
        Scan scan = new Scan();
        int[] nums = scan.Scan();

        Calc1 calc = new Calc1();
        int result= calc.plus(nums);

        System.out.println("*합계: "+ result);
    }
}
