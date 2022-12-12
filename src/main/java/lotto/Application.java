package lotto;

import lotto.service.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoController controller = new LottoController();
            controller.startLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
