package w0910.lotto;

import java.util.Random;

public class Lotto {
    public int showLottoNumber() {
        int lottoNum = (int)(Math.random() * 45 + 1);
        return lottoNum;
    }
}
