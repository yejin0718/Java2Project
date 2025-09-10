package w0910;

import java.util.Scanner;

public class ParametaReturnTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        System.out.print("*첫번째 정수 입력: ");
        num1 = sc.nextInt();

        System.out.print("*두번째 정수 입력: ");
        num2 = sc.nextInt();

        Calc1 calc1 = new Calc1();
        int result = calc1.plus(num1, num2);
        System.out.println("덧셈결과 = " + result);
    }
}
