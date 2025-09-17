package w0910.lotto;

import java.util.ArrayList;

public class LottoTest {
    public static void main(String[] args) {
        System.out.println("** 로또 추첨을 시작합니다. **");
        ArrayList<Integer> lottoNums = new ArrayList<>();

        my_loop :
        while(true) {
            int idx = 0;
            Lotto lotto = new Lotto();
            int num = lotto.showLottoNumber();
            for(int i=0; i<lottoNums.size(); i++) {
                if(lottoNums.get(i) == num) {
                    continue my_loop;
                }
            }
//            lottoNums.get(idx) = num;
            idx++;
            if(lottoNums.size() == 6) break;
        }

        System.out.print("오늘의 로또 번호 ==> [");
        for(int i=0; i<lottoNums.size(); i++) {
            System.out.print(lottoNums.get(i));
            if(i != lottoNums.size()-1) System.out.print(", ");
        }
        System.out.print("]");
    }
}
