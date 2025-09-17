package w0910;

public class ParametaReturnTest3 {
    public static void main(String[] args) {
        int[] nums = new int[5];

        for(int i = 0; i < nums.length; i++){
            nums[i] = i+1;
        }

        Calc1 calc1 = new Calc1();
        int result  = calc1.plus(nums);

        System.out.println("결과 값 = " + result);
    }
}
