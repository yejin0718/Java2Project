package w0827;

import java.util.Random;

public class LAB {
    public static void main(String[] args) {
        String[] Arr = {"행동은 모든 성공의 기초이다.",
                        "오늘 할 수 있는 일을 내일로 미루지 마라.",
                        "포기하지 않는 사람이 결국 이긴다.",
                        "작은 변화가 큰 변화를 만든다.",
                        "실패는 성공으로 가는 디딤돌이다.",
                        "꾸준함이 재능을 이긴다.",
                        "성공은 준비된 자에게 온다.",
                        "시간은 누구에게나 공평하다.",
                        "시작이 반이다.",
                        "네가 할 수 있다고 믿으면 절반은 이룬 것이다."};

        Random random = new Random();

        int index = random.nextInt(Arr.length);

        System.out.println("오늘의 명언: " + Arr[index]);
    }
}
