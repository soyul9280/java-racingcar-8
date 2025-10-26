package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Cars;

public class OutputView {
    private static String OUTPUT_GUIDE = "실행 결과";
    private static String WINNER_GUIDE = "최종 우승자 : %s";

    private OutputView() {
    }

    public static void markingCar(Cars cars) {
        System.out.println(OUTPUT_GUIDE);
        System.out.println(cars.toString());
    }

    public static void winner(List<String> winnerList) {
        String winners = String.join(",", winnerList);
        System.out.printf(WINNER_GUIDE, winners);
        Console.close();
    }
}
