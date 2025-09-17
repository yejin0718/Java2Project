package w0910;

public class Calc1 {

    public int plus(int n1, int n2) {
        int result = n1 + n2;
        return result;
    }

    public int plus(int n1, int n2, int n3) {
        int result = n1 + n2 + n3;
        return result;
    }

    public int plus(int[] nums) {
        int result = 0;
        for(int i=0; i<nums.length; i++) {
            result += nums[i];
        }
        return result;
    }
}
