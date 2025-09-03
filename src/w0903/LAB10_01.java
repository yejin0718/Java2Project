package w0903;

import java.util.Scanner;

public class LAB10_01 {
    public static int calc(int num1, int num2, char oper) {
        int result = 0;

        switch (oper) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': result = num1 / num2; break;
            default: result = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num1, num2, result;
            char oper;

            System.out.println("* 프로그램 종료를 원하면 계산입력에 e를 입력하시오");

            System.out.print("* 계산 입력(+,-,*,/) : ");
            oper = sc.next().charAt(0);
            if (oper == 'e') break;

            System.out.print("* 정수1 입력: ");
            num1 = sc.nextInt();

            System.out.print("* 정수2 입력: ");
            num2 = sc.nextInt();

            result = calc(num1, num2, oper);
            System.out.println(result);
        }
        sc.close();

    }
}
