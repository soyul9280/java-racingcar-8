package racingcar.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarName;

public class WinnerTest {
    static Car ayo;
    static Car mike;
    static Car alice;

    @BeforeEach
    void setUpCar() {
        ayo = new Car(new CarName("Ayo"));
        mike = new Car(new CarName("Mike"));
        alice = new Car(new CarName("Alice"));
    }

    @Test
    @DisplayName("정상: 우승자가 1명인 경우 결과 1명")
    void winner_One_Success() {
        //given
        ayo.moveForward(5);
        ayo.moveForward(7);
        mike.moveForward(2);
        alice.moveForward(6);
        //when
        List<CarName> result= cars.getWinnerList();
        //then
        assertThat(result).containsExactly(ayo);
    }

    @Test
    @DisplayName("정상: 우승자가 2명인 경우 결과 2명")
    void winner_One_Success() {
        //given
        ayo.moveForward(5);
        ayo.moveForward(7);
        mike.moveForward(2);
        alice.moveForward(6);
        alice.moveForward(6);
        //when
        List<CarName> result= cars.getWinnerList();
        //then
        assertThat(result).containsExactly(ayo,alice);
    }

    @Test
    @DisplayName("정상: 우승자가 3명인 경우 결과 2명")
    void winner_One_Success() {
        //given
        ayo.moveForward(5);
        mike.moveForward(6);
        alice.moveForward(7);
        //when
        List<CarName> result= cars.getWinnerList();
        //then
        assertThat(result).containsExactly(ayo,mike,alice);
    }

}
