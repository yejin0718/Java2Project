package w0903;

import java.util.Scanner;

public class CalcPlus {
    public static int plus(int num1, int num2) {
        int result = num1 + num2;

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("* 프로그램 종료를 원하면 정수1에 -1을 입력하시오");

            int num1, num2;

            System.out.print("* 정수1 입력:");
            num1 = sc.nextInt();
            if (num1 == -1) break;

            System.out.print("* 정수2 입력:");
            num2 = sc.nextInt();

            System.out.println(plus(num1, num2));
        }

        sc.close();
    }
}
