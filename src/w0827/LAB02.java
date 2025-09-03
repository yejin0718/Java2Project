package w0827;

import java.util.Scanner;

public class LAB02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[5];
        double hap = 0.00;

        System.out.println("김연아 선수 경기 끝났습니다~~ 짝짝짝");

        for(int i=0; i<5; i++) {
            System.out.print("평가 점수==>");
            scores[i] = sc.nextInt();
        }
        for(int i=0; i<5; i++) {
            hap += (double) scores[i];
        }

        System.out.printf("심사위원 평균 점수 : %.2f",hap/5);

        sc.close();
    }
}
