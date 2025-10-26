package racingcar.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.message.ErrorMessage;
import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.Cars;

class CarsTest {
    @DisplayName("정상: 이름의 길이가 5이하인 경우")
    @Test
    void ValidName_Success() {
        //given
        Cars cars = Cars.createCarList("Ayo,Mike");
        //when
        Cars result = new Cars(List.of(
                new Car(new CarName("Ayo")),
                new Car(new CarName("Mike"))
        ));
        //then
        assertThat(cars.toString()).isEqualTo(result.toString());
    }

    @DisplayName("예외: 이름의 길이가 5초과인 경우")
    @Test
    void InvalidName_Long_Fail() {
        assertThatThrownBy(() -> Cars.createCarList("Racing"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NAME_LONG.message());
    }

    @DisplayName("예외: 이름에 빈 문자열, 공백이 들어오는 경우")
    @ParameterizedTest()
    @ValueSource(strings = {""," ","\n","Mike, Ayo"})
    void InvalidName_Blank_Fail(String name) {
        assertThatThrownBy(()-> Cars.createCarList(name))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NAME_BLANK.message());
    }

    @DisplayName("예외: 이름이 null인 경우")
    @Test
    void InvalidName_Null_Fail() {
        String name = null;
        assertThatThrownBy(() -> Cars.createCarList(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NAME_NULL.message());
    }

    @DisplayName("예외: , 가 아닌 다른 구분자인 경우")
    @Test
    void InvalidName_Not_Comma_Fail() {
        String name = "Ayo/Mike";
        assertThatThrownBy(()-> Cars.createCarList(name))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NAME_SPECIAL_CHARACTERS.message());
    }

    @DisplayName("예외: 이름에 , 만 적은 경우")
    @Test
    void InvalidName_No_Name_Fail() {
        String name = ",,,";
        assertThatThrownBy(()-> Cars.createCarList(name))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NAME_NO_NAME.message());
    }

    @DisplayName("예외: 이름에 , 가 연속인 경우")
    @Test
    void InvalidName_Sequence_Comma_Fail() {
        String name = "Mike,,Ayo";
        assertThatThrownBy(()-> Cars.createCarList(name))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NAME_SEQUENCE_COMMA.message());
    }

    @DisplayName("예외: 이름이 , 로 시작하거나 끝나는 경우")
    @ParameterizedTest(name = "[case: {0}]")
    @ValueSource(strings = {",Ayo,Mike","Mike,Ayo,",",Ayo,"})
    void InvalidName_Location_Comma_Fail(String name) {
        assertThatThrownBy(()-> Cars.createCarList(name))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NAME_LOCATION_COMMA.message());
    }
}
