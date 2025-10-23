package racingcar.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.message.ErrorMessage;
import racingcar.model.Car;
import racingcar.model.CarName;

public class MovingTest {
    @Test
    @DisplayName("예외: 랜덤 값이 음수일 경우")
    void InvalidRandomNumber_Minus_Fail() {
        assertThatThrownBy(()->Positions.moveForward(-2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_RANDOM_NUMBER_MINUS.message());
    }

    @ParameterizedTest(name = "[case : {0}]")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("정상: 4 이상으로 움직이는 경우")
    void moveForward_Go_Success(int randomNumber) {
        //given
        Car car = new Car(new CarName("Ayo"));
        //when
        car.moveForward(randomNumber);
        //then
        assertThat(car.position).isEqualTo(1);
    }

    @ParameterizedTest(name = "[case: {0}]")
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("정상: 4 미만으로 움직이지 않는 경우")
    void moveForward_Stop_Success(int randomNumber) {
        //given
        Car car = new Car(new CarName("Ayo"));
        //when
        car.moveForward(randomNumber);
        //then
        assertThat(car.position).isEqualTo(0);
    }


}
